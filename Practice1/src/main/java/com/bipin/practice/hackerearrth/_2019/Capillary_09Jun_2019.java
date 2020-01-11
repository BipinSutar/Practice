package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Capillary_09Jun_2019 {
	final static int mod = 1000_000_000 + 7;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String line[] = br.readLine().split(" ");
			long arr[] = new long[n];
			Map<Integer, Long> cum_sum = new HashMap<>();
			long sum = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(line[i]);
				sum = sum + arr[i];
				sum = sum % mod;
				cum_sum.put(i + 1, sum);

			}
			int q = Integer.parseInt(br.readLine().trim());
			line = br.readLine().split(" ");
			long li[] = new long[q];
			for (int i = 0; i < q; i++) {
				li[i] = Long.parseLong(line[i]);
			}
			line = br.readLine().split(" ");
			long ri[] = new long[q];
			for (int i = 0; i < q; i++) {
				ri[i] = Long.parseLong(line[i]);
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < q; i++) {
				sb.append(getSumLR(li[i], ri[i], cum_sum, n, sum) + " ");
			}
			System.out.println(sb);
			System.out.flush();
		}
		br.close();
	}

	private static long getSumLR(long l, long r, Map<Integer, Long> cum_sum,
			int n, long sum) {

		long ans = 0L;
		int lpos = (int) (l % n);
		int rpos = (int) (r % n);
		long lpos_div = l / n;
		long rpos_div = r / n;
		if (lpos == 0) {
			lpos = n;
			lpos_div--;
		}
		if (rpos == 0) {
			rpos = n;
			rpos_div--;
		}
		if (rpos_div == 0) {
			long rsum = cum_sum.get(rpos);
			long lsum = 0;
			if (cum_sum.containsKey(lpos - 1)) {
				lsum = (cum_sum.get(lpos - 1));
			}
			ans = (rsum - lsum);
		} else {
			long rsum = (sum * rpos_div);
			rsum = rsum + cum_sum.get(rpos);
			long lsum = 0;
			if (lpos_div == 0) {
				if (cum_sum.containsKey(lpos - 1)) {
					lsum = cum_sum.get(lpos - 1);
				}
			} else {
				lsum = (sum * lpos_div);
				if (cum_sum.containsKey(lpos - 1)) {
					lsum = lsum + cum_sum.get(lpos - 1);
				}

			}
			ans = ((rsum) - (lsum));

		}

		return (ans % mod);
	}

}
