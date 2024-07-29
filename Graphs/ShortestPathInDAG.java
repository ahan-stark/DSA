// Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

// Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {
    public static void main(String[] args) {
        int graph[][] = { { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 }, { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 }, { 5, 3, 1 } };
        int src = 0;
        int n = 6;
        Solution solution = new Solution();
        int distArr[] = solution.getShortestDist(graph, n, src);
        for (int ele : distArr) {
            System.out.println(ele);
        }

    }

    private static class Solution {
        private int[] getShortestDist(int graph[][], int n, int src) {
            List<List<Pairs>> adjList = new ArrayList<>();
            int dis[] = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < graph.length; i++) {
                adjList.get(graph[i][0]).add(new Pairs(graph[i][1], graph[i][2]));
            }
            dis[src] = 0;
            Stack<Integer> stack = new Stack<>();
            boolean vis[] = new boolean[n];
            dfs(src, stack, adjList, vis);
            while (!stack.isEmpty()) {
                int node = stack.pop();
                for (int i = 0; i < adjList.get(node).size(); i++) {
                    Pairs curPair = adjList.get(node).get(i);
                    int edge = curPair.edge;
                    int edgeDist = curPair.dis;
                    if (dis[node] + edgeDist < dis[edge]) {
                        dis[edge] = dis[node] + edgeDist;
                    }
                }
            }
            for (int i = 0; i < dis.length; i++) {
                if (dis[i] == Integer.MAX_VALUE) {
                    dis[i] = -1;
                }
            }
            return dis;

        }

        private void dfs(int node, Stack<Integer> stack, List<List<Pairs>> adjList, boolean vis[]) {
            if (vis[node] == true)
                return;
            vis[node] = true;
            for (int i = 0; i < adjList.get(node).size(); i++) {
                if (vis[adjList.get(node).get(i).edge] == false) {
                    dfs(adjList.get(node).get(i).edge, stack, adjList, vis);
                }
            }
            stack.push(node);
        }

    }

    private static class Pairs {
        int dis;
        int edge;

        Pairs(int edge, int dis) {
            this.edge = edge;
            this.dis = dis;
        }
    }
}
// use the topo sorting and dont move out of the stack of toposort from there
// from every top element of stack traverse and visit other nearby.