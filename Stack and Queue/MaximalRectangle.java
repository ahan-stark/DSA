import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
        Solution solution = new Solution();
        int largestRectangle = solution.getLargetRectangle(matrix);
        System.out.println("Largest Rectangle : " + largestRectangle);
    }

    private static class Solution {
        private int getLargetRectangle(int matrix[][]) {
            int max = Integer.MIN_VALUE;
            int row = matrix.length;
            int col = matrix[0].length;
            int rectangle[] = new int[col];
            if (row == 0)
                return 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    rectangle[j] = matrix[i][j] == 0 ? 0 : matrix[i][j] + rectangle[j];
                }
                int ans = findMaxInRow(rectangle);
                max = Math.max(max, ans);
            }
            return max;
        }

        private int findMaxInRow(int arr[]) {
            int ans = Integer.MIN_VALUE;
            int left[] = new int[arr.length];
            int right[] = new int[arr.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    stack.pop();
                }
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
            for (int i = 0; i < arr.length; i++) {
                int rectangle = (right[i] - left[i] + 1) * arr[i];
                ans = Math.max(ans, rectangle);
            }
            return ans;
        }
    }
}
// the logic is similar to largest recatngle in histogram, here we take each row
// and sum it up with above row, then for that row, we find the largest
// recatngle, but when finding the row values, if any of the arr[i] is 0 that
// means the current new temp[i] = 0, because once 0 comes, there cannot be
// rectangle with 1 above that col, it wil be already calculated in the prev row.