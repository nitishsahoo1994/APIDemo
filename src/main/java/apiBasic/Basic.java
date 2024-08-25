package apiBasic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import file.Payload;


public class Basic {
	public static void main(String[] args) {

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.addPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String placeId=js.getString("place_id");
		

		
		
		//update the place
		String newPlace="Dera Qr-No-A/198";
	String updateMSgCheck=	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").queryParam("place_id",""+placeId+"")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newPlace+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").
		when().put("maps/api/place/update/json").
		then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).extract().response().asString();
	
		System.out.println(updateMSgCheck);
		
		//get the place deatils
		String placeDetails=	given().log().all().queryParam("key", "qaclick123").queryParam("place_id",""+placeId+"").header("Content-Type","application/json")
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().header("Connection", "Keep-Alive").body("language", equalTo("English"))
		.extract().response().asString();
		
		JsonPath jpath=new JsonPath(placeDetails);
		String address=	jpath.getString("address");
		
		Assert.assertEquals(address, newPlace);
		
		
		
		
		
		
		
	}

}
