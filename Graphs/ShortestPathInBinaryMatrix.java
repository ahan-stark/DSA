import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int grid[][] = { { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 } };
        int[] source = { 0, 1 };
        int[] destination = { 2, 2 };
        Solution solution = new Solution();
        int shortestPath = solution.getShortestPath(grid, source, destination);
        System.out.println("The shortest path in binary maze is : " + shortestPath);
    }

    private static class Solution {
        private int getShortestPath(int grid[][], int src[], int des[]) {
            int dis[][] = new int[grid.length][grid[0].length];
            PriorityQueue<Pairs> pq = new PriorityQueue<>(new Comparator<Pairs>() {
                @Override
                public int compare(Pairs a, Pairs b) {
                    return a.dis - b.dis;
                }
            });
            int rowMov[] = { -1, 1, 0, 0 };
            int colMov[] = { 0, 0, -1, 1, };
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
            dis[src[0]][src[1]] = 0;
            pq.offer(new Pairs(0, src[0], src[1]));
            while (!pq.isEmpty()) {
                Pairs curPair = pq.poll();
                int curDis = curPair.dis;
                int curRow = curPair.row;
                int curCol = curPair.col;
                if (des[0] == curRow && des[1] == curCol)
                    return curDis;
                for (int i = 0; i < 4; i++) {
                    int newRow = curRow + rowMov[i];
                    int newCol = curCol + colMov[i];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                            && grid[newRow][newCol] != 0) {
                        if (curDis + 1 < dis[newRow][newCol]) {
                            dis[newRow][newCol] = curDis + 1;
                            pq.offer(new Pairs(dis[newRow][newCol], newRow, newCol));
                        }
                    }
                }

            }
            return -1;
        }

        private static class Pairs {
            int dis;
            int row;
            int col;

            public Pairs(int dis, int row, int col) {
                this.dis = dis;
                this.row = row;
                this.col = col;
            }
        }
    }
}
// use djisktra's algorithm