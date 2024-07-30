import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    public static void main(String[] args) {
        int heights[][] = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        Solution solution = new Solution();
        int minEffort = solution.getMinEffort(heights);
        System.out.println("Min effort from first grid to last grid : " + minEffort);

    }

    private static class Solution {
        private int getMinEffort(int heights[][]) {
            PriorityQueue<Pairs> pq = new PriorityQueue<>(new Comparator<Pairs>() {
                @Override
                public int compare(Pairs a, Pairs b) {
                    return a.diff - b.diff;
                }
            });
            int dis[][] = new int[heights.length][heights[0].length];
            for (int i = 0; i < dis.length; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE);
            }
            int rowMov[] = { -1, 1, 0, 0 };
            int colMov[] = { 0, 0, 1, -1 };
            // insert src
            pq.offer(new Pairs(0, 0, 0));
            while (!pq.isEmpty()) {
                Pairs pair = pq.poll();
                int curDiff = pair.diff;
                int curRow = pair.row;
                int curCol = pair.col;
                if (curRow == heights.length - 1 && curCol == heights[0].length - 1) {
                    return curDiff;
                }
                for (int i = 0; i < 4; i++) {
                    int newRow = curRow + rowMov[i];
                    int newCol = curCol + colMov[i];
                    if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length) {
                        int absDiff = Math.abs(heights[curRow][curCol] - heights[newRow][newCol]);
                        int newDiff = Math.max(curDiff, absDiff);
                        if (dis[newRow][newCol] > newDiff) {
                            dis[newRow][newCol] = newDiff;
                            pq.offer(new Pairs(newDiff, newRow, newCol));
                        }
                    }
                }
            }
            return -1;
        }
    }

    private static class Pairs {
        int diff;
        int row;
        int col;

        public Pairs(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }

    }
}
// since we are using priority queue we will be getting the min diff only in
// ascending order, so if we get the destination row col from the priority queue
// that means we are checking the dest row and col with curDiff in ascending
// order so return that curDiff of dest which we get at first