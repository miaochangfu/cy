package controllers;

import service.api.WeiXingStatusService;

/**
 * <p>Title: Application</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月12日-下午8:14:10</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
public class Application extends BaseController {
  
	public static int count  = 0;
	
	public static int DEFAULT_PAGE_SIZE  = 10;
	
	public static final  String USERLOGINURL_STRING = "/page/UserAction/userLogin.html";
	
    public  static void index( Long playerId ) {
    	if( playerId != null ) {
//    		new TestDemo();
//    		WeiXingStatusService.getEncryptJsapiTicket("");
//    		WeiXingStatusService.zhuangZhang("oOUR-jkPWaxwbc5-9QdoWAlWUQgA" ,1 , 3L ,"测试");
    	}
//    	render(USERLOGINURL_STRING);
    }
 
    public static boolean  sessionname() {
		if(session.get("sessionname")==null){
			return false ;
		}
		return true ;
	}
    
}
