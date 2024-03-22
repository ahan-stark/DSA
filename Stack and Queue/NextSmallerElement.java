//monotonic stack

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int arr[] = { 4, 8, 5, 2, 25 };
        Solution solution = new Solution();
        int bruteForceArr[] = solution.getBruteForce(arr);
        System.out.println("Brute Force :");
        for (int val : bruteForceArr) {
            System.out.println(val);
        }
        int optimalArr[] = solution.getOptimal(arr);
        System.out.println("Optimal Solution :");
        for (int val : optimalArr) {
            System.out.println(val);
        }
    }

    private static class Solution {
        private int[] getBruteForce(int arr[]) {
            int ans[] = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                int smaller = -1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[i]) {
                        smaller = arr[j];
                        break;
                    }
                }
                ans[i] = smaller;
            }
            return ans;
        }

        private int[] getOptimal(int arr[]) {
            Stack<Integer> stack = new Stack<>();
            int ans[] = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stack.peek();
                }
                stack.push(arr[i]);
            }
            return ans;
        }

    }
}
