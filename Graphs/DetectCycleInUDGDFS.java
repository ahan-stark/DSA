import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUDGDFS {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);

        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(4);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.get(4).add(1);
        adj.get(4).add(3);

        Solution solution = new Solution();
        boolean checkCycle = solution.findCycle(adj);
        System.out.println("The Graph conatisn cycle? : " + checkCycle);
    }

    private static class Solution {
        private boolean findCycle(List<List<Integer>> adjList) {
            int vertices = adjList.size();
            boolean vis[] = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (vis[i] != true) {
                    if (dfs(adjList, vis, -1, i) == true)
                        return true;
                }
            }
            return false;
        }

        private boolean dfs(List<List<Integer>> adjList, boolean[] vis, int parent, int vertex) {
            vis[vertex] = true;
            for (int i = 0; i < adjList.get(vertex).size(); i++) {
                if (vis[adjList.get(vertex).get(i)] != true) {
                    if (dfs(adjList, vis, vertex, adjList.get(vertex).get(i)) == true)
                        return true;
                } else if (parent != adjList.get(vertex).get(i)) {
                    return true;
                }
            }
            return false;
        }

    }
}
// this is same logic as BFS applied before keep going deep to other node and
// check if it is visited else visit it..while visiting keep a track of parent
// pointer.. 0 - > 1 and 1 -> 2 and 1 -> 0 so if in this case we cannot say 0 is
// looped with 1 as it will be already visited .so we have to keep that as
// parent
// in each node ... then if we reach any node that is already visited and it is
// not the parent node that means someone in recursion call has been visted this
// hence makng it a loop so return true;