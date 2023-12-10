import java.util.HashMap;

public class NumberOfSubArraysOfK {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, -3, 1, 1, 1, 4, 2 - 3 };
        int k = 3;
        Solution solution = new Solution();
        // Brute Force
        int bruteSol = solution.bruteForce(arr, k);
        System.out.println(bruteSol);
        // Better approach
        int betterSol = solution.betterApproach(arr, k);
        System.out.println(betterSol);
        // optimal Approach
        int optimalSol = solution.optimal(arr, k);
        System.out.println(optimalSol);

    }

    private static class Solution {
        private int bruteForce(int arr[], int k) {
            int count = 0;
            int sum;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    sum = 0;
                    for (int m = i; m <= j; m++) {
                        sum = sum + arr[m];
                    }
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }

        private int betterApproach(int arr[], int k) {
            int sum, count = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = 0;
                for (int j = i; j < arr.length; j++) {
                    sum = sum + arr[j];
                    if (sum == k)
                        count++;
                }
            }
            return count;
        }

        private int optimal(int arr[], int k) {
            int count = 0, sum = 0;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0, 1);
            for (int val : arr) {
                sum = sum + val;
                if (hashMap.containsKey(sum - k)) {
                    count = count + hashMap.get(sum - k);
                }
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
