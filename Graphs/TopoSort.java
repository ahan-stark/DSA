import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSort {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        Solution solution = new Solution();
        List<Integer> list = solution.getTopo(adj);
        for (Integer val : list) {
            System.out.println(val);
        }

    }

    private static class Solution {
        Stack<Integer> stack = new Stack<>();

        private List<Integer> getTopo(ArrayList<ArrayList<Integer>> adj) {
            List<Integer> list = new ArrayList<>();
            int vertices = adj.size();
            boolean vis[] = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (vis[i] != true) {
                    dfs(i, adj, vis);
                }
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            return list;
        }

        private void dfs(int vertex, ArrayList<ArrayList<Integer>> adjList, boolean[] vis) {
            vis[vertex] = true;
            for (int i = 0; i < adjList.get(vertex).size(); i++) {
                if (vis[adjList.get(vertex).get(i)] != true)
                    dfs(adjList.get(vertex).get(i), adjList, vis);
            }
            stack.push(vertex);
        }

    }
}
