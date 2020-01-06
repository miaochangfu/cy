package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import models.MastQuestion;

public class TestDemo {
	
	public TestDemo() {
		 String s = readJsonFile("C:\\Users\\Admin\\Desktop\\cy-wordInfo.json");
	        JSONArray jobj = JSONArray.parseArray(s);
			for (int i = 0; i < jobj.size(); i++) {
				JSONObject jsonObject = (JSONObject) jobj.get(i);
				
				//map对象
				Map<String, MastQuestion> data =new HashMap<String, MastQuestion>();
				Iterator it = jsonObject.keySet().iterator();
				// 遍历jsonObject数据，添加到Map对象
				while (it.hasNext()) {
					String key = String.valueOf(it.next()).toString();
					String value = (String) jsonObject.get(key).toString();
					MastQuestion jsonMode = new Gson().fromJson(value, MastQuestion.class);
					data.put(key, jsonMode);
				}
				for(Map.Entry<String, MastQuestion> entry : data.entrySet()){
					MastQuestion mapValue = entry.getValue();
					mapValue.save();
				    System.out.println(mapValue.getWord()+"\t"+mapValue.getPron()+"\t"+mapValue.getExpl()+"\t"+mapValue.getSource());
				}
			}
	}
	/**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    	
}
