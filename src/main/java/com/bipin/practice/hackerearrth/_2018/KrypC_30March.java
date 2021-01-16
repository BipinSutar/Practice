package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class KrypC_30March {

	public static void main1(String[] args) {

		// System.out.println(power2int(1));
		// System.exit(0);
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (; t > 0; t--) {
			int n = sc.nextInt();
			int A[] = new int[n];
			Random a = new Random();
			for (int i = 0; i < n; i++) {
				A[i] = a.nextInt(100000);// sc.nextInt();

			}
			System.out.println(pairORSum(A, n));
			System.out.println(cal(A, n));

		}
		sc.close();

	}

	static int pairORSum(int arr[], int n) {
		int ans = 0; // Initialize result
		int MODULO = 1000000007;
		System.out.println("A " + (1 << 32));
		System.out.println("B " + (1 << 29));
		System.out.println("C " + power2int(29));
		System.out.println("D " + Integer.toBinaryString(100000).length());
		for (int i = 0; i < 18; i++) {
			// Count number of elements with i'th bit not set
			int k = 0; // Initialize the count
			for (int j = 0; j < n; j++)
				if ((arr[j] & (1 << i)) == 0)
					// if ((arr[j] & power2int(i)) == 0)
					k++;

			// There are k not set bits, means k(k-1)/2 pairs that don't contribute to the
			// total sum, out of n*(n-1)/2 pairs.
			// So we subtract the ones from don't contribute from the ones that do.
			// ans += (1 << i) * (n - k);
			// ans += (1 << i) * (n * (n - 1) - k * (k - 1)) / 2;
			// ans += (1 << i) * (n * (n - 1) * (n - 2) - k * (k - 1) * (k - 2)) / 6;
			// ans += (1 << i) * (n * (n - 1) * (n - 2) * (n - 3) - k * (k - 1) * (k - 2) *
			// (k - 3)) / 24;
			// long diff = ((1 << i) * (power2int(n) - power2int(k))) % MODULO;
			// int diff = (power2int(i) * (power2int(n) - power2int(k))) % MODULO;
			// if (k >= n)
			// break;
			// int diff = power2int(n) - power2int(k);
			// diff = (power2int(i) % MODULO * (diff % MODULO)) % MODULO;
			int diff = ((1 << i) % MODULO * (power2int(k) % MODULO * (power2int(n - k) - 1) % MODULO)) % MODULO;
			ans = (ans + diff) % MODULO;

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
					or = (or | arr[j]) % m;
				}
			// System.out.println("} " + or);
			sum = (sum + or) % m;
		}
		return (int) sum;
	}

	public static void main2(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String[] arr_A = br.readLine().split(" ");
			int N = Integer.parseInt(arr_A[0]);
			int K = Integer.parseInt(arr_A[1]);
			arr_A = br.readLine().split(" ");
			int[] A = new int[N];
			for (int i_A = 0; i_A < arr_A.length; i_A++) {
				A[i_A] = Integer.parseInt(arr_A[i_A]);
			}

			System.out.println(solve_query(A, N, K));
		}

		wr.close();
		br.close();
	}

	static String solve_query(int[] A, int n, int sum) {
		int op1[] = new int[n];
		int try1 = 0;
		for (int i = 0; i < n; i++) {
			op1[i] = A[i];
			try1 += A[i];
		}
		if (try1 == sum)
			return "YES";
		try1 = 0;
		int op2[] = new int[n];
		for (int i = 0; i < n; i++) {
			op2[i] = -A[i];
			try1 += op2[i];
		}
		if (try1 == sum)
			return "YES";
		try1 = 0;
		int op3[] = new int[n];
		for (int i = 0; i < n; i++) {
			op3[i] = A[i] + i;
			try1 += op3[i];
		}
		if (try1 == sum)
			return "YES";
		try1 = 0;
		int op4[] = new int[n];
		for (int i = 0; i < n; i++) {
			op4[i] = A[i] - i;
			try1 += op4[i];
		}
		if (try1 == sum)
			return "YES";
		try1 = 0;

		return solve_query(A, op1, op2, op3, op4, n, sum);

	}

	static String solve_query(int[] A, int op1[], int op2[], int op3[], int op4[], int n, int sum) {
		// Arrays.sort(op1);
		// Arrays.sort(op2);
		// Arrays.sort(op3);
		// Arrays.sort(op4);
		for (int i = 0; i < n; i++) {

		}
		return "";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr_A = null; // br.readLine().split(" ");
		long a = System.currentTimeMillis();
		int N = 100000;// Integer.parseInt(arr_A[0]);
		int Q = 5;// Integer.parseInt(arr_A[1]);
		int arr[] = new int[N];
		// arr_A = br.readLine().split(" ");
		String arr_bin[] = new String[N];
		int arr_bin_count_one[] = new int[N];
		Random rand = new Random();
		for (int i = 0; i < N; i++) {
			arr[i] = rand.nextInt(1000_000_000);// Integer.parseInt(arr_A[i]);
			arr_bin[i] = Integer.toBinaryString(arr[i]);
			arr_bin_count_one[i] = getCountOne(arr_bin[i]);
		}
		while (Q-- > 0) {
			int k = rand.nextInt(1000);// Integer.parseInt(br.readLine());
			System.out.println(getMinimum(arr, arr_bin, arr_bin_count_one, k));
		}
		long b = System.currentTimeMillis();
		System.out.println(b - a);
		br.close();
	}

	public static int getMinimum(int[] arr, String arr_bin[], int arr_bin_count_one[], int k) {
		int windowsum = 0;
		int len = Integer.MAX_VALUE;
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			windowsum += arr_bin_count_one[right];
			while (windowsum >= k && left <= right + 1) {
				len = Math.min(len, right - left + 1);
				windowsum -= arr_bin_count_one[left];
				left++;
			}
		}
		return len == Integer.MAX_VALUE ? -1 : len;
	}

	public static int getCountOne(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				count++;
		}
		return count;
	}
}
