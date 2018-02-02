package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FebruaryEasy18 {

	public static void main(String[] args) throws IOException {
		// Naruto and His New Jutsu
		// Naruto learned a new jutsu (magical attack). The jutsu of intensity
		// N
		// N requires chakra (energy) equal to the sum of odd divisors of
		// N
		// N. Naruto wants to calculate the amount of chakra that will be used in this
		// jutsu given the amount of intensity of the jutsu.
		//
		// calculate sum of odd divisors oof number
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int num = Integer.parseInt(br.readLine());
			int sq = (int) Math.sqrt(num);
			long result = 0;
			for (int i = 2; i <= sq; i++) {
				if (num % i == 0) {
					if (i == (num / i)) {
						if (i % 2 != 0)
							result += i;
					} else {
						if (i % 2 != 0)
							result += i;
						if ((num / i) % 2 != 0)
							result += (num / i);

					}
				}
			}
			if (num % 2 != 0)
				result += num;
			if (num == 1)
				--result;
			System.out.println(++result);
		}
		br.close();
	}
}
