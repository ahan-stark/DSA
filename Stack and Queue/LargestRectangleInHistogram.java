import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3, 1 };
        Solution solution = new Solution();
        int bruteForceAns = solution.getBruteForce(arr);
        System.out.println("Brute Force : " + bruteForceAns);
        int optimalAns = solution.getOptimalSol(arr);
        System.out.println("Optimal Solution : " + optimalAns);
        int efficeintApproach = solution.getEfficientSol(arr);
        System.out.println("Efficient Solution : " + efficeintApproach);
    }

    private static class Solution {
        private int getBruteForce(int arr[]) {
            int left = 0, right = 0, max = 0;
            for (int i = 0; i < arr.length; i++) {
                left = i;
                right = i;
                int height = arr[i];
                while (left > 0 && arr[left - 1] >= arr[i]) {
                    left = left - 1;
                }
                while (right < arr.length - 1 && arr[right + 1] >= arr[i]) {
                    right = right + 1;
                }
                int ans = (right - left + 1) * height;
                max = Math.max(max, ans);
            }
            return max;
        }

        private int getOptimalSol(int arr[]) {
            int left[] = new int[arr.length];
            int right[] = new int[arr.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < right.length; i++) {
                while (!stack.isEmpty() && arr[i] <= arr[stack.peek()])
                    stack.pop();
                if (stack.isEmpty())
                    left[i] = 0;
                else
                    left[i] = stack.peek() + 1;
                stack.push(i);
            }
            while (!stack.isEmpty())
                stack.pop();
            for (int i = arr.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    stack.pop();
                }
                if (stack.isEmpty())
                    right[i] = arr.length - 1;
                else
                    right[i] = stack.peek() - 1;
                stack.push(i);
            }
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                int rectangle = (right[i] - left[i] + 1) * arr[i];
                ans = Math.max(ans, rectangle);
            }
            return ans;
        }
        // In the stack solution, we use a strictly increasing monotonic stack to find
        // the next smaller element for each height[i] in the histogram. By finding the
        // next smaller element, we determine the boundaries where a rectangle can be
        // formed. If the next smaller element is found, it indicates that the rectangle
        // cannot extend to that smaller element from the current one. Therefore, we set
        // that smaller element as the left boundary, and for height[i], we can go up to
        // smaller + 1 from the current index.so left[i] = smaller + 1;

        // The same logic is applied to find the right next smaller element. If we find
        // any smaller element to the right of the current element, it means we cannot
        // form a rectangle with that smaller value for the current height. So, the
        // right boundary will be right smaller - 1. so right[i] = smaller - 1;

        // If the stack becomes empty while finding the next smaller element to the
        // left, it means there is no smaller element for the current element, so we put
        // 0. Similarly, for the right boundary, if no smaller element is found to the
        // right, we put arr.length - 1.

        private int getEfficientSol(int arr[]) {
            int ans = -1;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= arr.length; i++) {
                while (!stack.isEmpty() && (i == arr.length || arr[i] <= arr[stack.peek()])) {
                    int height = arr[stack.pop()];
                    int width;
                    if (stack.isEmpty())
                        width = i;
                    else
                        width = i - stack.peek() - 1;
                    int rectangle = (width * height);
                    ans = Math.max(ans, rectangle);
                }
                stack.push(i);
            }
            return ans;
        }
    }
    // just check if the new element is less than than stack.peek(), if the new is
    // less so that is the right boundary, so take stack.peek() as length and pop it
    // and take stack.top() as left boundary, then find left - right - 1 to find
    // total width and multiply with length, if in case stack become empty while
    // checking right or left , consider that i is the width, so for the last
    // element we have to check till n + 1 for the edge case if right is not present
}
