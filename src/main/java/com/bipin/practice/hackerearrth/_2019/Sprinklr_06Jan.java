package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sprinklr_06Jan {
	private static List<Long> beautyList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		System.out.println(getBeauty(1000_000_000_000_000_000L));
		System.exit(0);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		generateBeauty();
		System.exit(0);
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int x = Integer.parseInt(br.readLine());
			System.out.println(getNthBeautifulNumber(x));
		}
		br.close();

	}
	public static long getBeauty(long number) {
		long beauty = 0;
		while (number > 0) {
			beauty = beauty + (number & 1);
			number = number / 2;
		}
		return beauty;
	}
	public static long getNthBeautifulNumber(long x) {
		long N = 50;
		long beautifulSum = 0;
		for (long i = 1; i <= N; i++) {
			long beauty = getBeauty(i);
			beautifulSum = beautifulSum + beauty;
			System.out.println(
					"For " + i + " b = " + beauty + " sum = " + beautifulSum);
			if (beautifulSum >= x) {
				return i;
			}
		}
		return 0L;
	}
	public static void generateBeauty() {
		long N = 0;
		long beautifulSum = 0;
		long threshold = 1000_000_000_000_000_000L;
		long startTime = System.currentTimeMillis();
		for (long i = 1;; i++) {
			long beauty = getBeauty(i);
			beautifulSum = beautifulSum + beauty;
			if (beautifulSum >= threshold) {
				N = i;
				System.out.println(i + " Beautful sum is " + beautifulSum);
				break;
			} else {
				System.out.println("Beauty and sum for " + i + " is " + beauty
						+ " / " + beautifulSum);
				beautyList.add(beautifulSum);
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time " + (endTime - startTime) / 1000);
	}
}
