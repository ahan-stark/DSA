//find the min removal to get the non overlapping interval
//same as n meetings problem

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 1, 4 }, { 3, 5 }, { 3, 4 }, { 4, 5 } };
        Solution solution = new Solution();
        int minRemoval = solution.getMinRemoval(intervals);
        System.out.println("Min removal required to have non overlapping : " + minRemoval);
    }

    private static class Solution {
        private int getMinRemoval(int[][] interval) {
            Arrays.sort(interval, new Comparator<int[]>() {
                @Override
                public int compare(int a1[], int a2[]) {
                    return a1[1] - a2[1];
                }
            });
            int count = 0;
            int lastEnd = Integer.MIN_VALUE;
            for (int[] eachInterval : interval) {
                if (eachInterval[0] >= lastEnd) {
                    count++;
                    lastEnd = eachInterval[1];
                }
            }
            return interval.length - count;
        }

    }
}
//here at first sort based on end value.. then count total non overlapping intervals
//we have to remove the overlapping intervals ... so total length of intervals - count
//same as n meetings and chain problem