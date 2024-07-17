import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortBFS {
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
        ArrayList<Integer> list = solution.getTopo(adj);
        for (Integer val : list) {
            System.out.println(val);
        }
    }

    private static class Solution {
        private ArrayList<Integer> getTopo(ArrayList<ArrayList<Integer>> adjList) {
            int vertices = adjList.size();
            Queue<Integer> queue = new LinkedList<>();
            int inDegree[] = new int[vertices];
            ArrayList<Integer> topoList = new ArrayList<>();
            for (ArrayList<Integer> vertex : adjList) {
                for (int ele : vertex) {
                    inDegree[ele]++;
                }
            }
            // add indegree 0 vertex to queue
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int i = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                topoList.add(i++, node);
                for (int j = 0; j < adjList.get(node).size(); j++) {
                    inDegree[adjList.get(node).get(j)]--;
                    if (inDegree[adjList.get(node).get(j)] == 0) {
                        queue.add(adjList.get(node).get(j));
                    }
                }
            }
            return topoList;

        }
    }
}
// put it into queue whos indegree is 0 then take the elements from queue ...
// remove that node from graph so if we are removing it from graph wherever it
// is going to other node it will be reduced by 1 that is indegree of edge node
// since it is getting removed..while reducing the indegree of corresponding
// edge check the edge vertex becomes indegree 0 if yes add it to queue.