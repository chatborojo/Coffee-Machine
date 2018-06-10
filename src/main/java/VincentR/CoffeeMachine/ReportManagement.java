package VincentR.CoffeeMachine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReportManagement {
	static final String filePath = System.getProperty("user.dir") + "\\report\\Report.properties";

	public static void CreateFile() {
		try {
			File file = new File(filePath);
			if (file.createNewFile()) {
				BufferedWriter bw = null;
				FileWriter fw = null;
				try {
					String content = "coffee:0\n"
							+ "chocolate:0\n"
							+ "tea:0\n"
							+ "orange juice:0";
					fw = new FileWriter(filePath);
					bw = new BufferedWriter(fw);
					bw.write(content);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (bw != null)
							bw.close();
						if (fw != null)
							fw.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void WriteOnFile(String drinkName) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		BufferedReader br = null;
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			br = new BufferedReader(new FileReader(filePath));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.startsWith(drinkName)) {
					String lineToModify = sCurrentLine.replace(drinkName + ":", "");
					int nbr = Integer.parseInt(lineToModify) + 1;
					String newLine = drinkName + ":" + Integer.toString(nbr);
					IncrementReplaceLine(sCurrentLine, newLine);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static int ReadAmountOnFile(String drinkName) {
		BufferedReader br = null;
		FileReader fr = null;
		int number = 0;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.startsWith(drinkName)) {
					String[] lineWithNumber = sCurrentLine.split(":");
					number = Integer.parseInt(lineWithNumber[lineWithNumber.length-1]);
					break;
				}
			}
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
		return number;
	}

	public static void IncrementReplaceLine(String oldLine, String newLine) {
		try {
			File file = new File(filePath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "", oldtext = "";
			while ((line = reader.readLine()) != null) {
				oldtext += line + "\r\n";
			}
			reader.close();
			String newtext = oldtext.replaceAll(oldLine, newLine);
			FileWriter writer = new FileWriter(filePath);
			writer.write(newtext);
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static double AmountSoldDrinks() {
		int nbr1 = ReadAmountOnFile("coffee"),
			nbr2 = ReadAmountOnFile("chocolate"),
			nbr3 = ReadAmountOnFile("tea"),
			nbr4 = ReadAmountOnFile("orange juice");
		double total = nbr1 * 0.6 + nbr2 * 0.5 + nbr3 * 0.4 + nbr4 * 0.6;
		System.out.println("Number of sold drinks:\n"
				+ "Coffee:\t" + nbr1 + "\n"
				+ "Chocolate:\t" + nbr2 + "\n"
				+ "Tea:\t" + nbr3 + "\n"
				+ "Orange juice:\t" + nbr4 + "\n");
		return total;
	}
}