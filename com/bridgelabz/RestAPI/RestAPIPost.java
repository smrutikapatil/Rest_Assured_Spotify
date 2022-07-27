package com.bridgelabz.RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIPost {

	@Test(priority = 0)
	public void getPosts() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");

		Response response = requestSpecification.request(Method.GET, "http://localhost:3000/posts");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 1)
	public void createPosts() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body("{ \"id\": 7, \"title\": \"json-server\", \"author\": \"typicode\"}");

		Response response = requestSpecification.request(Method.POST, "http://localhost:3000/posts");

		response.prettyPrint();
		
		String title = response.path("title");
		System.out.println("title is:"+ title);
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 201);
	}

	@Test(priority = 2)
	public void updatePosts() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body("{ \"id\": 4, \"title\": \"java application\", \"author\": \"typicode\"}");

		Response response = requestSpecification.request(Method.PUT, "http://localhost:3000/posts/4");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 3)
	public void deletePosts() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");

		Response response = requestSpecification.request(Method.DELETE, "http://localhost:3000/posts/4");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 4)
	public void getPostsOfId() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.queryParam("id", 2);

		Response response = requestSpecification.request(Method.GET, "http://localhost:3000/posts");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 5)
	public void getPostsOfID() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.pathParam("id", 3);

		Response response = requestSpecification.request(Method.GET, "http://localhost:3000/posts?id={id}");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
