import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphRepresentationUDG {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdges(1, 2);
        graph.addEdges(1, 3);
        graph.addEdges(2, 4);
        graph.addEdges(3, 4);
        System.out.println("adjesct vertices of " + 3 + " is " + graph.getAdjVertices(3));
        graph.printGraph();

    }

    private static class Graph {
        Map<Integer, ArrayList<Integer>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }

        private void addVertex(int vertex) {
            adjList.putIfAbsent(vertex, new ArrayList<>());
        }

        private void addEdges(int source, int destination) {
            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.putIfAbsent(destination, new ArrayList<>());
            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }

        private List<Integer> getAdjVertices(int vertices) {
            return adjList.get(vertices);
        }

        private void printGraph() {
            for (Map.Entry<Integer, ArrayList<Integer>> map : adjList.entrySet()) {
                System.out.println("vertices " + map.getKey() + " edges " + map.getValue());
            }
        }

    }

}