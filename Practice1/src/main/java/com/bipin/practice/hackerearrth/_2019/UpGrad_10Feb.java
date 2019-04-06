package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class UpGrad_10Feb {

	public static void mainAbsoluteRemoval(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			int a = Integer.parseInt(br.readLine());
			int arr[] = new int[a];
			String line[] = br.readLine().split(" ");
			for (int i = 0; i < a; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			sb.append(getMinSum(arr) + "\n");

		}
		System.out.println(sb.toString());
		br.close();
	}
	public static int getAbsDiff(int a, int b) {
		return Math.abs(a - b);
	}

	public static long getMinSum(int arr[]) {
		int maxAbsDiff = Integer.MIN_VALUE;
		long sum = 0;
		int removeIndex = -1;
		int lengthMinOne = arr.length - 1;

		for (int i = 0; i < lengthMinOne; i++) {
			int iplus1 = i + 1;
			int currAbsDiff = getAbsDiff(arr[i], arr[iplus1]);
			if (currAbsDiff > maxAbsDiff) {
				maxAbsDiff = currAbsDiff;
				removeIndex = arr[i] > arr[iplus1] ? i : iplus1;
			}
			sum = sum + currAbsDiff;
		}
		if (removeIndex == 0) {
			sum = sum - getAbsDiff(arr[0], arr[1]);
		} else if (removeIndex == lengthMinOne) {
			sum = sum - getAbsDiff(arr[lengthMinOne - 1], arr[lengthMinOne]);
		} else {
			sum = sum - getAbsDiff(arr[removeIndex - 1], arr[removeIndex])
					- getAbsDiff(arr[removeIndex], arr[removeIndex + 1])
					+ getAbsDiff(arr[removeIndex - 1], arr[removeIndex + 1]);
		}
		return sum;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int val[] = new int[n];
			int h[] = new int[n];
			String line[] = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				val[i] = Integer.parseInt(line[i]);
			}
			line = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				h[i] = Integer.parseInt(line[i]);
			}
			int m = Integer.parseInt(br.readLine());
			int mindex[] = new int[m];
			int min_Height_index[] = new int[m];
			line = br.readLine().split(" ");
			for (int i = 0; i < m; i++) {
				mindex[i] = Integer.parseInt(line[i]);
			}
			line = br.readLine().split(" ");
			for (int i = 0; i < m; i++) {
				min_Height_index[i] = Integer.parseInt(line[i]);
			}
			sb.append(getJumpOverThis(n, val, h, m, mindex, min_Height_index)
					+ "\n");

		}
		System.out.println(sb.toString());
		br.close();
	}
	public static long getJumpOverThis(int n, int val[], int h[], int m,
			int mindex[], int min_Height_index[]) {
		Map<Integer, Integer> tmap = getMapOfMinHeightIndexAndValue(mindex,
				min_Height_index);
		long height = h[0];
		long sum = 0;
		long maxSumofHeightRequired = getSumHeight(min_Height_index);
		// if (tmap.containsKey(0)) {
		// int minHeightRequiredAtindex = tmap.get(0);
		// if (h[0] >= minHeightRequiredAtindex) {
		// if (h[0] > val[0]) {
		// height = height + h[0];
		// } else {
		// sum = sum + val[0];
		// }
		// } else {
		// return -1;
		// }
		//
		// } else {
		// if (h[0] > val[0]) {
		// height = height + h[0];
		// } else {
		// sum = sum + val[0];
		// }
		// }
		for (int i = 0; i < n; i++) {
			if (tmap.containsKey(i)) {
				int minHeightRequiredAtindex = tmap.get(i);
				if (height >= minHeightRequiredAtindex) {
					if (h[i] > val[i] && (!tmap.isEmpty()
							| height < maxSumofHeightRequired)) {
						height = height + h[i];
					} else {
						sum = sum + val[i];
					}
				} else {
					return -1;
				}
				tmap.remove(i);

			} else {
				if (tmap.isEmpty() || height >= maxSumofHeightRequired) {
					sum = sum + val[i];
					continue;
				} else if (h[i] > val[i]) {
					height = height + h[i];
				} else {
					sum = sum + val[i];
				}
			}
		}
		return sum;

	}
	private static long getSumHeight(int[] min_Height_index) {
		long sum = min_Height_index[0];
		for (int i = 1; i < min_Height_index.length; i++) {
			sum = sum + min_Height_index[i];
		}
		return sum;
	}
	public static Map<Integer, Integer> getMapOfMinHeightIndexAndValue(
			int mindex[], int min_Height_index[]) {
		Map<Integer, Integer> tmap = new TreeMap<>();
		for (int i = 0; i < min_Height_index.length; i++) {
			tmap.put(mindex[i], min_Height_index[i]);
		}

		return tmap;
	}
}
