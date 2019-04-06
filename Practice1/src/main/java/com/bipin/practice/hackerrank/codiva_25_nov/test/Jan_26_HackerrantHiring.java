package com.bipin.practice.hackerrank.codiva_25_nov.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Jan_26_HackerrantHiring {
	static long simplestSum(int k, long a, long b) {
		System.out.println("case " + k + " " + a + " " + b);
		long sum = 0;
		int mod = 1000000007;
		for (long i = a; i <= b; i++) {
			sum = (sum + f(k, i)) % mod;
		}
		return sum;
	}

	static long f(int k, long n) {
		long sum = 0;
		int mod = 1000000007;
		for (long i = 1; i <= n; i++) {
			// System.out.print("i " + i + " n " + n + " ");
			sum = sum + i;
			i = (i * k) % mod;
			// System.out.println(" i*k " + i);

		}

		return sum;

	}

	static long fastsum(long k, long a, long b) {
		long sum = 0;
		int mod = 1000000000 + 7;

		for (long i = 1; i <= b; i++) {
			long temp = 0, temp1 = 0;
			if (i < a) {
				temp = (b - i + i - a + 1) % mod;
			} else {
				temp = (b - i + 1) % mod;
			}
			temp1 = (temp * i);
			sum = (sum + temp1);

			i = (i * k);
		}
		return sum % mod;
	}

	public static void mainSimplestSum(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int a0 = 0; a0 < q; a0++) {
			String line = br.readLine();
			String line_q[] = line.split(" ");
			long result = fastsum(Long.parseLong(line_q[0]), Long.parseLong(line_q[1]), Long.parseLong(line_q[2]));
			sb.append(result + "\n");

		}
		System.out.print(sb.toString());
		br.close();

	}

	public static void mainProgrammingCompetition(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String maxPro = "";
		int maxDiff = Integer.MIN_VALUE;
		for (int a0 = 0; a0 < n; a0++) {
			String name = in.next();
			int d = in.nextInt();
			int j = in.nextInt();
			int solved = j - d;
			if (maxDiff < solved) {
				maxDiff = solved;
				maxPro = name + " " + maxDiff;
			}
		}

		System.out.println(maxPro);
		in.close();
	}

	static int winningLotteryTicket(String[] tickets) {
		int count = 0;
		for (int i = 0; i < tickets.length; i++) {
			for (int j = i + 1; j < tickets.length; j++) {
				if (isValidpair(tickets[i], tickets[j]))
					count++;
			}
		}
		return count;
	}

	static int winningLotteryTicket1(String[] tickets) {
		int count = 0;
		Map<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < tickets.length; i++) {
			if (!hm.containsKey(tickets[i]))
				hm.put(tickets[i], 0);
			hm.put(tickets[i], hm.get(tickets[i]) + 1);
		}
		String[] keys = new String[hm.size()];
		Integer[] values = new Integer[hm.size()];
		int index = 0;
		for (Map.Entry<String, Integer> mapEntry : hm.entrySet()) {
			keys[index] = mapEntry.getKey();
			values[index] = mapEntry.getValue();
			System.out.println(keys[index] + " " + values[index]);
			index++;

		}
		for (int i = 0; i < keys.length; i++) {
			for (int j = i + 1; j < keys.length; j++) {
				if (isValidpair(keys[i], keys[j])) {
					count += hm.get(keys[i]);
				}
			}
		}
		return count;
	}

	static boolean isValidpair(String a, String b) {
		Set<Character> mset = new HashSet<Character>();
		for (int i = 0; i < a.length(); i++) {
			mset.add(a.charAt(i));
		}
		for (int i = 0; i < b.length(); i++) {
			mset.add(b.charAt(i));
		}
		return mset.size() == 10;

	}

	public static String getString(String s) {
		// LinkedHashSet<Character> mset = new LinkedHashSet<Character>();
		LinkedHashMap<Character, Object> map = new LinkedHashMap<>();
		Object PRESENT = new Object();
		for (int i = 0; i < s.length(); i++) {
			// mset.add(s.charAt(i));
			map.put(s.charAt(i), PRESENT);
		}
		StringBuilder sb = new StringBuilder();
		Iterator<Character> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			sb.append(itr.next());
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] tickets = new String[n];
		for (int tickets_i = 0; tickets_i < n; tickets_i++) {
			tickets[tickets_i] = getString((in.readLine().trim()));
		}
		int result = winningLotteryTicket1(tickets);
		System.out.println(result);
		in.close();
	}
}
