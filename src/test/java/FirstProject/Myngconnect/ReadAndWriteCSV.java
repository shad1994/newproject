package FirstProject.Myngconnect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteCSV {
	public static void main(String[] args) throws IOException {

		ReadCSV();
		WriteCSV();

	}

	public static void ReadCSV() {
		String csvFile = "src/test/resources/data.csv";
		BufferedReader br=null;
		
		String line="";
		
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] employee = line.split(cvsSplitBy);

				System.out.println("Employee [CompanyName= " + employee[0] + " , EmployeeName=" + employee[1]
						+ " , EmployeeId=" + employee[2] + "]");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void WriteCSV() throws IOException {
		String csvFile = "src/test/resources/data.csv";
		BufferedWriter br = null;
		String line = "";
		String cvsSplitBy = ",";

		br = new BufferedWriter(new FileWriter(csvFile, true));
		br.newLine();

		String[] employee1 = { "QA", "Jaspal", "5467" };
		String[] employee2 = { "QA", "Jaspal", "5467" };
		String[] employee3 = { "QA", "Jaspal", "5467" };
		for (int i = 0; i < employee1.length; i++) {
			br.write(employee1[i] + ",");
		}
		br.close();
		System.out.println("filewrite");

	}

}
