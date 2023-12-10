public class MaximumSubArraySum {
    private static int[] arr = { 1, -2, -3, 2, 6, 4, 1 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int bruteForceSol = solution.bruteForce(arr);
        System.out.println(bruteForceSol);
        // Better Approach
        int betterSol = solution.betterSolution(arr);
        System.out.println(betterSol);
        // Optimal Approach
        int optimalApproach = solution.optimalApproach(arr);
        System.out.println(optimalApproach);
    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            int max = 0;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum += arr[k];
                    }
                    max = Math.max(max, sum);
                }
            }
            return max;
        }

        private int betterSolution(int[] arr) {
            int max = 0;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    sum += arr[j];
                }
                max = Math.max(max, sum);
            }
            return max;
        }

        // Kadne's Algorithm
        private int optimalApproach(int arr[]) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int val : arr) {
                sum += val;
                max = Math.max(sum, max);
                if (sum < 0)
                    sum = 0;
            }
            return sum;
        }
    }
}
