package com.example.SimpleServer.resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class UserResource extends ServerResource {

	/*
	@Override
	public void doInit()
	{
	    userId = Integer.parseInt("" + getRequestAttributes().get("id"));
	    repeatAmount = Integer.parseInt("" + getRequestAttributes().get("count"));
	}
	*/
	
	/**
	 * This handles the generic GET user list
	 */
	@Get
	public String toString() {
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObj = new JSONObject();

		int userId = 0;
		Object obj = getRequestAttributes().get("id");
		if (obj != null)
			userId = Integer.parseInt(obj.toString());

		try {
			if (userId > 0) {
				jsonObj.put("firstName", "Blake");
				jsonObj.put("lastName", "Snake");
				return jsonObj.toString();
			} else {
				jsonObj.put("firstName", "Fred");
				jsonObj.put("lastName", "Jones");
				jsonArr.put(jsonObj);
				jsonObj = new JSONObject();
				jsonObj.put("firstName", "Mike");
				jsonObj.put("lastName", "Smith");
				jsonArr.put(jsonObj);

				return jsonArr.toString();
			}
		} catch (Exception e) {
			System.out.println("Unable to setup JSON response");
		}
		
		try {
			jsonObj.put("response", "404");
		} catch (Exception e) {
			System.out.println("Unable to log error :-)");
		}
		return jsonObj.toString();
	}
	
	/**
	 * This handles the requests for specific users
	 */
}
