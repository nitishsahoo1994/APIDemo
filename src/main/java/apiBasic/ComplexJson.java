package apiBasic;

import org.testng.Assert;

import file.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJson {
	
	public static void main(String[] args) {
		
		JsonPath js=new JsonPath(Payload.ComplexJson());
//		System.out.println(js.getInt("dashboard.purchaseAmount"));;
//		
//		//total no of courses in that json file
		int totalCourses=js.getInt("courses.size()");
//		System.out.println(totalCourses);
//		
//		//title of the first course
//		System.out.println(js.get("courses[0].title"));
//		
//		for(int i=0;i<totalCourses;i++) {
//			
//			System.out.println("prices of "+js.get("courses["+i+"].title").toString()+" book is "+js.getInt("courses["+i+"].price"));
//		}
//		
//		//No of copies sold for API automation
//		for(int i=0;i<totalCourses;i++) {
//			if(js.getString("courses["+i+"].title").toString().equals("API automation")) {
//				System.out.println(js.getString("courses["+i+"].copies").toString());
//				break;
//			}
//		}
//		
		
		
		//Verify total purchase amount
		int total=0;
		for(int i=0;i<totalCourses;i++) {
			total=total+( js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies"));
		}
		
		Assert.assertEquals(total, js.getInt("dashboard.purchaseAmount"));
		System.out.println("pass");
		
	}
	
	

}
