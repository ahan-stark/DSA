import java.util.Arrays;
import java.util.Comparator;

// You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

// A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

// Return the length longest chain which can be formed.

// You do not need to use up all the given intervals. You can select pairs in any order.

public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        int pairs[][] = { { 1, 2 }, { 7, 8 }, { 4, 5 } };
        Solution solution = new Solution();
        int maxChain = solution.findLongestChain(pairs);
        System.out.println("Longest possible char pairs is : " + maxChain);
    }

    private static class Solution {
        private int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, new Comparator<int[]>() {
                @Override
                public int compare(int a1[], int a2[]) {
                    return a1[1] - a2[1];
                }
            });
            int count = 0;
            int lastEnd = Integer.MIN_VALUE;
            for (int[] arr : pairs) {
                if (arr[0] > lastEnd) {
                    count++;
                    lastEnd = arr[1];
                }
            }
            return count;
        }

    }
}

// same as N meeting room problem

// We use a greedy approach by first sorting the array based on the ending value
// of each chain. After sorting, we start by selecting the first pair. We then
// check if the end of this selected pair is less than the start of the next
// pair in the sorted list. If this condition is met, we include the new pair in
// our chain, increment the count, and update the lastEnded value to the end of
// the current pair. We continue this process for all pairs in the array,
// ensuring that we always select the maximum number of non-overlapping pairs
// possible.