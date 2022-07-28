package com.bridgelabz.RestAPI;

import java.lang.reflect.Type;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import io.restassured.RestAssured;

public class Deserilization {
	@Test

	public void deserilization() throws JsonProcessingException {

		// json to pojo deserilization
		// retrive pojo for one part

		String urlString = "http://localhost:3000/posts/17";

		BlogPosts blogPosts17 = RestAssured.given()
					           .get(urlString)
        					   .as(BlogPosts.class);

		System.out.println("javaobject:" + blogPosts17);

		String urlString1 = "http://localhost:3000/posts";
		
		Type type = new TypeReference<List<BlogPosts>>() {}.getType();
		
		List<BlogPosts> blogPostsList = RestAssured.get(urlString1)
				                           .as(type);

		System.out.println("javaobject1:" + blogPostsList);
	}
}
