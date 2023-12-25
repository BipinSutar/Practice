package com.bipin.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeetcodeSubsets {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(new LeetcodeSubsets().subsets(new int[] { 1, 2, 3 }));
		br.close();

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> currList = new ArrayList<Integer>();

			for (int j = i; j < nums.length; j++) {
				currList.add(nums[j]);
				ans.add(new ArrayList<Integer>(currList));
			}
		}
		ans.add(new ArrayList<Integer>());
		return ans;

	}
}
