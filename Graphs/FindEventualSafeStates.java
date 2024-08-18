import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int graph[][] = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        Solution solution = new Solution();
        List<Integer> ans = solution.getSafeStates(graph);
        for (Integer val : ans) {
            System.out.println(val);
        }
    }

    private static class Solution {
        private List<Integer> getSafeStates(int adj[][]) {
            List<Integer> ans = new ArrayList<>();
            int n = adj.length;
            int state[] = new int[n];
            for (int i = 0; i < n; i++) {
                boolean checkSafeState = dfs(i, adj, state);
                if (checkSafeState == true) {
                    ans.add(i);
                }
            }
            return ans;

        }

        private boolean dfs(int vertices, int adj[][], int state[]) {
            if (state[vertices] != 0) {
                if (state[vertices] == 2)
                    return true;
                else
                    return false;
            }
            state[vertices] = 1;
            for (int neighbor : adj[vertices]) {
                if (dfs(neighbor, adj, state) == false) {
                    return false;
                }
            }
            state[vertices] = 2;
            return true;
        }

    }
}
// maintain global states 0 - > not visited, 1 -> visited, 2 -> safeState
// if the node is visited and not in safe state.. that means all the connected
// ones are also not safe state..
// if its going cycle also.. not possible