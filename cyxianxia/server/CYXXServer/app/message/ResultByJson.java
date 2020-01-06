package message;

import java.io.Serializable;
import java.util.List;

import models.LogPlayerCoinStatus;
import models.LogPlayerScoreStatus;
import models.MastLottery;
import models.MastShop;
import models.PlayerSetInfo;
import models.PlayerTask;
import res.webapi.PlayerFriendRequestRes;
import res.webapi.PlayerFriendRes;
import res.webapi.PlayerGameOverRes;
import res.webapi.PlayerGameQuestionItemRes;
import res.webapi.PlayerGameQuestionRes;
import res.webapi.PlayerRankingRes;
import res.webapi.PlayerRes;
import service.websocket.PlayerRoomBean;
import service.websocket.SystemRoomBean;
import utils.CommonUtil;
import utils.weifutong.PayInfo;
import weixin.vo.WxParam;

/**
 * <p>Title: ResultByJson</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月10日-下午12:28:51</p>
 * <p>version 1.0</p>
 * <p>Description: 返回对象 </p>
 */
public class ResultByJson<T> extends APIResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Integer getValue;
	
	public Integer isOpenShare;
	
	public Integer lastMyIndex;
	
	public String message;
	
	public String session_key;
	
	public String unionid;
	
	public Long  sys_time;
	
	public Integer page;
	
	/** 注册完给用户一个playerId **/
	public Long playerId;
	
	/** 注册完给用户一个openid **/
	public String openid;
	
	public Integer appResult;
	
	public Long pkId;
	
	public String weiXinUrl;
	
	public PayInfo payInfo;
	
	public PlayerRes playerRes;
	
	public WxParam wxparam;
	
	public MastLottery mastLottery;
	
	public PlayerSetInfo playerSetInfo;
	
	//排行榜单的数据
	public List<PlayerRankingRes> playerRankingListRes;
	
	public List<PlayerRankingRes> listRankingRes;
	
	public List<PlayerTask> playerTaskList;
	
	public List<PlayerFriendRes> listFriendListRes;
	
	public List<PlayerFriendRequestRes> listFriendRequestRes;
	
	public List<MastLottery> listMastLottery;
	
	public PlayerRoomBean roomBean;
	
	public SystemRoomBean systemRoomBean;
	
	//自己排名数据
	public PlayerRankingRes myPlayerRankingRes;
	
	public List<PlayerGameQuestionRes> listPlayerQuestion;
	
	public PlayerGameQuestionRes gameQuestionRes;
	
	public List<PlayerGameQuestionItemRes> listItemRes;
	
	public List<PlayerGameOverRes>  listGameOverRes;
	
	public List<PlayerGameQuestionItemRes> questionItems;
	
	public List<MastShop> listMastShop;
	
	public  List<LogPlayerCoinStatus> listLogPlayerCoin;
	
	public  List<LogPlayerScoreStatus> listLogPlayerScore;
	
	public List<PlayerRoomBean> listFriendRoomBean;
	
	public ResultByJson() {
		this.sys_time = CommonUtil.getByTimestamp().getTime();
	}
	
	public ResultByJson( String method ) {
		super.method = method;
	}
	
}
