package controllers;

import static play.mvc.Http.WebSocketEvent.SocketClosed;
import static play.mvc.Http.WebSocketEvent.TextFrame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cache.CacheKey;
import cache.RemoteCache;
import config.GameStatus;
import message.ChatRoom;
import message.RequestParameters;
import play.Logger;
import play.libs.F.Either;
import play.libs.F.EventStream;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.WebSocketClose;
import play.mvc.Http.WebSocketEvent;
import play.mvc.WebSocketController;
import service.websocket.PlayerRoomBean;
import service.websocket.PlayerWebTcpService;

public class WebSocket extends Controller {
    
    public static class ChatRoomSocket extends WebSocketController {
        
		public static void join( final Long playerId) {
        	
			try {
				
				ChatRoom room = ChatRoom.get();
	            // Socket connected, join the chat room
	            EventStream<ChatRoom.Event> roomMessagesStream = room.join(playerId  );
	            // Loop while the socket is open
	            while(inbound.isOpen()) {
	                
	            	if( playerId == null ||  null == playerId  || playerId.equals("undefined")  ){
	            		continue;
	            	}
	            	if( ChatRoom.map.get(playerId) == null || !ChatRoom.map.get(playerId).current.get().equals(outbound.current.get())) {
	            		ChatRoom.map.put(playerId, outbound);
	               	   Logger.info("------------inbound.isOpen()-------------"+ChatRoom.map.size());
	            	}
	            	
	                // Wait for an event (either something coming on the inbound socket channel, or ChatRoom messages)
	                Either<WebSocketEvent,ChatRoom.Event> e = await(Promise.waitEither(
	                    inbound.nextEvent(), 
	                    roomMessagesStream.nextEvent()
	                ));
	                
	                // Case: TextEvent received on the socket
	                for(String userMessage: TextFrame.match(e._1)) {
						room.say(playerId, userMessage );
	                }
	                
	                // Case: The socket has been closed
	                for(WebSocketClose closed: SocketClosed.match(e._1)) {
	                    closedWebSocket( playerId );
	                    disconnect();
	                }
	            }
			} catch (Exception e) {
				if( playerId != null ) {
					closedWebSocket( playerId );
				}
				Logger.info("join error:"+e.getMessage());
			}
        }
       
    }
    
	public static boolean closedWebSocket( Long playerId ) {
		try {
			
			Logger.info("-----------closedWebSocket-------------"+playerId);
			
			Http.Outbound outbound = ChatRoom.map.get(playerId);
			if( outbound != null ) {
				outbound.close();
			}
			ChatRoom.map.remove(playerId);
			if( playerId != null ) {
				RequestParameters json = new RequestParameters();
				json.playerId = playerId;
				new PlayerWebTcpService().gameExit(json);
				
//				Map<Long, List<PlayerRoomBean> > listMap = GameStatus.friendInviteMap;
//	    		if( listMap != null ) {
//	    			List<PlayerRoomBean> list = listMap.get( playerId );
//	    			if( list != null ) {
//	    				for ( PlayerRoomBean playerRoomBean : list ) {
//	    					RemoteCache.delete( CacheKey.getFriendPVPCacheKey( playerRoomBean.getPlayerId() ) );
//	    					RemoteCache.delete( CacheKey.getPlayerRoomBeanCacheKey( playerRoomBean.getPlayerId() ) );
//						}
//	    			}
//	    		}
				if( GameStatus.friendInviteMap != null ) {
					GameStatus.friendInviteMap.remove( playerId );
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    
}

