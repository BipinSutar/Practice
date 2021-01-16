package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Niyo_Java_05Oct {
	static final int INT_BITS = 32;
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		br.close();
		// int set[] = {9, 8, 5};
		int set[] = {1, 2, 1, 2, 1, 2};
		// int set[] = {8, 1, 2, 12, 7, 6};
		int n = set.length;

		System.out.println(
				"Max subset XOR is " + splitTheBallsInto4BasketUsingN2(set));
	}
	public static int splitTheBallsInto4BasketUsingN2(int arr[]) {
		List<Integer> orig_arr = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			orig_arr.add(arr[i]);
		}
		int ans = 0;
		Set<Integer> indexesMarked = new HashSet<>();
		for (int basket = 1; basket <= 3; basket++) {
			int maxXorSum = Integer.MIN_VALUE;
			Set<Integer> indexesMarkedForbucket = new HashSet<>();
			for (int i = 0; i < orig_arr.size(); i++) {
				int currXor = 0;
				int maxCurrXorForPair = Integer.MIN_VALUE;
				Set<Integer> indexesMarkedForPair = new HashSet<>();
				for (int j = i; j < orig_arr.size(); j++) {
					if (!indexesMarked.contains(j)) {
						currXor = (currXor ^ orig_arr.get(j));
						if (currXor > maxCurrXorForPair) {
							maxCurrXorForPair = currXor;
							// orig_arr.remove(j);
							indexesMarkedForPair.add(j);
						}
					}
				}
				if (maxCurrXorForPair > maxXorSum) {
					maxXorSum = maxCurrXorForPair;
					indexesMarkedForbucket.clear();
					indexesMarkedForbucket.addAll(indexesMarkedForPair);

				}

			}
			indexesMarked.addAll(indexesMarkedForbucket);
			ans = ans + maxXorSum;
		}
		int currXor = 0;
		for (int i = 0; i < orig_arr.size(); i++) {
			if (!indexesMarked.contains(i)) {
				currXor = (currXor ^ orig_arr.get(i));
			}
		}
		return ans + currXor;

	}

	// Function to return
	// maximum XOR subset
	// in set[]
	static int maxSubarrayXOR(int set[], int n) {
		// Initialize index of
		// chosen elements
		int index = 0;

		// Traverse through all
		// bits of integer
		// starting from the most
		// significant bit (MSB)
		for (int i = INT_BITS - 1; i >= 0; i--) {
			// Initialize index of
			// maximum element and
			// the maximum element
			int maxInd = index;
			int maxEle = Integer.MIN_VALUE;
			for (int j = index; j < n; j++) {

				// If i'th bit of set[j]
				// is set and set[j] is
				// greater than max so far.
				if ((set[j] & (1 << i)) != 0 && set[j] > maxEle) {
					maxEle = set[j];
					maxInd = j;
				}
			}

			// If there was no
			// element with i'th
			// bit set, move to
			// smaller i
			if (maxEle == -2147483648)
				continue;

			// Put maximum element
			// with i'th bit set
			// at index 'index'
			int temp = set[index];
			set[index] = set[maxInd];
			set[maxInd] = temp;

			// Update maxInd and
			// increment index
			maxInd = index;

			// Do XOR of set[maxIndex]
			// with all numbers having
			// i'th bit as set.
			for (int j = 0; j < n; j++) {

				// XOR set[maxInd] those
				// numbers which have the
				// i'th bit set
				if (j != maxInd && (set[j] & (1 << i)) != 0)
					set[j] = set[j] ^ set[maxInd];
			}

			// Increment index of
			// chosen elements
			index++;
		}

		// Final result is
		// XOR of all elements
		int res = 0;
		for (int i = 0; i < n; i++) {
			System.out.print(set[i] + " , ");
			res ^= set[i];
		}
		return res;
	}
}
