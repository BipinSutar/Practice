package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class Anzen_tech_15_Jul {
	private int variableA = showOutput();
	static final int variableB = 20;

	private int showOutput() {
		return variableB;
	}

	public static void main1(String[] args) throws IOException {
		System.out.println((new Anzen_tech_15_Jul()).showOutput());
		System.exit(0);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int k = Integer.parseInt(br.readLine().trim());
		System.out.println(getString(new StringBuilder(line), k));
		System.out.println(getString1(new StringBuilder(line), k));
		br.close();
	}

	public static String getString(StringBuilder in, int k) {
		StringBuilder x = new StringBuilder();
		while (in.length() > 0) {
			StringBuilder temp = new StringBuilder(in.substring(0, min(k, in.length())));
			char min = '}';
			int minLoc = -1;
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) < min) {
					min = temp.charAt(j);
					minLoc = j;
				}
			}
			in.deleteCharAt(minLoc);
			x.append(min);
		}
		return x.toString();
	}

	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	public static char min(char a, char b) {
		return a < b ? a : b;
	}

	public static String getString1(StringBuilder in, int k) {
		StringBuilder x = new StringBuilder();

		TreeMap<Character, Integer> sortData = new TreeMap<Character, Integer>();

		for (int i = 0; i < k; i++) {
			char curr = in.charAt(i);
			if (sortData.containsKey(curr)) {
				sortData.put(curr, sortData.get(curr) + 1);
			} else {
				sortData.put(curr, 1);
			}
		}

		char rem = sortData.firstKey();
		if (sortData.get(rem) > 1) {
			sortData.put(rem, sortData.get(rem) - 1);
		} else {
			sortData.remove(rem);
		}
		x.append(rem);
		for (int i = k; i < in.length(); i++) {
			char curr = in.charAt(i);
			if (sortData.containsKey(curr)) {
				sortData.put(curr, sortData.get(curr) + 1);
			} else {
				sortData.put(curr, 1);
			}
			rem = sortData.firstKey();
			if (sortData.get(rem) > 1) {
				sortData.put(rem, sortData.get(rem) - 1);
			} else {
				sortData.remove(rem);
			}
			x.append(rem);
		}
		Iterator<Character> itr = sortData.keySet().iterator();
		while (itr.hasNext()) {
			char c = itr.next();
			int val = sortData.get(c);
			for (int i = 0; i < val; i++) {
				x.append(c);
			}

		}
		return x.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line[] = br.readLine().split(" ");
		int data[] = new int[N];

		for (int i = 0; i < line.length; i++) {
			data[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(data);
		double avg[] = new double[N];
		double sum = data[0];
		avg[0] = sum;
		for (int i = 1; i < N; i++) {
			sum = sum + data[i];
			avg[i] = sum / (i + 1);
		}
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			int k = Integer.parseInt(br.readLine());
			// sb.append(getAvg(data, k) + "\n");

			sb.append(getAvg1(avg, k) + "\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	public static int getAvg(double data[], int k) {

		if (data[0] == k) {
			return 0;
		}
		double sum = data[0];
		for (int i = 1; i < data.length; i++) {
			sum = sum + data[i];
			double curAvg = sum / (i + 1);
			if (curAvg >= k) {
				return (i);
			}
		}
		return data.length;
	}

	public static int getAvg1(double data[], int k) {
		if ((data[0] + data[1]) / 2.0 > k) {
		//	return 0;
		}
		int l = 0, h = data.length - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (data[mid] >= k)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return l;

	}

}
