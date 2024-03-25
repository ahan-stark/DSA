import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int arr[] = { 5, 10, -5 };
        Solution solution = new Solution();
        int[] ansArr = solution.getSolution(arr);
        for (int val : ansArr) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private int[] getSolution(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0 || stack.isEmpty()) {
                    stack.push(arr[i]);
                } else {
                    while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(arr[i]) > stack.peek()) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek() == Math.abs(arr[i])) {
                        stack.pop();
                        continue;
                    }
                    if (stack.isEmpty() || stack.peek() < 0)
                        stack.push(arr[i]);
                }
            }
            int[] ans = new int[stack.size()];
            int i = stack.size() - 1;
            while (!stack.isEmpty()) {
                ans[i--] = stack.pop();
            }
            return ans;
        }
    }
}
