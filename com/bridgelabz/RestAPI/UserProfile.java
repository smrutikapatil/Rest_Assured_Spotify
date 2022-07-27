package com.bridgelabz.RestAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserProfile {

	public String token ="Bearer BQB5PJeA3BwSNvR2nE6SL-7l5B3AkiDYj0vtkhEojL-jf_ZbbudRZRNquIMlvzn7EyS3ebOkqozS9V09AkiqLZo1YeX6eMIB0u7b4iL7mMCCuv3EPHBCy_A1Rm8uB2YU8LM3nWB04dJ9sQG0lStKNx0Pa0qo1ZnHr2ukkASHcf-ew9tig6-rJbibIK4WBGia_LfYsLLrxYJ4q8po3yPDBrM_xQBXG8wEGT3Tk3sYTfrjqNk7c3M45VYEz7Ey8_Kz";
	String userID;
	String playlist_id = "6u2oBur0Rp9qpPKg9UhrZ8";

	@Test(priority = 0)
	public void getCurrentUserProfile() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET, "https://api.spotify.com/v1/me");

		userID = response.path("id");
		System.out.println("user ID:" + userID);

		response.prettyPrint();

		String statusLineString = response.statusLine();
		System.out.println("status Line:" + statusLineString);

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 1)
	public void getUserProfileId() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET, "https://api.spotify.com/v1/users/" + userID);

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 2)
	public void createPlaylist() {

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization",token);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "CQA_107Playlist1");
		jsonObject.put("description", "new playlist description");
		jsonObject.put("public", "false");

		requestSpecification.body(jsonObject.toJSONString());

		Response response = requestSpecification.request(Method.POST,
				"https://api.spotify.com/v1/users/31ffbbf7ww2ep3c5n3nbucxrtxy4/playlists");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 201);
	}

	@Test(priority = 3)
	public void GetUserPlaylist() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET,
				"https://api.spotify.com/v1/users/" + userID + "/playlists");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 4)
	public void AddItemsToPlaylist() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);
		requestSpecification.queryParam("uris", "spotify:track:5LYMamLv12UPbemOaTPyeV");

		Response response = requestSpecification.request(Method.POST,
				"https://api.spotify.com/v1/playlists/" + playlist_id + "/tracks");
		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 201);

	}

	@Test(priority = 5)
	public void GetPlaylist() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET,
				"https://api.spotify.com/v1/playlists/" + playlist_id + "");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 6)
	public void GetPlaylistItems() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET,
				"https://api.spotify.com/v1/playlists/" + playlist_id + "/tracks");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 7)

	public void GetPlaylistCoverImage() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET,
				"https://api.spotify.com/v1/playlists/" + playlist_id + "/images");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 8)

	public void GetCurrentUserPlaylists() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET, "https://api.spotify.com/v1/me/playlists");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 9)

	public void AddCustomPlaylistCoverImage() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET,
				"https://api.spotify.com/v1/playlists/" + playlist_id + "/images");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 10)
	public void UpdatePlaylistItems() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		requestSpecification.body("{\r\n" + "  \"range_start\": 1,\r\n" + "  \"insert_before\": 3,\r\n"
				+ "  \"range_length\": 2\r\n" + "}");

		Response response = requestSpecification.request(Method.PUT,
				"https://api.spotify.com/v1/playlists/" + playlist_id + "/tracks");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 11)
	public void ChangePlaylistDetails() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		requestSpecification.body("{\r\n" + "  \"name\": \"Updated Playlist Name\",\r\n"
				+ "  \"description\": \"Updated playlist description\",\r\n" + "  \"public\": false\r\n" + "}");

		Response response = requestSpecification.request(Method.PUT,
				"https://api.spotify.com/v1/playlists/" + playlist_id + "");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	
	@Test(priority = 12)
	public void RemovePlaylistItem() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);
		requestSpecification.body("{ \"tracks\": [{ \"uri\": \"spotify:track:5LYMamLv12UPbemOaTPyeV\" }] }");

		Response response = requestSpecification.request(Method.DELETE,
				"https://api.spotify.com/v1/playlists/" + playlist_id + "/tracks");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test (priority = 13)
	public void SearchForItem() {
	
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);
		requestSpecification.queryParam("q", "Arijit singh");
		requestSpecification.queryParam("type", "track"	);


		Response response = requestSpecification.request(Method.GET,
				"https://api.spotify.com/v1/search");

		response.prettyPrint();

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);

	}	 
}
