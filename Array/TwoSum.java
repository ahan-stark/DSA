import java.util.*;

public class TwoSum {
    private static int arr[] = new int[] { 1, 4, 3, 5, 7, 8 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 11;
        // Brute Force
        boolean bruteSol = solution.bruteForce(arr, k);
        System.out.println("The array contains the sum  " + k + " " + bruteSol);
        // Better Approach
        boolean betterSol = solution.betterApproach(arr, k);
        System.out.println("The array contains the sum  " + k + " " + betterSol);

    }

    private static class Solution {
        private boolean bruteForce(int arr[], int k) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] + arr[j] == k) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean betterApproach(int arr[], int k) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (hashMap.containsKey(k - arr[i])) {
                    return true;
                }
                hashMap.put(arr[i], i);
            }
            return false;
        }
    }
}
