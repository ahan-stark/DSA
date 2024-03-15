public class FindSingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 1, 4, 2, 3, 4, 2, 1 };
        int singlEnum = solution.findSingle(arr);
        System.out.println("Single number is : " + singlEnum);
    }

    private static class Solution {
        private int findSingle(int arr[]) {
            int xor = 0;
            for (int val : arr) {
                xor = xor ^ val;
            }
            return xor;
        }

    }

}
