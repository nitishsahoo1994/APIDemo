package apiBasic;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import file.Payload;
import file.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


public class DynamicJson {
	
	
	@Test(dataProvider = "BookAdd")
	public static void addBook(String isbn,String aisle) {


		RestAssured.baseURI="http://216.10.245.166";
		String response= given().header("Content-Type","application/json").body(Payload.addBook(isbn,aisle)).
		when().post("/Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response().asString();
		
	
		
		
		JsonPath js = ReUsableMethods.rawToJson(response);
		System.out.println("added books are "+js.getString("ID"));
		List<String> books=new ArrayList<String>();
		books.add(js.getString("ID"));
		System.out.println(books);
		
		
		//delete all books
		
			String deleteRes= given().header("Content-Type","application/json").body("{\r\n"
					+ " \r\n"
					+ "\"ID\" : \""+(isbn+aisle)+"\"\r\n"
					+ " \r\n"
					+ "} \r\n"
					+ "").
			when().post("/Library/DeleteBook.php").
			then().extract().response().asString();
			System.out.println(deleteRes);
		
		
		
		
		
		
		
	}
		
	
	@DataProvider(name="BookAdd")
		
		public Object getData() {
			return new Object[][] {{"Saneep","9027"},{"Nitish","7027"},{"Biswa","8027"}};
		}
		
		
	}

	
	

	
