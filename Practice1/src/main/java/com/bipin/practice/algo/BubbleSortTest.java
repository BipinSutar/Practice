package com.bipin.practice.algo;

public class BubbleSortTest {

	public static void main(String[] args) {
		int[] array = {90,80,70,60,50,40,30,20,10 };
		bubbleSort(array);
	}

	public static void bubbleSort(int array[]) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					array[j] = array[j] + array[j + 1];
					array[j + 1] = array[j] - array[j + 1];
					array[j] = array[j] - array[j + 1];
					counter++;
				}
			}
		}
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("Iterations took " + counter);
	}
}
