package com.bipin.practice.sort;

import java.util.Arrays;

public class MergeArrayProgram {
	
	public static void main(String[] args) {
		int[] arrayA = new int[] { 1, 1, 2, 2 };

		int[] arrayB = new int[] { 1, 1, 2, 2 };

		int[] mergedArray = mergeArray(arrayA, arrayB);

		System.out.println("Array A : " + Arrays.toString(arrayA));

		System.out.println("Array B : " + Arrays.toString(arrayB));

		System.out.println("Merged Array : " + Arrays.toString(mergedArray));
	}

	private static int[] mergeArray(int[] arrayA, int[] arrayB) {
		int[] mergedArray = new int[arrayA.length + arrayB.length];

		int i = 0, j = 0, k = 0;

		while (i < arrayA.length || j < arrayB.length) {
			k = i + j;
			if (arrayA[i] < arrayB[j]) {
				mergedArray[k] = arrayA[i];
				i++;
			} else {
				mergedArray[k] = arrayB[j];
				j++;
			}
		}

		/*
		 * while (i < arrayA.length) { mergedArray[k] = arrayA[i]; i++; k++; }
		 * 
		 * while (j < arrayB.length) { mergedArray[k] = arrayB[j]; j++; k++; }
		 */
		return mergedArray;
	}

}