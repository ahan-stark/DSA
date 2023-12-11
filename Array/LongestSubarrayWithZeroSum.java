import java.util.HashMap;

public class LongestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int arr[] = { 9, -3, 3, -1, 6, -5 };
        Solution solution = new Solution();
        // Brute Force SOlution
        int bruteSol = solution.bruteForce(arr);
        System.out.println("Brute Force Solution : ");
        System.out.println(bruteSol);
        // Optimal Solution - Hashing
        int optimalSol = solution.optimalSolution(arr);
        System.out.println("Optimal Solution :");
        System.out.println(optimalSol);
    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            int subArrayCount = 0;
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                for (int j = i; j < arr.length; j++) {
                    sum = sum + arr[j];
                    if (sum == 0) {
                        subArrayCount = Math.max(subArrayCount, (j - i) + 1);
                    }
                }
            }
            return subArrayCount;
        }

        private int optimalSolution(int arr[]) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxSubArray = 0;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = sum + arr[i];
                if (sum == 0) {
                    maxSubArray = i + 1;
                } else {
                    if (map.containsKey(sum)) {
                        maxSubArray = Math.max(maxSubArray, i - (map.get(sum)));
                    } else {
                        map.put(sum, i);
                    }
                }
            }
            return maxSubArray;

        }
    }
}
