import java.util.ArrayList;
import java.util.List;

public class AncestorsofNodeInDAG {
    public static void main(String[] args) {
        int edges[][] = { { 0, 3 }, { 0, 4 }, { 1, 3 }, { 2, 4 }, { 2, 7 }, { 3, 5 }, { 3, 6 }, { 3, 7 }, { 4, 6 } };
        int n = 8;
        Solution solution = new Solution();
        List<List<Integer>> resultList = solution.getAncList(n, edges);
        System.out.println(resultList);

    }

    private static class Solution {
        private List<List<Integer>> getAncList(int n, int[][] edges) {
            List<List<Integer>> result = new ArrayList<>();
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
                result.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjList.get(edge[1]).add(edge[0]);
            }
            for (int i = 0; i < n; i++) {
                boolean vis[] = new boolean[n];
                dfs(i, adjList, vis);
                for (int j = 0; j < n; j++) {
                    if (vis[j] == true && i != j) {
                        result.get(i).add(j);
                    }
                }
            }
            return result;
        }

        private void dfs(int node, List<List<Integer>> adjList, boolean vis[]) {
            if (vis[node] == true)
                return;
            vis[node] = true;
            for (int i = 0; i < adjList.get(node).size(); i++) {
                dfs(adjList.get(node).get(i), adjList, vis);
            }
        }

    }
}
// given data of edges create a reverse graph and start visiting from last.. so
// that you can get proper ancestor by visiting in dfs way.. and to get in order
// each node we create anew vis array and for that particular we check which all
// are visited and then according create a subList and add it to resultList;
