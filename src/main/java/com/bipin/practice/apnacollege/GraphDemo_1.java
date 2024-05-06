package com.bipin.practice.apnacollege;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class GraphDemo_1 {

    static class Edge {
        private int src;
        private int dest;
        private int weight;

        public Edge(int src, int dest) {
            this(src, dest, 0);
        }

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [src=" + src + ", dest=" + dest + "]";
        }

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        String currPath = "0";
        dfs(graph, 0, allPaths, new boolean[graph.length], graph.length - 1, currPath);
        return allPaths;
    }

    public void dfs(int[][] graph, int curr, List<List<Integer>> allPaths, boolean vis[], int target, String currPath) {
        if (curr == target) {
            String[] strNums = currPath.split("~");
            allPaths.add(new ArrayList<>());
            System.out.println(currPath);
            for (int i = 0; i < strNums.length; i++) {
                allPaths.get(allPaths.size() - 1).add(Integer.parseInt(strNums[i]));
            }
            return;
        }
        for (int i = 0; i < graph[curr].length; i++) {
            int edge = graph[curr][i];
            if (vis[edge] == false) {
                vis[curr] = true;
                dfs(graph, edge, allPaths, vis, target, currPath + "~" + edge);
                vis[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        GraphDemo_1 o = new GraphDemo_1();

        System.out.println(o.allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));
    }
}
