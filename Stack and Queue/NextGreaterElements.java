import java.util.Stack;
//use monotonic stack

public class NextGreaterElements {
    public static void main(String[] args) {
        int arr[] = { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };
        Solution solution = new Solution();
        int ansArr[] = solution.findNextGreaterElements(arr);
        for (int ele : ansArr) {
            System.out.println(ele);
        }
    }

    private static class Solution {
        private int[] findNextGreaterElements(int arr[]) {
            int ans[] = new int[arr.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = arr.length - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    stack.push(arr[i]);
                    ans[i] = -1;
                } else if (stack.peek() > arr[i]) {
                    ans[i] = stack.peek();
                    stack.push(arr[i]);
                } else {
                    while (!stack.isEmpty() && (stack.peek() <= arr[i])) {
                        stack.pop();
                    }
                    ans[i] = stack.empty() == true ? -1 : stack.peek();
                    stack.push(arr[i]);
                }
            }
            return ans;
        }

    }
}
