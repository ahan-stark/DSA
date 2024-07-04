// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

public class NumberOfIslands {
    public static void main(String[] args) {
        int grid[][] = { { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1 } };
        // op - 3
        // 0->1,1 1->1,1 can be one island 2 -> 1 island 3 ->1,1 island
        Solution solution = new Solution();
        int totalIsland = solution.getTotalIsland(grid);
        System.out.println(totalIsland);
    }

    private static class Solution {
        private int getTotalIsland(int grid[][]) {
            boolean vis[][] = new boolean[grid.length][grid[0].length];
            int row = grid.length, col = grid[0].length;
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1 && vis[i][j] == false) {
                        dfs(i, j, grid, vis);
                        count = count + 1;
                    }
                }
            }
            return count;
        }

        private void dfs(int row, int col, int[][] grid, boolean[][] vis) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || vis[row][col] == true
                    || grid[row][col] == 0)
                return;
            vis[row][col] = true;
            dfs(row, col - 1, grid, vis);
            dfs(row, col + 1, grid, vis);
            dfs(row - 1, col, grid, vis);
            dfs(row + 1, col, grid, vis);
        }

    }
}

// not completley the graph problem but similar... so we search for the starting
// point.. and if it was not visited.. consider it as 1 island...call dfs the
// will check for current node left right up and bottom in recursion way such
// that there will be always a connected component.. the left and right side of
// the cur node can be gone through col - 1 and col + 1 and top and bottom of
// the current node can be gone through row + 1 and row - 1 .. we have to care
// of edges cases of row going beyond or less and also col going beyond or less
// and if that node is 0 or else if it is visited already then return in
// recursion.