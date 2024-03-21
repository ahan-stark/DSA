import java.util.Stack;

public class NextGreaterElementCircular {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 1, 2, 3, 4, 3 };
        int bruteArr[] = solution.getBruteforce(arr);
        System.out.println("Brute Force : ");
        for (int val : bruteArr) {
            System.out.println(val);
        }
        System.out.println("Optimal Approach");
        int optimalArr[] = solution.getOptimal(arr);
        for (int val : optimalArr) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private int[] getBruteforce(int nums[]) {
            int newArr[] = new int[nums.length * 2];
            for (int i = 0; i < nums.length * 2; i++) {
                newArr[i] = nums[i % (nums.length)];
            }
            int ans[] = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int next = -1;
                for (int j = i + 1; j < newArr.length; j++) {
                    if (newArr[j] > nums[i]) {
                        next = newArr[j];
                        break;
                    }
                }
                ans[i] = next;
            }
            return ans;
        }

        private int[] getOptimal(int nums[]) {
            int newArr[] = new int[nums.length * 2];
            for (int i = 0; i < nums.length * 2; i++) {
                newArr[i] = nums[i % (nums.length)];
            }
            int ans[] = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = newArr.length - 1; i >= 0; i--) {
                while (!stack.empty() && stack.peek() <= newArr[i]) {
                    stack.pop();
                }
                if (i < nums.length) {
                    if (stack.isEmpty())
                        ans[i] = -1;
                    else
                        ans[i] = stack.peek();
                }
                stack.push(newArr[i]);
            }
            return ans;
        }
        // the above method we do is till 0 to n we consider for ans , so after n to
        // newArr.length we only find the monotonic stack, but we wont be comapring it
        // and making ans.. so consider for answer only if(i < n)

    }
}
