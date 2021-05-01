package com.shoaib.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestOnLocalAPI {

	@Test
	public void getTest(){
		
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.given().get("/users").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void postTest(){

		//Body
		JSONObject request = new JSONObject();
		request.put("firstName", "Sachin");
		request.put("lastName", "Tendulkar");
		request.put("subjectId", 1);

		RestAssured.baseURI = "http://localhost:3000";

		RestAssured.given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).body(request.toJSONString()).
		when().
		post("/users").
		then().statusCode(201).log().all();
	}
	
	@Test
	public void putTest(){

		//Body
		JSONObject request = new JSONObject();
		request.put("firstName", "Yuvraj");
		request.put("lastName", "singh");
		request.put("subjectId", 2);

		RestAssured.baseURI = "http://localhost:3000";

		RestAssured.given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).body(request.toJSONString()).
		when().
		put("/users/4").
		then().statusCode(200).log().all();
	}
	
	@Test
		public void patchTest(){

			//Body
			JSONObject request = new JSONObject();
		//	request.put("firstName", "Yuvraj");
			request.put("lastName", "Yograj");
		//	request.put("subjectId", 2);

			RestAssured.baseURI = "http://localhost:3000";

			RestAssured.given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(request.toJSONString()).
			when().
			patch("/users/4").
			then().statusCode(200).log().all();
		}
	
		@Test
		 public void delete(){
			
			RestAssured.baseURI = "http://localhost:3000";
			
			RestAssured.when()
			.delete("/users/4")
			.then().
			statusCode(200)
			.log().all();
			
		}
	
}
