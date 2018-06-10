package VincentR.CoffeeMachine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ReportManagementTest extends TestCase{
	public ReportManagementTest(String testName) {
		super(testName);
	}
	
	public static Test suite() {
        return new TestSuite(ReportManagementTest.class);
    }
  
	public void testCreateFile() {
		ReportManagement.CreateFile();
		String filePath = System.getProperty("user.dir") + "\\report\\Report.properties";
		try {
			File file = new File(filePath);
			if (file.exists() && !file.isDirectory()) {
				assertEquals(true, true);
			}else {
				assertEquals(true, false);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		BufferedReader br = null;
		FileReader fr = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String sCurrentLine;
			boolean check = true;
			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.startsWith("coffee") && !sCurrentLine.startsWith("chocolate") && !sCurrentLine.startsWith("tea") && !sCurrentLine.startsWith("orange juice")) {
					check = false;
					break;
				}
			}
			assertEquals(true, check);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}