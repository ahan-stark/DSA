import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUDGBFS {
    public static void main(String[] args) {
        int adjList[][] = { { 1 }, { 0, 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };
        Solution solution = new Solution();
        boolean loop = solution.checkCycle(adjList);
        System.out.println("Loop detected ? : " + loop);
    }

    private static class Solution {
        private boolean checkCycle(int adjList[][]) {
            int vertices = adjList.length;
            boolean vis[] = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (vis[i] != true) {
                    if (detectCycles(adjList, i, vis) == true)
                        return true;
                }
            }
            return false;
        }

        private boolean detectCycles(int adjList[][], int vertex, boolean vis[]) {
            Queue<Pair> queue = new LinkedList<>();
            vis[vertex] = true;
            queue.add(new Pair(vertex, -1));
            while (!queue.isEmpty()) {
                int size = queue.size();
                // traversing the level wise
                for (int i = 0; i < size; i++) {
                    Pair pair = queue.remove();
                    int node = pair.node;
                    int parent = pair.parent;
                    for (int neigbhour : adjList[node]) {
                        if (vis[neigbhour] != true) {
                            vis[neigbhour] = true;
                            queue.add(new Pair(neigbhour, node));
                        } else if (parent != neigbhour) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    private static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}

// we are given nodes with adjList as 2d array... we have to detect whether the
// given graphs has cycle.. we need to store the parent of each node becuase our
// logic if we start traversing a graph and a particular node is already visited
// by other node in BFS before we reach through cur node that means we have a
// cycle..we need parent because 0 -> 1 and 1 -> 2 and 1 -> 0 as well.. so in
// second thing 0 will be already visted but it is the parent of 1 so we need to
// say it is not cycle because it was visited previously..

// if we reach a particular node and that is already visited and that is not
// parent of cur node than it means we have a loop or cycle ...meaning in same
// queue in BFS it was visted before, making it a cycle loop
// we use for loop in main function is that becuase we might have graphs which
// may not been connected it might be starting of new node component