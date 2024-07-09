import java.util.LinkedList;
import java.util.Queue;

// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

// Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        Solution solution = new Solution();
        int totalEnclaves = solution.getTotalEnclaves(grid);
        System.out.println(totalEnclaves);
    }

    private static class Solution {
        private int getTotalEnclaves(int[][] grid) {
            int len = 0;
            boolean[][] vis = new boolean[grid.length][grid[0].length];
            Queue<Pairs> queue = new LinkedList<>();
            // traverse edges and mark the connecting edges also as visited
            // traversing first row
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[0][i] == 1) {
                    vis[0][i] = true;
                    queue.add(new Pairs(0, i));
                }
            }
            // traversing first column
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][0] == 1) {
                    vis[i][0] = true;
                    queue.add(new Pairs(i, 0));
                }
            }
            // traversing last row
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[grid.length - 1][i] == 1) {
                    vis[grid.length - 1][i] = true;
                    queue.add(new Pairs(grid.length - 1, i));
                }
            }
            // travsering last col
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][grid[0].length - 1] == 1) {
                    vis[i][grid[0].length - 1] = true;
                    queue.add(new Pairs(i, grid[0].length - 1));
                }
            }
            int row4dir[] = { -1, 1, 0, 0 };
            int col4dir[] = { 0, 0, -1, 1, };
            while (!queue.isEmpty()) {
                Pairs pairs = queue.poll();
                int row = pairs.row;
                int col = pairs.col;
                for (int i = 0; i < 4; i++) {
                    int newRow = row + row4dir[i];
                    int newCol = col + col4dir[i];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                            && grid[newRow][newCol] == 1 && vis[newRow][newCol] == false) {
                        vis[newRow][newCol] = true;
                        queue.add(new Pairs(newRow, newCol));
                    }
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && vis[i][j] == false)
                        len = len + 1;
                }
            }
            return len;
        }

    }

    static class Pairs {
        int row, col;

        public Pairs(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }
}
// this is similar problem as Surrounded regions... we have to check how many
// enclaves are there.Enclaves means 1 which are surrounded by 0 and there is no
// way out for it ...so the logic is take th edge 1 and do either dfs or bfs all
// 4 directions if its 1 and unvisted ..at the end check all the 1 in grid and
// check if it is not visited then say len = len + 1...every time you do dfs or
// bfs make sure we change the vis[row][col] = true;
