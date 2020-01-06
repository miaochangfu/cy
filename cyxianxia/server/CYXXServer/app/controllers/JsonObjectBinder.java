package controllers;

import java.lang.reflect.Type;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import config.GameStatus;
import message.APIResponse;
import message.ResultByJson;
import message.SystemError;
import play.Logger;
import play.data.binding.Global;
import play.data.binding.TypeBinder;
import play.mvc.Controller;
import sun.misc.BASE64Decoder;

@Global
public class JsonObjectBinder extends Controller implements TypeBinder<JsonObject> {

	public Object bind(String name,java.lang.annotation.Annotation[] annotations, String value,Class actualClass, Type genericType) throws Exception {
		if( value == null || "".equals(value) || null == value ){
			ResultByJson resultByJson = new ResultByJson();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
	    	renderJSON(resultByJson);
		}
		if( GameStatus.isLog ) {
			Logger.info("JsonObjectBinder:"+value);
		}
		if( GameStatus.isSecret ) {
			value =  new String(new BASE64Decoder().decodeBuffer(value.substring(1, value.length())), "UTF-8");
			Logger.info("JsonObjectBinder:"+value);
		}
		return new JsonParser().parse(value);
	}

}