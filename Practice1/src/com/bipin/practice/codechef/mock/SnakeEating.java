package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SnakeEating {
	static long[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] l_s = br.readLine().split(" ");
			int n = Integer.parseInt(l_s[0]);
			int q = Integer.parseInt(l_s[1]);
			long a[] = new long[n];
			l_s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				a[j] = Long.parseLong(l_s[j]);
			}
			Arrays.sort(a);
			p = new long[n];
			p[0] = a[0];
			for (int i = 1; i < n; i++) {
				p[i] = p[i - 1] + a[i];
			}

			while (q-- > 0) {
				int k = Integer.parseInt(br.readLine());
				int res = 0;
				int index = findCurr(a, k);
				res += n - index;
				if (index == 0)
					System.out.println(n);
				else {
					res += findAfter(a, k, index);
					System.out.println(res);
				}
			}
		}
		br.close();
	}

	static int findAfter(long[] a, long k, int ind) {
		int end = ind - 1;
		if (k - a[end] > end)
			return 0;
		int l = 0, r = end;
		while (r - l > 1) {
			int mid = (l + r) >> 1;
			long req = (end - mid + 1) * k - sum(mid, end);
			if (req <= mid) {
				r = mid;
			} else {
				l = mid;
			}
		}
		return end - r + 1;
	}

	static int findCurr(long[] a, long k) {
		int n = a.length;
		if (a[n - 1] < k)
			return n;
		int l = -1, r = n - 1;
		while (r - l > 1) {
			int mid = (l + r) >> 1;
			if (a[mid] >= k) {
				r = mid;
			} else {
				l = mid;
			}
		}
		return r;
	}

	static long sum(int s, int e) {
		long ans = p[e];
		if (s > 0)
			ans -= p[s - 1];
		return ans;
	}
}
