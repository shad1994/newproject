package FirstProject.Myngconnect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Accessjson {

	public static String username;
	public static String password;

	JSONObject jsonObject;

	public Accessjson() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("src/test/resources/data.json"));

		jsonObject = (JSONObject) obj;

	}

	public String getUsername() {
		username=jsonObject.get("username").toString();
		return username;
	}

	
	public String getPassword() {
		password=jsonObject.get("password").toString();
		return password;
	}

	

}
