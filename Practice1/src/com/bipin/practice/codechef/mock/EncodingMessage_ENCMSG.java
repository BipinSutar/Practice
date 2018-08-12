package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncodingMessage_ENCMSG {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			br.readLine();
			sb.append(getEncodedMessage(br.readLine()) + "\n");
		}
		System.out.println(sb.toString());
		br.close();

	}

	public static String getEncodedMessage(String in) {

		char data[] = in.toCharArray();
		int lim = 0;
		if (in.length() % 2 == 1) {
			int cal = in.length() - 1;
			lim = cal;

			data[cal] = getRepacedCharAsPerStep2(data[cal]);
		} else {
			lim = in.length();
		}
		for (int i = 1; i < lim; i = i + 2) {
			char temp = data[i];
			int prev = i - 1;
			data[i] = data[prev];
			data[prev] = temp;
			data[i] = getRepacedCharAsPerStep2(data[i]);
			data[prev] = getRepacedCharAsPerStep2(data[prev]);
		}
		StringBuilder sb = new StringBuilder(new String(data));
		return sb.toString();
	}

	public static char getRepacedCharAsPerStep2(char ch) {
		// int as = (int) ch - 96;
		// return (char) (97 + 26 - as);
		return (char) (219 - ch);

	}

}
