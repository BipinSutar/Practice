package com.bipin.practice.hackerearrth._2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LazyPay_19Apr {
	final static int mod = 1000000007;
	private int V; // No. of vertices
	ArrayList<Integer> adj[]; // Adjacency List

	LazyPay_19Apr() {

	}
	LazyPay_19Apr(int v) {
		V = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new ArrayList();
	}
	public static void main(String[] args) {

	}
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	public int getGoodSequences(String s, int N[]) {
		int ans = 0;

		Map<Integer, Integer> charFreq = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			int key = Integer.parseInt(s.charAt(i) + "");
			if (!charFreq.containsKey(key)) {
				charFreq.put(key, 1);
			} else {
				charFreq.put(key, charFreq.get(key) + 1);
			}
		}
		Set<Integer> seq = new LinkedHashSet<>();
		for (int i = 0; i < N.length; i++) {
			seq.add(N[i]);
		}
		long modans = 1L;
		for (Map.Entry<Integer, Integer> me : charFreq.entrySet()) {
			if (seq.contains(me.getKey())) {
				modans = (modans * me.getValue()) % mod;
			}
		}
		return (int) modans % mod;
	}
	static int totalNodes(ArrayList<Integer> adjac[], int n, int x, int y) {
		if (x == y) {
			return 1;

		}
		// x is the source node and
		// y is destination node

		// visited array take account of
		// the nodes visited through the bfs
		Boolean visited[] = new Boolean[n + 1];

		// filling boolean value with false
		Arrays.fill(visited, false);

		// parent array to store each nodes
		// parent value
		int p[] = new int[n];

		Queue<Integer> q = new LinkedList<>();
		q.add(x);

		// take our first node(x) as first element
		// of queue and marked it as
		// visited through visited[] array
		visited[x] = true;

		int m;

		// normal bfs method starts
		while (!q.isEmpty()) {
			m = q.peek();
			q.poll();
			for (int i = 0; i < adjac[m].size(); ++i) {

				int h = adjac[m].get(i);

				if (visited[h] != true) {
					visited[h] = true;
					p[h] = m;
					q.add(h);
				}
			}
		}

		int count = 0;

		int i = p[y];
		while (i != x) {
			count++;
			i = p[i];

		}
		return count;
	}

}
