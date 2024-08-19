// Given an 2D array Jobs of size Nx3, where Jobs[i][0] represents JobID , Jobs[i][1] represents Deadline , Jobs[i][2] represents Profit associated with that job.
// Each Job takes 1 unit of time to complete and only one job can be scheduled at a time.
// The profit associated with a job is earned only if it is completed by its deadline. Find the number of jobs and maximum profit.

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem {
    public static void main(String[] args) {
        int jobs[][] = { { 1, 2, 100 }, { 2, 1, 19 }, { 3, 2, 27 }, { 4, 1, 25 }, { 5, 1, 15 } };
        Solution solution = new Solution();
        int maxProfit = solution.getMaxProfit(jobs);
        System.out.println("Max profit from given sequence : " + maxProfit);
    }

    private static class Solution {
        private int getMaxProfit(int jobs[][]) {
            Arrays.sort(jobs, new Comparator<int[]>() {
                @Override
                public int compare(int a1[], int a2[]) {
                    return a2[2] - a1[2];
                }
            });
            int totalProfit = 0;
            int maxDeadLine = 0;
            for (int[] arr : jobs) {
                maxDeadLine = Math.max(maxDeadLine, arr[1]);
            }
            int deadLineTracker[] = new int[maxDeadLine + 1];
            Arrays.fill(deadLineTracker, -1);
            for (int[] arr : jobs) {
                if (deadLineTracker[arr[1]] == -1) {
                    deadLineTracker[arr[1]] = arr[0];
                    totalProfit = totalProfit + arr[2];
                } else {
                    for (int i = arr[1] - 1; i > 0; i--) {
                        if (deadLineTracker[i] == -1) {
                            deadLineTracker[i] = arr[0];
                            totalProfit = totalProfit + arr[2];
                            break;
                        }
                    }
                }
            }
            return totalProfit;
        }

    }
}
// we sort the 2d array based on profit and we make a deadline array to keep
// track of deadline date...the deadline be from 1 to maxDeadline.. then we
// take the profit that is in max sorted and assign it to that deadline day.. if
// we have next profit for already occupied deadline.. try it by assigning to
// prev deadline dates.