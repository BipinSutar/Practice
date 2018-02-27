package com.bipin.practice.hackerrank.codiva_25_nov.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GS_CODE_SPRINT_18 {

	public static void main(String[] args) {
		String dir = "D:\\ofss training\\GIT_JAVA\\Practice\\Practice1\\src\\data";
		String fname = "Demo.csv";
		File advice;
		try {
			advice = new File(dir, fname);
			advice.createNewFile();

			// BufferedWriter out = new BufferedWriter(new FileWriter(advice));

			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(advice)));
			new GS_CODE_SPRINT_18().writeDataToFile(pw);

		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void writeDataToFile(PrintWriter pw) {
		String eightspace = "\t\t";
		String empty_line = eightspace + eightspace + eightspace + eightspace + eightspace + eightspace;
		String companyHeader = "Prcision Pattern Works";
		String pipe = "|";
		String eightspace1 = "		";

		pw.println(empty_line);
		pw.println(eightspace + eightspace + companyHeader + eightspace + eightspace + eightspace);
		pw.println(empty_line);
		pw.println("Sr No." + eightspace + "Iteam ID  " + eightspace + "  Dscription " + eightspace + "   Quantity "
				+ eightspace + "   Price 1 Unit  " + eightspace + " Total Price");
		pw.println("1" + eightspace + "100" + eightspace + "Molding rubber vessel" + eightspace + "10" + eightspace
				+ "1205" + eightspace + "12050");

		pw.flush();
	}

}
