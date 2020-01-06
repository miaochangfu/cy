package controllers;

import com.google.gson.Gson;

import config.GameStatus;
import play.Logger;
import play.mvc.Controller;

public class BaseController extends Controller{

	 /**
     * Render a 200 OK application/json response
     * @param o The Java object to serialize
     */
    protected static void outputJSON(Object o) {
    	
    	if( GameStatus.isLog ) {
    		Logger.info(new Gson().toJson(o));
    	}
    	response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE");
		response.setHeader("Access-Control-Allow-Headers", "cache-control,content-type,hash-referer,x-requested-with");
    	response.accessControl("*", "GET,PUT,POST,DELETE", true);
    	renderJSON(o);
    }
    
}
