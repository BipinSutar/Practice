package com.bipin.practice.hackerearrth._2019;

import java.math.BigDecimal;

public class Meesho_27Apr {
	public static void main(String[] args) {

	}
	public int getXPartitioned(String s_arr[]) {
		int x = 0;
		BigDecimal b_arr[] = new BigDecimal[s_arr.length];
		BigDecimal arr_sum = new BigDecimal(0);
		BigDecimal one = new BigDecimal(1);
		BigDecimal zero = new BigDecimal(0);
		BigDecimal minusone = new BigDecimal(-1);
		for (int i = 0; i < s_arr.length; i++) {
			b_arr[i] = new BigDecimal(s_arr[i]);
			if (!b_arr[i].equals(one)) {
				arr_sum = arr_sum.add(b_arr[i]);
			}

		}
		BigDecimal curr_sum = new BigDecimal(0);
		BigDecimal minDiff = new BigDecimal(Long.MAX_VALUE);
		// BigDecimal prevminDiff = new BigDecimal(Long.MAX_VALUE);
		for (int i = 0; i < b_arr.length; i++) {
			if (!b_arr[i].equals(one)) {
				curr_sum = curr_sum.add(b_arr[i]);
			}
			BigDecimal curr_sub = arr_sum.subtract(curr_sum);
			BigDecimal diff = curr_sub.subtract(curr_sum);
			if (diff.compareTo(zero) < 0) {
				diff = diff.multiply(minusone);
			}
			minDiff = minDiff.min(diff);
			if (minDiff.compareTo(diff) < 0) {
				x = i + 1;

			}

		}
		return x;

	}
}
