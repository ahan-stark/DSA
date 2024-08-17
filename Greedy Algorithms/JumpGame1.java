public class JumpGame1 {
    public static void main(String[] args) {
        int arr1[] = { 3, 2, 2, 0, 4 };
        int arr2[] = { 3, 2, 1, 0, 4 };
        Solution solution = new Solution();
        System.out.println("Can i reach till end  ? " + solution.canReachEnd(arr1));
        System.out.println("Can i reach till end  ? " + solution.canReachEnd(arr2));
    }

    private static class Solution {
        private boolean canReachEnd(int arr[]) {
            int forwardStep = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i > forwardStep)
                    return false;
                forwardStep = Math.max(forwardStep, i + arr[i]);

            }
            return true;
        }

    }
}
