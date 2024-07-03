import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        // each List inside the list represents the edges connected to it.. the index is
        // main vertices
        Solution solution = new Solution();
        List<Integer> dfs = solution.getBST(adj);
        for (Integer val : dfs) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private List<Integer> getBST(List<List<Integer>> adjList) {
            int vertices = adjList.size();
            List<Integer> list = new ArrayList<>();
            boolean vis[] = new boolean[vertices];
            findDepth(0, list, vis, adjList);
            return list;
        }

        private void findDepth(int vertices, List<Integer> list, boolean[] vis, List<List<Integer>> adjList) {
            list.add(vertices);
            vis[vertices] = true;
            for (int i = 0; i < adjList.get(vertices).size(); i++) {
                if (vis[adjList.get(vertices).get(i)] == false)
                    findDepth(adjList.get(vertices).get(i), list, vis, adjList);
            }

        }
    }
}
