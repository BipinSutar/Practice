package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
class FenwickTree {

	/**
	 * Start from index+1 if you updating index in original array. Keep adding
	 * this value for next node till you reach outside range of tree
	 */
	public void updateBinaryIndexedTree(int binaryIndexedTree[], int val,
			int index) {
		while (index < binaryIndexedTree.length) {
			binaryIndexedTree[index] += val;
			index = getNext(index);
		}
	}

	/**
	 * Start from index+1 if you want prefix sum 0 to index. Keep adding value
	 * till you reach 0
	 */
	public int getSum(int binaryIndexedTree[], int index) {
		index = index + 1;
		int sum = 0;
		while (index > 0) {
			sum += binaryIndexedTree[index];
			index = getParent(index);
		}
		return sum;
	}

	/**
	 * Creating tree is like updating Fenwick tree for every value in array
	 */
	public int[] createTree(int input[]) {
		int binaryIndexedTree[] = new int[input.length + 1];
		for (int i = 1; i <= input.length; i++) {
			updateBinaryIndexedTree(binaryIndexedTree, input[i - 1], i);
		}
		return binaryIndexedTree;
	}

	/**
	 * To get parent 1) 2's complement to get minus of index 2) AND this with
	 * index 3) Subtract that from index
	 */
	private int getParent(int index) {
		return index - (index & -index);
	}

	/**
	 * To get next 1) 2's complement of get minus of index 2) AND this with
	 * index 3) Add it to index
	 */
	private int getNext(int index) {
		return index + (index & -index);
	}
}
public class Shuttl_03Nov {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine().trim());
		TreeMap<Integer, Integer> tmap = new TreeMap<>();
		while (q-- > 0) {
			String line[] = br.readLine().split(" ");
			int type = Integer.parseInt(line[0]);
			switch (type) {
				case 1 : {
					int x = Integer.parseInt(line[1]);
					int y = Integer.parseInt(line[2]);
					if (tmap.containsKey(x)) {
						tmap.put(x, tmap.get(x) + y);
					} else {
						tmap.put(x, y);
					}
					break;
				}
				case 2 : {
					int n = Integer.parseInt(line[1]);
					break;
				}
			}
		}
		br.close();

	}

}
