package file;

public class Payload {
	public static String addPlace() {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": 12.9385671,\r\n"
				+ "    \"lng\": 77.6989690\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Nitish Kumar Sahoo_05\",\r\n"
				+ "  \"phone_number\": \"(+91) 9439905104\",\r\n"
				+ "  \"address\": \"Pruchi Pg,Munni reddy layout\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"PG\",\r\n"
				+ "    \"Hostel\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"English\"\r\n"
				+ "}\r\n"
				+ " \r\n"
				+ "";
		
	}
	public static String ComplexJson() {
		
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 7560,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"JAVA Selenium\",\r\n"
				+ "      \"price\": 90,\r\n"
				+ "      \"copies\": 20\r\n"
				+ "    },\r\n"
				+ "     {\r\n"
				+ "      \"title\": \"API automation\",\r\n"
				+ "      \"price\": 30,\r\n"
				+ "      \"copies\": 60\r\n"
				+ "    },\r\n"
				+ "     {\r\n"
				+ "      \"title\": \"Data science\",\r\n"
				+ "      \"price\": 95,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    },\r\n"
				+ "     {\r\n"
				+ "      \"title\": \"Machine learning\",\r\n"
				+ "      \"price\": 100,\r\n"
				+ "      \"copies\": 20\r\n"
				+ "    },\r\n"
				+ "     {\r\n"
				+ "      \"title\": \"Appium\",\r\n"
				+ "      \"price\": 55,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
	}
	
	
	public static String addBook(String isbn, String aisle) {
		String book="{\r\n"
				+ "\"name\":\"How to start API Automation\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"Nitish\"\r\n"
				+ "}\r\n"
				+ "";
		
		return book;
		
	}



}
