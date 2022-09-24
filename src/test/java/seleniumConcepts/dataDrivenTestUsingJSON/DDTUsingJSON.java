package seleniumConcepts.dataDrivenTestUsingJSON;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import base.BaseClass;

public class DDTUsingJSON extends BaseClass {

	Logger log = Logger.getLogger(DDTUsingJSON.class);

	@Test(dataProvider = "dp")
	void loginTest(String data) {
		String[] users = data.split(",");
		log.info("login to app using the JSON data provider");

		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		driver.findElement(By.id("Email")).sendKeys(users[0]);
		driver.findElement(By.id("Password")).sendKeys(users[1]);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

	}

	@DataProvider(name = "dp")
	public String[] readJSON() throws IOException, ParseException {
		JSONParser jp = new JSONParser();

		// Before parsing we need to load JSON file the FileReader class

		FileReader reader = new FileReader(".\\jsonfiles\\testdata.json");

		// As soon as we loaded file we need to parse it (Following code snippet parse
		// my JSON Data)

		Object obj = jp.parse(reader);

		// Note: obj => Is just the java object, we need to convert to the JSON object
		// and then from the
		// JSON object we can extract the JSON array.

		// Now, extract the JOSN object:

		JSONObject userLoginJsonobj = (JSONObject) obj;

		JSONArray usersLoginsArray = (JSONArray) userLoginJsonobj.get("user_logins");

		String[] arr = new String[usersLoginsArray.size()];

		for (int i = 0; i < usersLoginsArray.size(); i++) {
			JSONObject users = (JSONObject) usersLoginsArray.get(i);
			String user = (String) users.get("username");
			String pwd = (String) users.get("password");

			arr[i] = user + ", " + pwd;
		}

		return arr;
	}

}
