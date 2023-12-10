import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    private static int arr[] = { 1, 3, 4, 4, 4, 5, 6, 4, 4 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int bruteForceElem = solution.bruteForce(arr);
        System.out.println(bruteForceElem);
        // Better Approach
        int betterApproElem = solution.betterApproach(arr);
        System.out.println(betterApproElem);
        // Optimal Approach
        int optimalElem = solution.optimalApproach(arr);
        System.out.println(optimalElem);
    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            for (int i : arr) {
                int count = 0;
                for (int j : arr) {
                    if (i == j) {
                        count++;
                    }
                }
                if (count > arr.length / 2) {
                    return i;
                }
            }
            return -1;
        }

        private int betterApproach(int arr[]) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int val = hashMap.getOrDefault(arr[i], 0);
                hashMap.put(arr[i], val + 1);
            }
            for (Map.Entry<Integer, Integer> hash : hashMap.entrySet()) {
                if (hash.getValue() > arr.length / 2) {
                    return hash.getKey();
                }
            }
            return -1;
        }

        // Moose voting algorithm
        private int optimalApproach(int arr[]) {
            int elem = 0, count = 0;
            for (int val : arr) {
                if (count == 0) {
                    count = 1;
                    elem = val;
                } else if (elem == val) {
                    count++;
                } else {
                    count--;
                }
            }
            int finalCount = 0;
            for (int val : arr) {
                if (val == elem)
                    finalCount++;
                if (finalCount > arr.length / 2)
                    return elem;
            }
            return -1;
        }
    }
}
