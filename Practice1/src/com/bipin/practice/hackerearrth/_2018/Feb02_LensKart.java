package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Feb02_LensKart {

	public long maxTheifStack(long input[]) {
		long maxArea = 0;
		long area = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i;
		for (i = 0; i < input.length;) {
			if (stack.isEmpty() || input[stack.peek()] <= input[i]) {
				stack.add(i++);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					area = input[top] * i;
				} else {
					area = input[top] * (i - stack.peek() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}

			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (stack.isEmpty())
				area = input[top] * i;
			else
				area = input[top] * (i - stack.peek() - 1);
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	public static void mainThiefAndWearHouse(String[] args) {
		Feb02_LensKart mh = new Feb02_LensKart();
		// int input[] = { 2, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2 };
		long input[] = { 3, 0, 5, 4, 4, 4 };
		long maxArea = mh.maxTheifStack(input);
		System.out.println(maxArea);

	}

	public static void mainStringgame(String[] args) {// String game
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String s = sc.nextLine();
			Set<Character> chars = new java.util.HashSet<Character>();
			for (int i = 0; i < s.length(); i++) {
				chars.add(s.charAt(i));
			}
			if (chars.size() % 2 == 0) {
				System.out.println("Player2");
			} else {
				System.out.println("Player1");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int data[] = new int[n];
			String s = br.readLine();
			String s_split[] = s.split(" ");
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(s_split[i]);
			}
			sb.append(cal(data) + "\n");

		}
		System.out.print(sb.toString());

		br.close();

	}

	private static int cal(int[] data) {
		int max = Integer.MIN_VALUE;
		int max_index = -1;
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
				max_index = i;
			}
			if (data[i] < min) {
				min = data[i];
				min_index = i;
			}
		}
		if (max_index == data.length - 1) {
			// all increasing
			return max - data[max_index - 1];
		} else {
			// swap
			int temp = data[min_index];
			data[min_index] = data[max_index];
			data[max_index] = temp;
		}
		int currmax = Integer.MIN_VALUE;
		for (int i = max_index + 1; i < data.length; i++) {
			int diff = data[i] - data[i - 1];
			if (diff > currmax) {
				currmax = diff;
			}
		}
		return currmax;
	}
}
