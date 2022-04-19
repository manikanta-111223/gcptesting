package com.io.openapi.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Util {

	public static String lookupErrorMessage(String property, String msg_code) {

		String errJson = null;
		String errcode;
		String err400 = null;
		JSONObject jsonObject;
		try {
			errJson = new String(Files.readAllBytes(Paths.get("error.json")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
	    jsonObject = new JSONObject(errJson);
	    
	    JSONArray errors = jsonObject.getJSONArray("errors");
	    Map<String, String> errorIdMap = new HashMap<>();

				
	    for (int i = 0; i < errors.length(); i++) {
	    	JSONObject error = (JSONObject)errors.get(i);
	    	errorIdMap.put(error.get("id").toString(), error.get("description").toString());
	    	
	     
	    }
	 
	    errcode = (String) errorIdMap.get(msg_code);
	    err400 = property.concat(": ").concat(errcode);
		
		}catch(JSONException e) {
			e.printStackTrace();
			
		}
		
		return err400;
	
	}

}