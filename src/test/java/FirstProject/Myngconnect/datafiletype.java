package FirstProject.Myngconnect;

import static org.testng.Assert.assertThrows;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;

import org.jopendocument.dom.spreadsheet.SpreadSheet; 


public class datafiletype {

	public static String filetype;
	public static String username;
	public static String password;

	public void DatafileType() throws IOException, ParseException {
		AccessProperty prop = new AccessProperty();
		filetype = prop.getproperty("datafiletype");
		System.out.println(filetype);
		if (filetype.equals("json")) {

			System.out.println("hellooo");
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("src/test/resources/data.json"));
             
			JSONObject jsonObject = (JSONObject) obj;
			
			System.out.println(jsonObject.toString());
			
			username = jsonObject.get("username").toString();
			System.out.println(username);
			password = jsonObject.get("password").toString();
		} else if (filetype.equals("properties")) {
			InputStream input = new FileInputStream("src/test/resources/data.properties");
			Properties p = new Properties();
			
			p.load(input);
			
			
			username = p.getProperty("username");
			password = p.getProperty("password");
		} else if (filetype.equals("yaml")) {
			System.out.println("hello yaml");
			// FileInputStream file=new
			// FileInputStream("src/test/resources/data.yaml");
			File file = new File("src/test/resources/data.yaml");
			InputStream fis = null;

			fis = new FileInputStream(file);
			org.yaml.snakeyaml.Yaml yaml = new org.yaml.snakeyaml.Yaml();
			
			Map<String, String> map = (Map<String, String>) yaml.load(fis);

			username = map.get("username");
			System.out.println(username);
			password = map.get("password");
		}
		
		else if (filetype.equals("xlsx")) {
			  FileInputStream excelFile = new FileInputStream(new File("src/test/resources/data.xlsx"));
				Workbook workbook = new XSSFWorkbook(excelFile);
			    XSSFSheet datatypeSheet = (XSSFSheet) workbook.getSheetAt(0);
			
			    Row row =datatypeSheet.getRow(0);
			    Cell cell = row.getCell(1); 
			    
			    username=cell.toString();
			    System.out.println(username);
			    password=datatypeSheet.getRow(1).getCell(1).toString();
			    System.out.println(password);

		}
		else if(filetype.equals("ods"))
		{
			try {
			    File file=new File("src/test/resources/data.ods");
			    final org.jopendocument.dom.spreadsheet.Sheet sheet=SpreadSheet.createFromFile(file).getSheet(0);
			   username=sheet.getCellAt("B1").getValue().toString();
			   password=sheet.getCellAt("B2").getValue().toString();
			    
			  }
			 catch (  Exception e) {
			    e.printStackTrace();
			  }
			
		}

	}

	

}
