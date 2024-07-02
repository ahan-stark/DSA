import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
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
        List<Integer> bfs = solution.getBFS(5, adj);
        for (Integer elem : bfs) {
            System.out.println(elem);
        }
    }

    private static class Solution {
        private List<Integer> getBFS(int vertices, List<List<Integer>> adjList) {
            List<Integer> list = new ArrayList<>();
            boolean vis[] = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            vis[0] = true;
            while (!queue.isEmpty()) {
                int val = queue.poll();
                list.add(val);
                for (int i = 0; i < adjList.get(val).size(); i++) {
                    if (vis[adjList.get(val).get(i)] != true && !list.contains(adjList.get(val).get(i))) {
                        queue.add(adjList.get(val).get(i));
                        vis[adjList.get(val).get(i)] = true;
                    }
                }
            }
            return list;
        }

    }

}
