import java.util.LinkedList;
import java.util.Queue;

// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

public class RottingOranges {
    public static void main(String[] args) {
        int grid[][] = { { 2, 1, 1, }, { 1, 1, 0 }, { 0, 1, 1 } };
        Solution solution = new Solution();
        int time = solution.orangesRotting(grid);
        System.out.println("The total time taken to rotten the oranges is  : " + time);

    }

    private static class Solution {
        public int orangesRotting(int[][] grid) {
            int rowLen = grid.length;
            int colLen = grid[0].length;
            int time = 0;
            int vis[][] = new int[rowLen][colLen];
            Queue<Pair> queue = new LinkedList<>();
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new Pair(i, j));
                        vis[i][j] = 2;
                    } else if (grid[i][j] == 1) {
                        vis[i][j] = 1;
                    }
                }
            }
            int row4dir[] = { -1, 1, 0, 0 };
            int col4dir[] = { 0, 0, -1, 1 };
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean elemAdded = false;
                for (int i = 0; i < size; i++) {
                    Pair pair = queue.poll();
                    int row = pair.row;
                    int col = pair.col;
                    for (int count = 0; count < 4; count++) {
                        int newRow = row + row4dir[count];
                        int newCol = col + col4dir[count];
                        if (newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen &&
                                grid[newRow][newCol] == 1 && vis[newRow][newCol] != 2) {
                            queue.add(new Pair(newRow, newCol));
                            vis[newRow][newCol] = 2;
                            elemAdded = true;
                        }
                    }
                }

                if (elemAdded == true)
                    time++;
            }
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    if (grid[i][j] == 1 && vis[i][j] != 2)
                        return -1;
                }
            }
            return time;

        }
    }

    private static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

}
// In this our task is to rotten the fresh oranges, so what we do is BFS and at
// first we assign the rotten ones to queue initially that is already rotten so
// time is 0, so for each of the time BFS is completed all the other oranges if
// it is fresh with that traversal is simultaneously rotten so we take time =
// time + 1, we havse to check left right bottom top of that rotten .. so to do
// that we will have rowArr and colArr such that col will stand there and row
// will move left and right and row will be there only and col will move up and
// down..so maintain row4Dir and col4Dir as [-1,1,0,0] and [0,0,-1,1]...In case
// we have already one at start the rotten initially added and others cannot be
// rotten later so we should not add extra time for that as it is not rotten
// others..so we have to maintain a flag and only if the particular BFS
// traversel rottens other oranges update the flag only if flag is changed then
// increase the timer

// all the rotting should be done in vis[][]..we shouldnt touch the original
// grid