package apiBasic;

import org.testng.annotations.Test;


import io.restassured.path.json.JsonPath;
import pojo.GetCourses;
import pojo.WebAutomation;

import static io.restassured.RestAssured.*;

import java.util.List;

public class OAuthTest {
	
	
	@Test
	public static void oAuthCall() {
		
		
		String response=given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
		formParam("grant_type", "client_credentials").formParam("scope", "trust").
		when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").
		then().extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		String access_token=js.getString("access_token");
		//System.out.println(access_token);
		
		GetCourses gc=given().queryParam("access_token", access_token).
		when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").
		as(GetCourses.class);
		
		System.out.println("Instructor name is: "+gc.getInstructor());
		
		List<WebAutomation> webAuto=gc.getCourses().getWebAutomation();
		System.out.println(webAuto.size());
		
		for(int i=0;i<webAuto.size();i++) {
			if(webAuto.get(i).getCourseTitle().equalsIgnoreCase("Selenium Webdriver Java"))
				System.out.println("price of Selenium webdriver is : "+webAuto.get(i).getPrice());
		}
		
		
		
		//print all the course name
		
		
		
		
		for(WebAutomation ele:webAuto) {
			System.out.println(ele.getCourseTitle());
		}
	}

}
