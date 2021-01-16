package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class Furlenco_1July {
	static class Exc0 extends Exception {
	}

	static class Exc1 extends Exc0 {
	} /* Line 2 */

	class Test {

	}

	public static void main1(String[] args) {
		Furlenco_1July p = new Furlenco_1July();
		p.start();
		Furlenco_1July junk = new Furlenco_1July();
		junk.sampleMap();
		try {
			throw new Exc1(); /* Line 9 */
		} catch (Exc0 e0) /* Line 11 */
		{
			System.out.println("Ex0 caught");
		} catch (Exception e) {
			System.out.println("exception caught");
		}
	}

	void start() {
		long[] a1 = { 3, 4, 5 };
		long[] a2 = fix(a1);
		System.out.print(a1[0] + a1[1] + a1[2] + " ");
		System.out.println(a2[0] + a2[1] + a2[2]);
	}

	long[] fix(long[] a3) {
		a3[1] = 7;
		return a3;
	}

	public void sampleMap() {
		TreeMap tm = new TreeMap();
		tm.put("a", "Hello");
		tm.put("b", "Java");
		tm.put("c", "World");
		Iterator it = tm.keySet().iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
	}

	public static void main2(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine().trim());
		TreeMap<Integer, Integer> costmap = new TreeMap<>();
		int costA[] = new int[12];
		for (int i = 0; i < 12; i++) {
			String line[] = br.readLine().trim().split(" ");
			int cost = Integer.parseInt(line[2]);
			costmap.put(i, cost);
			costA[i] = cost;
		}

		br.close();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			String line[] = br.readLine().trim().split(" ");
			int Q = Integer.parseInt(line[0]);
			int K = Integer.parseInt(line[1]);

			int s_q[][] = new int[Q][];
			List<List<Integer>> list = new ArrayList<>();
			for (int i_q = 0; i_q < Q; i_q++) {
				int N = Integer.parseInt(br.readLine().trim());
				List<Integer> rowlist = new ArrayList<>();
				s_q[i_q] = new int[N];
				line = br.readLine().trim().split(" ");
				for (int i = 0; i < N; i++) {
					int cost = Integer.parseInt(line[i]);
					s_q[i_q][i] = cost;
					rowlist.add(cost);
				}
				list.add(rowlist);
			}
			int index[] = new int[Q];
			int total = 0;
			while (K >= 0) {
				int minCol = Integer.MAX_VALUE;
				int rowIndex = -1;
				int colIndex = -1;
				for (int i = 0; i < Q; i++) {
					if (minCol > list.get(i).get(index[0])) {
						minCol = list.get(i).get(index[0]);
						rowIndex = i;
						colIndex = index[i];
					}
				}
				total = total + minCol;
				list.get(rowIndex).remove(colIndex);
				index[rowIndex]++;
				K--;
			}
			System.out.println(total);
		}
		br.close();
	}

	public static int min(int a, int b) {
		return a < b ? a : b;
	}
}
