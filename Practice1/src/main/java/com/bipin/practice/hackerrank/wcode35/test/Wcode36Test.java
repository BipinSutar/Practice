package com.bipin.practice.hackerrank.wcode35.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Wcode36Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			sb.append(acidNaming(br.readLine()) + "\n");
		}
		System.out.print(sb.toString());
		br.close();

	}

	public static String acidNaming(String acid_name) {

		int count = 0;
		String ic = "";
		String hydro = "";
		for (int i = acid_name.length() - 1; i >= 0; i--) {
			if (count == 2) {
				break;
			} else {
				ic = ic + acid_name.charAt(i);
				count++;
			}
		}
		if (!ic.equals("ci")) {
			return "not an acid";
		}
		count = 0;
		for (int i = 0; i < acid_name.length(); i++) {
			if (count == 5) {
				break;
			} else {
				hydro = hydro + acid_name.charAt(i);
				count++;
			}
		}
		if (hydro.equals("hydro")) {
			return "non-metal acid";
		} else {
			return "polyatomic acid";
		}

	}

}
