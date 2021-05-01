package com.shoaib.tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

public class GetAndPostRequests {

	@Test
	public void getExample(){
		RestAssured.baseURI="https://reqres.in/api";
		//In get()method give rest of end point of URL 		
		RestAssured.given().
		get("users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name", Matchers.equalTo("George")).
		//body("data.first_name", Matchers.hasItem("George", "Rachel"));
		body("data.first_name", Matchers.hasItems("George", "Rachel"));
		
	}
	
	@Test
	public void postExample(){
		//In Map give data type of Key & Value
		//Here data type of key is String and Value is Object so that it can take any value
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Shoaib");
//		map.put("job", "Automation Tester");
		
		System.out.println(map);
		
		//JSONObject request = new JSONObject();
		//Put Map in JSON Object
		JSONObject request = new JSONObject(map);
		request.put("name", "Shoaib");
		request.put("job", "Automation Tester");
		
		System.out.println(request.toJSONString());
		
		RestAssured.baseURI="https://reqres.in/api";
		
		RestAssured.given().
		 // header("Content-Type","application/json").
		//Explicitly telling the server that the content I am sending is of type JSON
		//And response that i will accept should also be of JSON
		contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		body(request.toJSONString()).
		  when().
		post("/users").
		  then().
		statusCode(201).
		  log().all();
		
		
	}
}
