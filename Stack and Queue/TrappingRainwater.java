import java.util.Stack;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] arr = { 3, 0, 2, 0, 4 };
        Solution solution = new Solution();
        int totalWater = solution.getTrappedWater(arr);
        System.out.println(totalWater);
        int stackTotWater = solution.getTrappedWaterUsingStack(arr);
        System.out.println(stackTotWater);

    }

    private static class Solution {
        private int getTrappedWater(int arr[]) {
            int left[] = new int[arr.length];
            int right[] = new int[arr.length];
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                leftMax = Math.max(leftMax, arr[i]);
                left[i] = leftMax;
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                rightMax = Math.max(rightMax, arr[i]);
                right[i] = rightMax;
            }
            int totalWater = 0;
            for (int i = 0; i < arr.length; i++) {
                totalWater = totalWater + (Math.min(left[i], right[i]) - arr[i]);
            }
            return totalWater;
        }
        // the above given arr numbers suggests the size of brick, we need to add water
        // in gap of the other bricks
        // so we find arrays as left and right
        // left will get the max left values from 0 to n
        // right will get the max right values from n - 1 to 0
        // once we have both we can check from each position what is the maximum level
        // of brick from left and right , so that each brick above in each one we can
        // add water, we check for each brick in array then if we have max left as 3 and
        // max right as 4, so water only will be stored upto 3, so we should consider
        // min of both max values ofleft and right but for that position if there is a
        // brick we cannot fill water on brick so minus that value of brick

        private int getTrappedWaterUsingStack(int arr[]) {
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                    int totalOccupied = arr[stack.pop()];
                    if (stack.isEmpty())
                        break;
                    int distance = i - stack.peek() - 1;
                    int totalDistanceVal = Math.min(arr[stack.peek()], arr[i]) - totalOccupied;
                    ans = ans + distance * totalDistanceVal;
                }
                stack.push(i);
            }
            return ans;
        }
        // here the logic is , if stack is empty directly put the i
        // index, if the stack.peek() is greater than the current element then it is
        // possible to fill the water in that area, so put index in stack , if the new
        // looped elem is greater than stack.peek() then we can say this can be right
        // max, so we go inside the while loop and take stack.pop() this will be the
        // middle of leftMax anbd rightMax , so there will be brick in there so for that
        // will be already occupied height, so totalOccupied = stack.pop() then we check
        // the distance between curent i and stack.peek() that are leftMax and rightMax
        // find the totalWater that can be filled that is totalDistanceVal = min(arr[i],
        // stack.peek()) - totalOccupied , so for entire distance we can fill so much
        // water, so ans = ans + distance * totalDistanceVal;
    }
}
