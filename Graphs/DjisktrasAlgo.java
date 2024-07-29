import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DjisktrasAlgo {
    public static void main(String[] args) {
        int n = 5;
        int src = 1;
        int des = 5;
        int edges[][] = { { 1, 2, 2 }, { 2, 5, 5, }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
        List<List<Pairs>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new Pairs(edges[i][1], edges[i][2]));
        }
        Solution solution = new Solution();
        List<Integer> getShortPath = solution.getShortestPath(src, adjList, des);
        for (Integer val : getShortPath) {
            System.out.print(val + " <- ");
        }

    }

    private static class Solution {
        private List<Integer> getShortestPath(int src, List<List<Pairs>> adjList, int des) {
            // since the edges are being started from 1 so we have to consider till n + 1
            PriorityQueue<Pairs> pq = new PriorityQueue<>(new Comparator<Pairs>() {
                @Override
                public int compare(Pairs a, Pairs b) {
                    return Integer.compare(a.dis, b.dis);
                }
            });
            int parent[] = new int[adjList.size()];
            int dist[] = new int[adjList.size()];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(parent, -1);
            parent[src] = src;
            dist[src] = 0;
            pq.offer(new Pairs(src, 0));
            while (!pq.isEmpty()) {
                Pairs curPair = pq.poll();
                int curNode = curPair.node;
                int curNodeDis = curPair.dis;
                for (int i = 0; i < adjList.get(curNode).size(); i++) {
                    Pairs nextPair = adjList.get(curNode).get(i);
                    if (curNodeDis + nextPair.dis < dist[nextPair.node]) {
                        dist[nextPair.node] = curNodeDis + nextPair.dis;
                        parent[nextPair.node] = curNode;
                        pq.offer(new Pairs(nextPair.node, dist[nextPair.node]));
                    }
                }
            }
            List<Integer> path = new ArrayList<>();
            int tempNode = des;
            path.add(des);
            while (parent[tempNode] != tempNode) {
                path.add(parent[tempNode]);
                tempNode = parent[tempNode];
            }
            return path;
        }

    }

    private static class Pairs {
        int node;
        int dis;

        public Pairs(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }

    }
}
// Djisktra's algo is used to get shortest path using priority queue based on
// dis in ascending order and dynamically keep track of node's parent such that
// we will get full route to the des

// 9 - > 5 - > 3

// 3 will have parent 5 and in same manner 5 will have parent 9... this way we
// will retrive the full path.
