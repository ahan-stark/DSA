//the problem is to have the surrounded region of x ..where we have to surround the 0 with x such that it is surrounded from all 4 directions..
//use the logic like if any of the x is in edges then they cannot be surrounded and the connected components if its 0 then they also cant be surrounded...rest of the things can be surrounded
public class SurroundedRegions {
    public static void main(String[] args) {
        String[][] board = { { "X", "X", "X", "X" }, { "X", "O", "O", "X" }, { "X", "X", "O", "X" },
                { "X", "O", "X", "X" } };
        Solution solution = new Solution();
        solution.getSurroundedRegions(board);
        for (String[] strings : board) {
            for (String val : strings) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

    private static class Solution {
        private void getSurroundedRegions(String[][] board) {
            int vis[][] = new int[board.length][board[0].length];
            // traverse edges and mark the connecting edges also as visited
            // traversing first row
            for (int i = 0; i < board[0].length; i++) {
                if (board[0][i] == "O")
                    dfs(0, i, board, vis);
            }
            // traversing first column
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == "O")
                    dfs(i, 0, board, vis);
            }
            // traversing last row
            for (int i = 0; i < board[0].length; i++) {
                if (board[board.length - 1][i] == "O")
                    dfs(board.length - 1, i, board, vis);
            }
            // travsering last col
            for (int i = 0; i < board.length; i++) {
                if (board[i][board[0].length - 1] == "O")
                    dfs(i, board[0].length - 1, board, vis);
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == "O" && vis[i][j] == 0)
                        board[i][j] = "X";
                }
            }

        }

        private void dfs(int row, int col, String[][] board, int[][] vis) {
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || vis[row][col] == 1
                    || board[row][col] == "X")
                return;
            int row4dir[] = { -1, 1, 0, 0 };
            int col4dir[] = { 0, 0, -1, 1 };
            vis[row][col] = 1;
            for (int i = 0; i < 4; i++) {
                dfs(row + row4dir[i], col + col4dir[i], board, vis);
            }
        }
    }
}
// to solve this problem lets assume like we are capturing 0 which cannot escape
// on 4 directions that is other 0..so what we do in logic is the edge part of 0
// cannot be captured as it has 4 directions any one is open..so the
// corresponding 4 directions of 0 in edges that also cannot be captured since
// it can escape from connected components so wherever we have edge 0 mark as
// vis and also corresponding 4 dir dfs 0 elements also mark as visited.
// at the end check if the value is 0 and if it is not visited so mark as
// x..since it was not connected component of edge 0's