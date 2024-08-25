package apiBasic;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.LoginDetails;
import pojo.Orders;
import pojo.OrederDetails;
import pojo.ProductDetails;
import pojo.TokenDetails;

public class eCommerce {
	
	
	@Test
	public static void login() {
		
		String baseUri="https://rahulshettyacademy.com";
		RequestSpecification rqsbase=new RequestSpecBuilder().
				setBaseUri(baseUri).setContentType(ContentType.JSON).build();
		LoginDetails loginEcom=new LoginDetails();
		loginEcom.setUserEmail("nitishsahoo05104@yahoo.com");
		loginEcom.setUserPassword("SAG@0202#$3cur3d");
		
		
		RequestSpecification req=given().spec(rqsbase).body(loginEcom);
		ResponseSpecification responseSpecification=new ResponseSpecBuilder().expectStatusCode(200).build();
		TokenDetails td=req.when().post("/api/ecom/auth/login").then().log().all()
				.spec(responseSpecification).extract().as(TokenDetails.class);
		
		String token=td.getToken();
		String userId=td.getUserId();
		
		
		//Add product
		
		RequestSpecification addSpec=new RequestSpecBuilder().
			setBaseUri(baseUri).addHeader("Authorization", token).build();
		
		
		RequestSpecification addSpecExact=given().spec(addSpec).param("productName", "Laptop").
		param("productAddedBy", userId).
		param("productCategory", "Electronics").
		param("productSubCategory", "lap").
		param("productPrice", "25000").
		param("productDescription", "Dell pavillion").
		param("productFor", "Men").
		multiPart("productImage",new File("C:\\Nitish\\Notes\\Java Notes\\Collection\\Map\\laptop.png"));
		
		ProductDetails pd=addSpecExact.when().post("/api/ecom/product/add-product")
		.then().log().all().extract().as(ProductDetails.class);
		
		String productId=pd.getProductId();

		
		
		//create order
		RequestSpecification createOrderbaseSpec=new RequestSpecBuilder().setBaseUri(baseUri).
			setContentType(ContentType.JSON).addHeader("Authorization", token).build();
		
		OrederDetails orederDetails=new OrederDetails();
		orederDetails.setCountry("India");
		orederDetails.setProductOrderedId(productId);
		List<OrederDetails> lst=new ArrayList<OrederDetails>();
		lst.add(orederDetails);
		
		Orders order=new Orders();
		order.setOrder(lst);
		
		ResponseSpecification createResponse=new ResponseSpecBuilder().expectStatusCode(200).build();
		
		String createOrder =given().spec(createOrderbaseSpec).body(order)
		.when().post("/api/ecom/order/create-order")
		.then().log().all().spec(createResponse).extract().response().asString();
		
		JsonPath js=new JsonPath(createOrder);
		System.out.println("product id : "+js.getString("productOrderId"));
		
		
	}

}
