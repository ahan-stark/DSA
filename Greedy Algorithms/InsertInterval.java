//given intervals is in proper format

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        Solution solution = new Solution();
        int[][] resInterval = solution.getIntervals(intervals, newInterval);
        for (int[] inter : resInterval) {
            System.out.println(inter[0] + " : " + inter[1]);
        }
    }

    private static class Solution {
        private int[][] getIntervals(int[][] intervals, int[] newInterval) {
            List<List<Integer>> list = new ArrayList<>();
            int i = 0;
            while (i < intervals.length && newInterval[0] > intervals[i][1]) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(intervals[i][0]);
                tempList.add(intervals[i][1]);
                list.add(tempList);
                i++;
            }

            while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            list.add(Arrays.asList(newInterval[0], newInterval[1]));
            while (i < intervals.length) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(intervals[i][0]);
                tempList.add(intervals[i][1]);
                list.add(tempList);
                i++;
            }
            int[][] ans = new int[list.size()][2];
            for (int j = 0; j < list.size(); j++) {
                ans[j][0] = list.get(j).get(0);
                ans[j][1] = list.get(j).get(1);
            }
            return ans;
        }

    }
}
// First, keep moving left until the start of the newInterval is less than the
// end of the current interval; this will define the left part. Then, continue
// moving through the intervals where newInterval and the current interval
// overlap. For these overlapping intervals, find the minimum of the starting
// points and the maximum of the ending points to merge them into a single
// interval. Finally, add the remaining intervals to the list.
