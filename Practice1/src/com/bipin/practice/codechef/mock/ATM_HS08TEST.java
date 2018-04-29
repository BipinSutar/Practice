package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM_HS08TEST {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line[] = br.readLine().split(" ");
		int X = Integer.parseInt(line[0].trim());
		double Y = Double.parseDouble(line[1].trim());
		double amount = Y;
		if (X % 5 == 0 && Y >= X + 0.5) {
			amount = Y - X - 0.5;
		}
		System.out.println(amount);
		br.close();
	}

}
