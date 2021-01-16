package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class PassS {
	public static void main1(String[] args) {
		PassS p = new PassS();
		p.start();
	}

	void start() {
		String s1 = "sleep";
		String s2 = fix(s1);
		System.out.println(s1 + " " + s2);
	}

	String fix(String s1) {
		s1 = s1 + "stream";
		System.out.print(s1 + " ");
		return "steem";
	}
}

class Base {
	static int x = 10;
}

class Derived extends Base {
	public static void fun() {
		//System.out.println(super.x);
	}
}

class Super {
	public int i = 0;

	public Super(String text) /* Line 4 */
	{
		i = 1;
	}
}


class Test {
	public Test() {
		int x = 5;
		//return x;
	}
}

public class DEShaw_22Apr {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (; t > 0; t--) {
			int n = Integer.parseInt(br.readLine());
			int A[] = new int[n];
			String line[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				A[i] = Integer.parseInt(line[i]);

			}
			System.out.println(pairANDSum(A, n));
			System.out.println(pairAndSum(A, n));
			// System.out.println(cal(A, n));

		}
		br.close();
	}

	static int pairAndSum(int arr[], int n) {
		long ans = 0; // Initialize result
		int MODULO = 1000000007;
		// Traverse over all bits
		for (int i = 0; i < 32; i++) {
			// Count number of elements with i'th bit set
			// Initialize the count
			int k = 0;
			for (int j = 0; j < n; j++) {
				if ((arr[j] & power2int(i)) == 1)
					k++;
			}

			// There are k set bits, means k(k-1)/2 pairs.
			// Every pair adds 2^i to the answer. Therefore,
			// we add "2^i * [k*(k-1)/2]" to the answer.
			ans += power2int(i) * (k * (k - 1) / 2);
			// ans = ans + ((1 << i) % MODULO * (k * (k - 1) % MODULO / 2)) % MODULO;

		}
		return (int) (ans) % MODULO;
	}

	static int pairANDSum(int arr[], int n) {
		int ans = 0; // Initialize result
		int MODULO = 1000000007;
		for (int i = 0; i < 32; i++) {
			// Count number of elements with i'th bit not set
			int k = 0; // Initialize the count
			for (int j = 0; j < n; j++)
				if ((arr[j] & power2int(i)) == 1)
					// if ((arr[j] & power2int(i)) == 0)
					k++;

			// ans += (1 << i) * (n * (n - 1) / 2 - k * (k - 1) / 2);
			int poweri = power2int(i) % MODULO;
			int n_mul = ((n * (n - 1)) % MODULO / 2);
			int k_mul = ((k * (k - 1)) % MODULO / 2);
			ans = ans + ((poweri * (n_mul - k_mul)) % MODULO) % MODULO;
		}

		return (ans);
	}

	public static int power2int(int n) {
		long ret = 1;
		long a = 2;
		long MODULO = 1000000007;
		while (n > 0) {
			if (n % 2 != 0)
				ret = ret * a % MODULO;
			a = a * a % MODULO;
			n >>= 1;
			// System.out.println("n= " + n + " a =" + a + " ret=" + ret);
		}
		return (int) ((ret) % MODULO);
	}

	public static int cal(int arr[], int n) {
		long sum = 0;
		int m = 1_000_000_007;
		// System.out.println(1 << n);
		for (int i = 0; i < (1 << n); i++) {
			// System.out.print(i + " { ");
			int or = 0;
			// Print current subset
			for (int j = 0; j < n; j++)

				if ((i & (1 << j)) > 0) {
					// System.out.print(arr[j] + " ");
					or = (or & arr[j]) % m;
				}
			// System.out.println("} " + or);
			sum = (sum + or) % m;
		}
		return (int) sum;
	}
}
