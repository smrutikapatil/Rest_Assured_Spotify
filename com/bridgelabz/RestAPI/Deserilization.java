package com.bridgelabz.RestAPI;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;

public class Deserilization {
	@Test

	public void deserilization() throws JsonProcessingException {

		// json to pojo deserilization
		// retrive pojo for one part

		String urlString = "http://localhost:3000/posts/17";

		BlogPosts blogPosts17 = RestAssured.given().get(urlString).as(BlogPosts.class);
		System.out.println("ssp17:" + blogPosts17.toString());

	}
}
