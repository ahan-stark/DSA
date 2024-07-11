public class BipartiteGraph {
    public static void main(String[] args) {
        int graph[][] = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        Solution solution = new Solution();
        boolean isBipartite = solution.checkBipartite(graph);
        System.out.println(isBipartite);
    }

    private static class Solution {
        private boolean checkBipartite(int graph[][]) {
            int visColor[] = new int[graph.length];
            for (int i = 0; i < visColor.length; i++) {
                visColor[i] = -1;
            }
            for (int i = 0; i < graph.length; i++) {
                if (visColor[i] == -1) {
                    if (dfs(i, 0, visColor, graph) == false)
                        return false;
                }
            }
            return true;
        }

        private boolean dfs(int node, int color, int[] visColor, int[][] graph) {
            visColor[node] = color;
            for (int i = 0; i < graph[node].length; i++) {
                if (visColor[graph[node][i]] == -1) {
                    if (dfs(graph[node][i], getOppositeCol(color), visColor, graph) == false)
                        return false;
                } else {
                    if (visColor[graph[node][i]] == color)
                        return false;
                }
            }
            return true;
        }

        private int getOppositeCol(int color) {
            return color == 0 ? 1 : 0;
        }
    }

}

// Bipartite graph means in the DFS wasy every alternate nodes should have
// opposite color..if first node has blue then other should have red..third
// should be blue ..4th will red...same goes with the cyclic graph also it
// should be alternate colors..if edges are of same color then its not a
// bipartite graph.. in this we assign first node as color 0 and do dfs for that
// for each edge node of that particular node we will assign the opposite
// color..and also we check if its not visited and if not visited then we assign
// them with color 0 or 1 respectively...at the begining put all the vertices
// with -1..then assign the color only if its not visited ..that is not colored