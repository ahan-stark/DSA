import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dest = 3;
        int k = 1;
        Solution solution = new Solution();
        int cheapFlights = solution.getCheapestFlight(n, flights, src, dest, k);
        System.out.println("Cheapest travel to dest : " + cheapFlights);
    }

    private static class Solution {
        private int getCheapestFlight(int n, int[][] flights, int src, int dst, int k) {
            List<List<AdjPairs>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < flights.length; i++) {
                adjList.get(flights[i][0]).add(new AdjPairs(flights[i][1], flights[i][2]));
            }
            int[] dis = new int[n];
            Queue<Pairs> q = new LinkedList<>();
            Arrays.fill(dis, Integer.MAX_VALUE);
            dis[src] = 0;
            q.offer(new Pairs(0, 0, src));
            while (!q.isEmpty()) {
                Pairs p = q.poll();
                int curStop = p.stops;
                int curDis = p.dis;
                int vertices = p.vertices;
                if (curStop <= k) {
                    for (int i = 0; i < adjList.get(vertices).size(); i++) {
                        AdjPairs adjPairs = adjList.get(vertices).get(i);
                        int edgeVertices = adjPairs.edge;
                        int edgeWeight = adjPairs.weight;
                        if (edgeWeight + curDis < dis[edgeVertices]) {
                            dis[edgeVertices] = edgeWeight + curDis;
                            q.offer(new Pairs(curStop + 1, edgeWeight + curDis, edgeVertices));
                        }
                    }
                }
            }
            if (dis[dst] == Integer.MAX_VALUE)
                return -1;
            return dis[dst];
        }
    }

    private static class AdjPairs {
        int edge;
        int weight;

        public AdjPairs(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }

    private static class Pairs {
        int stops;
        int dis;
        int vertices;

        public Pairs(int stops, int dis, int vertices) {
            this.stops = stops;
            this.dis = dis;
            this.vertices = vertices;
        }
    }
}
// we can have max of k stops so after k stop we can reach destination so only
// apply the logic of dijkstras algo untill the stops <= k