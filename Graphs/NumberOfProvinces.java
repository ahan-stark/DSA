// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int adj[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        Solution solution = new Solution();
        int totalProvinces = solution.getProvinces(adj);
        System.out.println("Total Provinces : " + totalProvinces);
    }

    private static class Solution {
        private int getProvinces(int adj[][]) {
            int count = 0;
            List<List<Integer>> adjList = new ArrayList<>();
            int vertices = adj.length;
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj[i].length; j++) {
                    if (adj[i][j] == 1 && i != j) {
                        adjList.get(i).add(j);
                    }
                }
            }
            boolean vis[] = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (vis[i] != true) {
                    count = count + 1;
                    dfs(i, adjList, vis);
                }
            }
            return count;
        }

        private void dfs(int node, List<List<Integer>> adjList, boolean[] vis) {
            vis[node] = true;
            for (int i = 0; i < adjList.get(node).size(); i++) {
                if (vis[adjList.get(node).get(i)] != true) {
                    dfs(adjList.get(node).get(i), adjList, vis);
                }
            }
        }

    }
}
// To find the number of provinces at first we will check with dfs staring from
// node 0 to end .that is all the vertices

// in the dfs -> {{1,2},{3,1},{2,3},{1,2},{7,8}}

// we first loop from 0 and it is not visted find depth of 0 -> 1,2 ->1,3 -> 2,3
// ->1,2 ...this is just random
// in depthn the dfs will vist them..if the vertices what we are hvaing is not
// visted then we have to dfs that..so in the starting of dfs keep the count as
// 0 and for main vertices loop check if it is visted if not increase the count
// + 1, that is provinces...if 0,1,2 are already visted in 0 dfs the 1 and 2
// wont happen dfs again becuase it is already visted so dont increment the
// count
