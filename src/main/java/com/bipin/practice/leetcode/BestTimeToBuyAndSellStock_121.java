package com.bipin.practice.leetcode;

public class BestTimeToBuyAndSellStock_121 {

	public static void main(String[] args) {
		int prices[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println(new BestTimeToBuyAndSellStock_121().maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int currMin = prices[0];
		for (int i = 0; i < prices.length; i++) {
			currMin = Math.min(currMin, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - currMin);
		}
		return maxProfit;
	}
}
