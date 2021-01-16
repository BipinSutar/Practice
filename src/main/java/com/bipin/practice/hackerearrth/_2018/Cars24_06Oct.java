package com.bipin.practice.hackerearrth._2018;

import java.util.Scanner;

public class Cars24_06Oct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				sum = sum + a[i];

			}
			int x_og = sum / n;
			int k = 0;
			int x = 0;
			while (true) {
				int diffsum = 0;
				x = x_og + k;
				for (int i = 0; i < n; i++) {
					diffsum = diffsum + (x - a[i]);
				}
				if (diffsum == 0) {
					break;
				} else {
					k++;
					
				}
			}
			System.out.println(x);
		}
		sc.close();

	}

}
