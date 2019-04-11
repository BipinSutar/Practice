package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class Wissen_06Apr {
	private int V;
	List<Integer> dfs_travel;
	private LinkedList<Integer> adj[];
	@Override
	public String toString() {
		return dfs_travel.toString();
	}
	Wissen_06Apr() {

	}
	// Constructor
	Wissen_06Apr(int v) {
		this.V = v;
		adj = new LinkedList[v + 1];
		for (int i = 0; i < adj.length; i++)
			adj[i] = new LinkedList<Integer>();
		dfs_travel = new ArrayList<>();
	}

	final class SubArrayPositionAns {
		final private int L;
		final private int R;
		final static private String SPACE = " ";
		public SubArrayPositionAns(int L, int R) {
			this.L = L;
			this.R = R;
		}
		public int getL() {
			return L;
		}
		public int getR() {
			return R;
		}
		@Override
		public String toString() {
			return L + SPACE + R;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + L;
			result = prime * result + R;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SubArrayPositionAns other = (SubArrayPositionAns) obj;

			if (L != other.L)
				return false;
			if (R != other.R)
				return false;
			return true;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int folders[] = new int[n];
		String line[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			folders[i] = Integer.parseInt(line[i]);
		}
		int m = Integer.parseInt(br.readLine());
		line = br.readLine().split(" ");
		int del[] = new int[m];
		for (int i = 0; i < m; i++) {
			del[i] = Integer.parseInt(line[i]);
		}
		System.out.println(new Wissen_06Apr().processDirectoryDeletion(n,
				folders, m, del));
		br.close();
	}

	public Set<SubArrayPositionAns> getSubArrayPositionAns(final int arr[]) {
		Set<SubArrayPositionAns> subArrPositions = new HashSet<>();
		double sumArr = 0;
		for (int i = 0; i < arr.length; i++) {
			sumArr += arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			double sumSubArr = 0.0d;
			double remainSum = 0.0d;
			double remainAvg = 0.0d;
			for (int j = i; j < arr.length; j++) {
				sumSubArr = sumSubArr + arr[j];
				double avgSubArr = sumSubArr / ((j - i) + 1.0d);
				remainSum = sumArr - sumSubArr;
				remainAvg = remainSum == 0
						? 0
						: remainSum / (arr.length - j + i - 1);
				if (avgSubArr > remainAvg) {
					subArrPositions.add(new SubArrayPositionAns(i + 1, j + 1));
				}
			}
		}
		return subArrPositions;
	}
	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v’s list.
	}

	public int DFS(int s, Set<Integer> tset) {
		// Initially mark all vertices as not visited
		List<Integer> dfs_travel = new Vector<>();
		List<Boolean> visited = new Vector<Boolean>(V);
		for (int i = 0; i <= V; i++)
			visited.add(false);

		// Create a stack for DFS
		Stack<Integer> stack = new Stack<>();

		// Push the current source node
		stack.push(s);

		while (stack.empty() == false) {
			// Pop a vertex from stack and print it
			s = stack.pop();

			// Stack may contain same vertex twice. So
			// we need to print the popped item only
			// if it is not visited.
			if (visited.get(s) == false && tset.contains(s)) {
				dfs_travel.add(s);
				visited.set(s, true);
			}

			// Get all adjacent vertices of the popped vertex s
			// If a adjacent has not been visited, then puah it
			// to the stack.
			if (!tset.contains(s)) {
				Iterator<Integer> itr = adj[s].iterator();
				while (itr.hasNext()) {
					int v = itr.next();
					if (!visited.get(v))
						stack.push(v);
				}
			}
		}
		return dfs_travel.size();
	}

	private int processDirectoryDeletion(int n, int[] folders, int m,
			int[] idsTodelete) {
		Wissen_06Apr g = new Wissen_06Apr(n);
		Set<Integer> tset = new HashSet<Integer>();
		for (int i = 0; i < idsTodelete.length; i++) {
			tset.add(idsTodelete[i]);
		}
		g.addEdge(0, 1);
		int ans = 0;
		for (int i = 1; i < n; i++) {
			g.addEdge(folders[i], i + 1);
		}
		return g.DFS(1, tset);
	}

}
