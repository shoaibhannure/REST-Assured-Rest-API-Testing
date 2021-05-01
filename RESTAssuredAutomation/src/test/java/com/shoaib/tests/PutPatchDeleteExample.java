package com.shoaib.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutPatchDeleteExample {
	@Test(priority=1)
	public void putExample() {

		JSONObject request = new JSONObject();
		request.put("name", "Shoaib");
		request.put("job", "Automation Tester");

		System.out.println(request.toJSONString());

		RestAssured.baseURI = "https://reqres.in/api";

		RestAssured.given().
		// header("Content-Type","application/json").
		// Explicitly telling the server that the content I am sending is of
		// type JSON
		// And response that i will accept should also be of JSON
				contentType(ContentType.JSON).
				  accept(ContentType.JSON).
				body(request.toJSONString()).
				  when(). 
				put("/users/2"). 
				  then().
				statusCode(200). 
				  log().all();

	}

	
	@Test (priority=2)
	public void patchExample() {

		JSONObject request = new JSONObject();
		request.put("name", "Shoaib");
		request.put("job", "Automation Tester");

		System.out.println(request.toJSONString());

		RestAssured.baseURI = "https://reqres.in";

		RestAssured.given().
		// header("Content-Type","application/json").
		// Explicitly telling the server that the content I am sending is of
		// type JSON
		// And response that i will accept should also be of JSON
				contentType(ContentType.JSON).
				  accept(ContentType.JSON).
				body(request.toJSONString()).
				  when(). 
				patch("/api/users/2"). 
				  then().
				statusCode(200). 
				  log().all();

	}
	
	@Test (priority=3)
	public void deleteExample() {
// We don't need body for delete operation
//		JSONObject request = new JSONObject();
//		request.put("name", "Shoaib");
//		request.put("job", "Automation Tester");
//
//		System.out.println(request.toJSONString());

		RestAssured.baseURI = "https://reqres.in";

		RestAssured.given().
		// header("Content-Type","application/json").
		// Explicitly telling the server that the content I am sending is of
		// type JSON
		// And response that i will accept should also be of JSON
//				contentType(ContentType.JSON).
//				  accept(ContentType.JSON).
//				body(request.toJSONString()).
				  when(). 
				delete("/api/users/2"). 
				  then().
				statusCode(204). 
				  log().all();

	}
}
