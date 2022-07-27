package com.bridgelabz.RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIComments {

	@Test(priority = 0)
	public void getPosts() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");

		Response response = requestSpecification.request(Method.GET, "http://localhost:3000/comments");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 1)
	public void createPosts() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body("{ \"id\": 3, \"body\": \"java application program\", \"postId\": \"3\"}");

		Response response = requestSpecification.request(Method.POST, "http://localhost:3000/comments");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 201);
	}

	@Test(priority = 2)
	public void updatePosts() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body("{ \"id\": 2, \"body\": \"API testing\", \"postId\": \"2\"}");

		Response response = requestSpecification.request(Method.PUT, "http://localhost:3000/comments/2");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 3)
	public void deletePosts() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");

		Response response = requestSpecification.request(Method.DELETE, "http://localhost:3000/comments/3");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
