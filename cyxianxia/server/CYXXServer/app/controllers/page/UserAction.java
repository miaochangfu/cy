package controllers.page;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.record.formula.functions.T;

import controllers.Application;
import models.Player;
import models.sys.SysMenu;
import models.sys.SysUser;
import play.Play;
import play.data.validation.MaxSize;
import play.libs.Files;
import service.bean.LayuiInfo;

/**
 * <p>Title: UserAction</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年8月14日-下午3:23:40</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
public class UserAction extends Application {
	
	 /**
     * 上传数据
     * @param openid
     * @param data
     */
    public static void playerUploadStatus(File file) {
    	
    	Map<String, String> res = new HashMap<String, String>();
    	try {
    		if( file != null ) {
    			 String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
    		     System.out.println(suffix);
    			 Files.copy(file, Play.getFile("public/file/mast_reward."+suffix));
    			 res.put("success", "/resources/file/mast_reward."+suffix);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	renderJSON(res);
    }
    
	
	/**
	 */
	public static void updatePlayerInfo( Long id , int score ) {
		
		try {
			if( id != null ) {
				Player player = Player.findById(id);
				if( player != null ) {
					player.setScore(score);
					player.save();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		renderJSON("success");
	}
	
	
	
	/***
	 * 登录
	 * login
	 * @param version
	 */
	public static void userLoginMain(@MaxSize(value = 10, message = "「name」必须6-10") String name,@MaxSize(value = 10, message = "「password」必须6-10") String password) {
		try {
			if( name != null && password != null ){
				SysUser sysUser = SysUser.find("user_name=? and user_pass=? ", name , password).first();
				if( sysUser != null ){
					session.put("sessionname", name);
					session.put("adminId", sysUser.id+"" );
					session.put("tokenId", UUID.randomUUID());
					redirect("/adminIndex");
				}
			}else {
				render(USERLOGINURL_STRING);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		render(USERLOGINURL_STRING);
	}
	
	
	/**
	 */
	public static void adminIndex() {
		
		try {
			
			List<SysMenu> listSysMenu = SysMenu.find(" parent_code=0 ").query.getResultList();
			List<SysMenu> listSysMenuAll = SysMenu.find("order by parent_code ASC , level ASC , sort ASC " ).query.getResultList();
			render( listSysMenu , listSysMenuAll );
		} catch (Exception e) {
			e.printStackTrace();
		}
		render();
	}
	
	
	/**
	 */
	public static void userInfoView() {
		render();
	}
	
	
	/**
	 */
	public static void userInfo( Integer page  , String findName , String findPass_str , String findAddress  , Long pkId ) {
		
		try {
			
			if(!Application.sessionname()){
				render(USERLOGINURL_STRING);
			}
			if (page == null || page.equals("") || page <= 0) {
				page = 1;
			}
			int pageSize = Application.DEFAULT_PAGE_SIZE;
			List<T> listPlayer = null;
			long resultCount = 0;
			if( findName != null && !"".equals(findName) ) {
				resultCount = Player.count("nickname=?" , findName);
				listPlayer = Player.find("nickname=?" , findName).query.setFirstResult((page-1)*Application.DEFAULT_PAGE_SIZE).setMaxResults(pageSize).getResultList();
			} else if( findPass_str != null && !"".equals(findPass_str) ) {
				resultCount = Player.count("pass_str=?" , findPass_str);
				listPlayer = Player.find("pass_str=?" , findPass_str).query.setFirstResult((page-1)*Application.DEFAULT_PAGE_SIZE).setMaxResults(pageSize).getResultList();
			}else if( findAddress != null && !"".equals(findAddress) ) {
				resultCount = Player.count("address like ?",new String("%"+findAddress+"%"));
				listPlayer = Player.find("address like ?",new String("%"+findAddress+"%")).query.setFirstResult((page-1)*Application.DEFAULT_PAGE_SIZE).setMaxResults(pageSize).getResultList();
			}else if( pkId != null && !"".equals(pkId) ) {
				listPlayer = Player.find(" id=?" , pkId ).query.getResultList();
				if( listPlayer != null ) {
					resultCount = listPlayer.size();
				}
			}else {
				resultCount = Player.count();
				listPlayer = Player.find(" 1=1 ").query.setFirstResult((page-1)*Application.DEFAULT_PAGE_SIZE).setMaxResults(pageSize).getResultList();
			}
			LayuiInfo layuiDate = new LayuiInfo();
			layuiDate.setCode(0);
			layuiDate.setMsg("mes");
			layuiDate.setCount(resultCount);
			layuiDate.setListDate( listPlayer );
			renderJSON(layuiDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
