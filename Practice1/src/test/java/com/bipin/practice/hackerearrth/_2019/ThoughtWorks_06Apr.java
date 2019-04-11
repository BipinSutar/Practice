package com.bipin.practice.hackerearrth._2019;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ThoughtWorks_06Apr {
	public static void main(String[] args) {

	}
	public int getStringSimplificationCount(String in, int k) {
		int ans = 0;
		HashMap<Character, TreeSet<Integer>> charPositions = getCharFrequency(
				in);
		for (int i = 0; i < in.length(); i++) {
			int pos = i;
			int count = 0;
			for (Map.Entry<Character, TreeSet<Integer>> me : charPositions
					.entrySet()) {
				if (me.getValue().headSet(pos, true).size() == me.getValue()
						.tailSet(pos, false).size()) {
					count++;
				}
			}
			if (count >= k) {
				ans++;
			}
		}
		return ans;
	}
	private HashMap<Character, TreeSet<Integer>> getCharFrequency(String in) {
		HashMap<Character, TreeSet<Integer>> charPositions = new HashMap<>();
		for (int i = 0; i < in.length(); i++) {
			if (!charPositions.containsKey(in.charAt(i))) {
				charPositions.put(in.charAt(i), new TreeSet<>());
			}
			charPositions.get(in.charAt(i)).add(i);
		}
		return charPositions;
	}
	private int insert(int[] heap, int size, int element) {
		heap[++size] = element;

		// Traverse up and fix violated property
		int current = size;

		while (heap[current] < heap[parent(current)]) {
			// swap(current, parent(current));
			int temp = heap[parent(current)];
			heap[parent(current)] = heap[current];
			heap[current] = temp;
			current = parent(current);
		}
		return size;
	}
	private int parent(int pos) {
		return pos / 2;
	}
	public String getGameOfStairsAns(int q, int heights[], int steps[]) {
		StringBuilder sb = new StringBuilder();
		TreeSet<Integer> tset = new TreeSet<>();
		for (int i = 0; i < q; i++) {
			tset.add(heights[i]);
			int h = getHeight(tset, steps[i] - 1);
			sb.append(h + " ");
		}
		return sb.toString();
	}
	private int getHeight(TreeSet<Integer> tset, int step) {
		int h = 0;

		for (Integer i : tset) {
			if (h == step) {
				return i;
			}
			h++;
		}

		return h;
	}

}
