package message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;

import config.GameStatus;
import controllers.WebSocket;
import enu.GameMethodEnum;
import play.Logger;
import play.libs.F.ArchivedEventStream;
import play.libs.F.EventStream;
import play.libs.F.IndexedEvent;
import play.libs.F.Promise;
import play.mvc.Http;
import service.websocket.PlayerWebTcpService;

public class ChatRoom {
    
	public static Map<Long, Http.Outbound>  map = new HashMap<Long, Http.Outbound>();
	
    // ~~~~~~~~~ Let's chat! 
    
	public static ArchivedEventStream<ChatRoom.Event> chatEvents = new ArchivedEventStream<ChatRoom.Event>(5000);
    
    /**
     * For WebSocket, when a user join the room we return a continuous event stream
     * of ChatEvent
     */
    public EventStream<ChatRoom.Event> join(Long playerId) {
        chatEvents.publish(new Join(playerId));
        return chatEvents.eventStream();
    }
    
    /**
     * A user say something on the room
     */
    public void say(Long playerId, String text) {
        if(text == null || text.trim().equals("")) {
            return;
        }
        if( ChatRoom.map.get(playerId) != null ) {
        	
        	try {
        		text = text.replace("NaN", "0");
        		Logger.info("-------------text------------->"+text);
        		if( text.equals("undefined") ) {
        			return;
        		}
        		Gson gson = new Gson();
               	RequestParameters json = gson.fromJson(text, RequestParameters.class);
               	if( null == json || json.method == null || json.playerId == null ) {
               		ResultByJson resultByJson = new ResultByJson(json.method);
               		resultByJson.status = APIResponse.STATUS_NG;
       				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
       				ChatRoom.map.get(json.playerId).sendJson(resultByJson);
       				return;
               	}
               	if( !ChatRoom.map.get(playerId).isOpen()){
               		ChatRoom.map.remove(playerId);
               		return;
               	}
               	//逻辑处理
               	GameMethodEnum gameMethodEnum = GameMethodEnum.getByLabel( json.method );
               	if( gameMethodEnum == null ){
               		ResultByJson resultByJson = new ResultByJson(json.method);
               		resultByJson.status = APIResponse.STATUS_NG;
       				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
       				ChatRoom.map.get(playerId).sendJson(resultByJson);
       				return;
               	}
               	
                //method_pingWebSocket
               	if( gameMethodEnum.getValue() == 999 ) {
               		ResultByJson resultByJson = new ResultByJson(json.method);
               		resultByJson.pkId = json.pkId;
               		ChatRoom.map.get(playerId).sendJson( resultByJson );
       				return;
               	}
            
		       	//加入游戏
		       	if( gameMethodEnum.getValue() == 500 ) {
		       		Http.Outbound outbound = ChatRoom.map.get(playerId);
		       		if( outbound != null ) {
		       			ChatRoom.map.get(playerId).sendJson( new PlayerWebTcpService().gameInit(json) );
		       		}
		       		return;
		       	}
		       	
		    	//
		       	if( gameMethodEnum.getValue() == 504 ) {
		       		Http.Outbound outbound = ChatRoom.map.get(playerId);
		       		if( outbound != null ) {
		       			ChatRoom.map.get(playerId).sendJson( new PlayerWebTcpService().playerGameSayMeaage(json) );
		       		}
		       		return;
		       	}
		       	
		       	//
		       	if( gameMethodEnum.getValue() == 509 ) {
		       		Http.Outbound outbound = ChatRoom.map.get(playerId);
		       		if( outbound != null ) {
		       			ChatRoom.map.get(playerId).sendJson( new PlayerWebTcpService().gameExit(json) );
		       		}
		       		return;
		       	}
		       	
		       	//
		       	if( gameMethodEnum.getValue() == 503 ) {
		       		Http.Outbound outbound = ChatRoom.map.get(playerId);
		       		if( outbound != null ) {
		       			ChatRoom.map.get(playerId).sendJson( new PlayerWebTcpService().gameCall(json) );
		       		}
		       		return;
		       	}
		       	
			} catch (Exception e) {
				e.printStackTrace();
			}
//        	ChatRoom.map.get(playerId).send("message:%s:%s", playerId, text);
        }else {
        	System.err.println( "WebSocket.map.get(playerId) == null " );
        }
//        chatEvents.publish(new Message(playerId, text));
    }
    
    /**
     * For long polling, as we are sometimes disconnected, we need to pass 
     * the last event seen id, to be sure to not miss any message
     */
    public Promise<List<IndexedEvent<ChatRoom.Event>>> nextMessages(long lastReceived) {
        return chatEvents.nextEvents(lastReceived);
    }
    
    /**
     * For active refresh, we need to retrieve the whole message archive at
     * each refresh
     */
    public List<ChatRoom.Event> archive() {
        return chatEvents.archive();
    }
    
    public static void notifyAll( ResultByJson  resultByJson) {
		for (Entry<Long, Http.Outbound> entry : map.entrySet()) {
			entry.getValue().sendJson(resultByJson);
		}
    }
    
    
    public static void notifyList( List<Long> playerIds , ResultByJson  resultByJson) {
    	for ( Long long1 : playerIds ) {
    		Http.Outbound channel = map.get(long1);
        	if( null != channel ) {
        		channel.sendJson(resultByJson);
        	}
		}
    }
    
    
    public static void sendMessage( Long playerId, ResultByJson resultByJson) {
    	Http.Outbound channel = map.get(playerId);
    	try {
        	if( null != channel ) {
        		if( GameStatus.isLog ) {
        			Logger.info("GameMethodEnum-->" + resultByJson.method+"\t playerId-->"+playerId+"\t --->"+new Gson().toJson(resultByJson) );
        		}
        		channel.sendJson(resultByJson);
        	}
		} catch (java.lang.IllegalStateException e) {
			WebSocket.closedWebSocket( playerId );
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    public static void sendMessage( Long playerId, String message ) {
    	Http.Outbound channel = map.get(playerId);
    	try {
        	if( null != channel ) {
        		if( GameStatus.isLog ) {
        			Logger.info("GameMethodEnum-->" + message );
        		}
        		channel.send(message);
        	}
		} catch (java.lang.IllegalStateException e) {
			WebSocket.closedWebSocket( playerId );
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    // ~~~~~~~~~ Chat room events

    public static abstract class Event {
        
        final public String type;
        final public Long timestamp;
        
        public Event(String type) {
            this.type = type;
            this.timestamp = System.currentTimeMillis();
        }
        
    }
    
    public static class Join extends Event {
        
        final public Long playerId;
        
        public Join(Long playerId) {
            super("join");
            this.playerId = playerId;
        }
        
    }
    
    public static class Message extends Event {
        
        final public Long playerId;
        final public ResultByJson resultByJson;
        
        public Message(Long playerId, ResultByJson resultByJson) {
            super("message");
            this.playerId = playerId;
            this.resultByJson = resultByJson;
        }
        
    }
    
    // ~~~~~~~~~ Chat room factory

    static ChatRoom instance = null;
    public static ChatRoom get() {
        if(instance == null) {
            instance = new ChatRoom();
        }
        return instance;
    }
    
}

