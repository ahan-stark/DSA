// Problem Statement: You are given an array 'stalls'  which denotes the position of stalls.
// You are also given an integer ‘cows’ which denotes the number of aggressive cows.
// You are given the task of assigning stalls to ‘cows’  such that the minimum distance between any two of them is the maximum possible.
// Find the maximum possible minimum distance.

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int stalls[] = { 0, 3, 4, 7, 10, 9 };
        int cows = 4;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(stalls, cows);
        System.out.println("Brute Force : " + bruteForce);
        int binarySearch = solution.binarySearch(stalls, cows);
        System.out.println("Binary search : " + binarySearch);
    }

    private static class Solution {
        private int bruteForce(int stalls[], int cows) {
            Arrays.sort(stalls);
            int max = (stalls[stalls.length - 1]);
            for (int i = 1; i <= max; i++) {
                // i represents the max possible distance between the cows
                if (canWePlaceCows(stalls, i, cows) == false)
                    return i - 1;
            }
            return stalls[stalls.length - 1];
        }

        private int binarySearch(int stalls[], int cows) {
            Arrays.sort(stalls);
            int low = 0;
            int high = stalls.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                // if we get a solution in mid we know that before that elem will always be less
                // so move to find max move right side
                if (canWePlaceCows(stalls, mid, cows) == true) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return high;
        }

        private boolean canWePlaceCows(int[] stalls, int distance, int cows) {
            // assign cow 1 directly to stall 0 and then go on
            int cowCount = 1;
            // note down the last placed stall to measure the distance between them
            int lastPos = stalls[0];
            for (int i = 1; i < stalls.length; i++) {
                if (stalls[i] - lastPos >= distance) {
                    cowCount++;
                    lastPos = stalls[i];
                }
                if (cowCount >= cows)
                    return true;
            }
            return false;
        }

    }
}
