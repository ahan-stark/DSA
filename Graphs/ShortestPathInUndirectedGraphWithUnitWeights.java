import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraphWithUnitWeights {
    public static void main(String[] args) {
        int graph[][] = { { 1, 3 }, { 0, 2, 3 }, { 1, 6 }, { 0, 4 }, { 3, 5 }, { 4, 6 }, { 2, 5, 7, 8 }, { 6, 8 },
                { 6, 7 } };
        int src = 0;
        int des = 5;
        Solution solution = new Solution();
        int shortestDis = solution.getShortestPath(graph, src, des);
        System.out.println(shortestDis);

    }

    private static class Solution {
        private int getShortestPath(int graph[][], int src, int des) {
            int n = graph.length;
            Queue<Integer> queue = new LinkedList<>();
            int dis[] = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dis[src] = 0;
            queue.offer(src);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int i = 0; i < graph[node].length; i++) {
                    if (dis[node] + 1 < dis[graph[node][i]]) {
                        dis[graph[node][i]] = dis[node] + 1;
                        queue.offer(graph[node][i]);
                    }

                }
            }
            return dis[des];
        }
    }
}
