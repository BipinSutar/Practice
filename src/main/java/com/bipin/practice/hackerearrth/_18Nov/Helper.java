package com.bipin.practice.hackerearrth._18Nov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Helper {

	public static void main(String[] args) {
		int array_size = 103;
		int small_size = 10;
		int data[] = new int[array_size];
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < array_size; i++) {
			data[i] = (int) (Math.random() * 10);
		}
		for (int i = 0; i < 5 * 100000; i++) {
			al.add((int) (Math.random() * 10));
		}
		System.out.println();
		int datachunk[][] = chunkArray(data, small_size);
		for (int i = 0; i < datachunk.length; i++) {
			for (int j = 0; j < datachunk[0].length; j++) {
				System.out.print(datachunk[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] chunkArray(int[] array, int chunkSize) {
		int numOfChunks = (int) Math.ceil((double) array.length / chunkSize);
		int[][] output = new int[numOfChunks][];

		for (int i = 0; i < numOfChunks; ++i) {
			int start = i * chunkSize;
			int length = Math.min(array.length - start, chunkSize);

			int[] temp = new int[length];
			System.arraycopy(array, start, temp, 0, length);
			output[i] = temp;
		}

		return output;
	}
	
}
