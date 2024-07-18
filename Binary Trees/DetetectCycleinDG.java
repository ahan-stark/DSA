import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetetectCycleinDG {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1); // A -> B
        graph.get(1).add(2); // B -> C
        graph.get(2).add(3); // C -> D
        graph.get(3).add(1); // D -> B (creates a cycle)
        Solution solution = new Solution();
        boolean isCyclic = solution.findCycle(graph);
        System.out.println("Is the Directed graph acyclic ? : " + isCyclic);
    }

    private static class Solution {
        private boolean findCycle(List<List<Integer>> graph) {
            Queue<Integer> queue = new LinkedList<>();
            int inDegree[] = new int[graph.size()];
            for (int i = 0; i < graph.size(); i++) {
                for (int j = 0; j < graph.get(i).size(); j++) {
                    inDegree[graph.get(i).get(j)]++;
                }
            }
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            List<Integer> topSort = new ArrayList<>();
            while (!queue.isEmpty()) {
                int node = queue.poll();
                topSort.add(node);
                for (int i = 0; i < graph.get(node).size(); i++) {
                    inDegree[graph.get(node).get(i)]--;
                    if (inDegree[graph.get(node).get(i)] == 0) {
                        queue.add(graph.get(node).get(i));
                    }
                }
            }
            return topSort.size() == graph.size();
        }
    }
}
// this is same logic of finding the topo sort using BFS method.. that is kahn's
// algorithm.. to get the topo sort the graph should not be cyclic..because when
// we remove and indegree 0 vertices and add to queue and then remove that
// vertices from graph meanwhile the path from that vertices we cut so that
// other vertices indegree changes ... anyone min 1 will have 0 in degree so
// that we can put that into queue and follow the same pattern again.. but if
// cycle exists the moment we remove any vertices from graph the other will be
// connected to the nearby path so the nearby one cannot have indegree 0 so it
// wont be added to queue .. hence making the queue empty

// so we check the size of graph == toposort.size() if same then all have been
// added and no cycle...else cycle exist