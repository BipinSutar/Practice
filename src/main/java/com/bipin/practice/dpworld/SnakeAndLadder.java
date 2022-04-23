package com.bipin.practice.dpworld;

import java.util.HashMap;
import java.util.HashSet;

public class SnakeAndLadder {

	public static void main(String[] args) {
		System.out.println(minMoves(new int[] { 5, 12, 18, 27 }, new int[] { 16, 4, 28, 11 }));
	}

//    1-36 ,Ladder-[5,12],[18-27]
//    Snake- [4,16],[11,28]
	// dice 1,6
	public static int minMoves(int ladders[], int snakes[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < ladders.length; i += 2) {
			map.put(ladders[i], ladders[i + 1]);
		}
		for (int i = 0; i < snakes.length; i += 2) {
			map.put(snakes[i], snakes[i + 1]);
		}
		HashSet<Integer> visited = new HashSet<Integer>();
		HashSet<Integer> visited2 = new HashSet<Integer>();
		int steps = 0;
		int dice[] = new int[] { 1, 2, 3, 4, 5, 6 };
		visited.add(1);
		while (!visited.contains(33)) {
			steps += 1;
			HashSet<Integer> diceSet = new HashSet<Integer>();
			for (Integer v : visited) {
				for (Integer i : dice) {
					int current = v + i;
					if (map.containsKey(current)) {
						current = map.get(current);
					}
					if (visited2.contains(current)) {
						continue;
					}
					visited2.add(current);
					diceSet.add(current);
				}
			}
			visited = diceSet;

		}
		return steps;
	}

}
