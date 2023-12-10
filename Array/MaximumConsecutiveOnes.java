public class MaximumConsecutiveOnes {
    static private int arr[] = new int[] { 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // optimal approach
        int maxOne = solution.sol(arr);
        System.out.println("The maximum one's in an array is : " + maxOne);

    }

    private static class Solution {
        private int sol(int arr[]) {
            int count = 0, max = 0;
            for (int val : arr) {
                if (val == 0) {
                    count = 0;
                } else if (val == 1) {
                    count++;
                    if (count > max) {
                        max = count;
                    }
                }
            }
            return max;
        }
    }

}
