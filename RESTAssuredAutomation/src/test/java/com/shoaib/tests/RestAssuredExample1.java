package com.shoaib.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class RestAssuredExample1 {

	@Test
	public void restAssuredExample1() {
		// RestAssured is a class
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		long responseTime = response.getTime();
		System.out.println(responseTime);

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		String statusLine = response.getStatusLine();
		System.out.println(statusLine);

		String getHeader = response.getHeader("content-type");
		System.out.println(getHeader);

		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void restAssuredExample2(){
		RestAssured.baseURI="https://reqres.in/api";
		//In get()method give rest of end point of URL 		
		RestAssured.given().
		get("users?page=2").
		then().
		statusCode(200).body("data[1].id", Matchers.equalTo(8)).
		log().all();
		
		
	}
}
