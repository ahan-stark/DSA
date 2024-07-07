import java.util.LinkedList;
import java.util.Queue;

//Find the nearest 0 for the 1 in matrix
// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.

public class Matrix01 {
    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        Solution solution = new Solution();
        int[][] res = solution.getResultBFS(grid);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static class Solution {
        private int[][] getResultBFS(int[][] grid) {
            Queue<Pairs> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = Integer.MAX_VALUE;
                    }
                    // if its 0 add to queue
                    else {
                        queue.add(new Pairs(i, j));
                    }
                }
            }
            int[] row4dir = { -1, 1, 0, 0 };
            int[] col4dir = { 0, 0, -1, 1 };
            while (!queue.isEmpty()) {
                Pairs pair = queue.poll();
                int row = pair.row;
                int col = pair.col;
                for (int i = 0; i < 4; i++) {
                    int newRowIndex = row + row4dir[i];
                    int newColIndex = col + col4dir[i];
                    if (newRowIndex >= 0 && newRowIndex < grid.length && newColIndex >= 0
                            && newColIndex < grid[0].length && grid[newRowIndex][newColIndex] == Integer.MAX_VALUE) {
                        grid[newRowIndex][newColIndex] = grid[row][col] + 1;
                        queue.add(new Pairs(newRowIndex, newColIndex));
                    }
                }
            }

            return grid;
        }
    }

    private static class Pairs {
        int row;
        int col;

        public Pairs(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
// Our approach will be to determine the nearest zero values for each one in a
// matrix. First, we will iterate through the matrix. Whenever we encounter a
// one, we will change it to Integer.MAX_VALUE. If we encounter a zero, we will
// add its row and column indices to a queue.

// Next, we will process each element from the queue and check its four
// neighboring directions. If any neighboring cell contains Integer.MAX_VALUE,
// we will update that cell with the value of the current cell plus one. After
// updating, we will push this cell into the queue to process its neighbors in
// subsequent iterations. This process ensures that the matrix is updated
// directly. We can also use a vis[][] array to keep track of visited cells and
// return the updated matrix accordingly.