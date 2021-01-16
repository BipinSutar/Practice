package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@FunctionalInterface
interface Added {
	int getInput(int a, int b);
}

// @FunctionalInterface
// interface SmartAdded extends Added {
// int getInput(double a, double b);
// }
//
// @FunctionalInterface
// interface Nothing {
// }

@FunctionalInterface
interface FuncInt {
	int getInput(int num1, int num2);

	default int getValue() {
		return 0;
	}
}

public class TCS_13OCT_TEST {
	public static void main0(String[] args) {
		int[] array = {6, 9, 8};
		List<Integer> list = new ArrayList<>();
		list.add(array[0]);
		list.add(array[2]);
		list.set(1, array[1]);
		list.remove(0);
		System.out.println(list);
		String Names = new String("Alice,Bob,Smith");
		Names = Names.replaceAll(",", ":");

		System.out.println(Names);
		Map<String, String> Values = new HashMap<>();
		Values.put("Key 1", "Value 1");
		Values.put("Key 2", "Value 2");
		iterateMap(Values);

	}

	public static void iterateMap(Map<String, String> Values) {

		for (Entry<String, String> entry : Values.entrySet()) {
			System.out.print(entry.getValue() + ", " + entry.getKey());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String s = br.readLine();
		if (s.length() < 100) {
			System.out.println(GetCount1(s));
		} else {
			System.out.println(GetCount(s));
		}
		br.close();
	}

	public static long GetCount1(String s_in) {
		long ans = 0;
		final int mod = (int) Math.pow(10, 9) + 7;
		char s[] = s_in.toCharArray();
		for (int i = 0; i < s.length; i++) {
			if (isVowel(s[i])) {
				ans++;
				for (int j = i; j < s.length; j++) {
					if (!isVowel(s[j])) {
						ans++;
					}
				}
			}
		}
		return ans % mod;
	}

	public static long GetCount(String s_in) {
		long ans = 0;
		final int mod = (int) Math.pow(10, 9) + 7;
		char s[] = s_in.toCharArray();
		int v_c = 0;
		int v_c_till_now = 0;
		for (int i = s.length - 1; i >= 0; i--) {
			if (!isVowel(s[i])) {
				v_c++;
			} else {
				// ans = ans + power(v_c, 2) - 1;
				v_c_till_now = v_c_till_now + v_c;
				ans = ans + power(v_c_till_now, 2) - 1;
				v_c = 0;
			}
		}
		return ans % mod;
	}

	static long power(long x, long y) {
		long temp;
		if (y == 0)
			return 1;
		temp = power(x, y / 2);

		if (y % 2 == 0)
			return temp * temp;
		else {
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}

	public static boolean isVowel(char c) {
		// if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c ==
		// 'A' || c == 'E' || c == 'I' || c == 'O'
		// || c == 'U') {
		// return true;
		// }
		if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A'
				&& c != 'E' && c != 'I' && c != 'O' && c != 'U') {
			return false;
		}
		return true;
	}

	public static void mainMinimumSumSubarray(String[] args)
			throws IOException {
		// MinimumSumSubarray
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String line[] = br.readLine().trim().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		System.out.println(minSum(arr));
		br.close();

	}

	public static long minSum(int arr[]) {
		int k = arr.length / 2;
		long minSum = 0;

		for (int i = 0; i < k; i++) {
			minSum = minSum + arr[i];
		}
		long window_sum = minSum;
		for (int i = 0; i < arr.length; i++) {
			int index = getIndex(i, k, arr.length);
			window_sum = (window_sum + arr[index]) - arr[i];
			minSum = Math.min(minSum, window_sum);
		}
		return minSum;
	}

	private static int getIndex(int i, int k, int length) {
		if (i + k < length) {
			return i + k;
		}
		return (i + k) - length;
	}
}


