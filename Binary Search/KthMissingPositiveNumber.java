public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 7, 9 };
        int k = 3;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr, k);
        System.out.println("Brute Force : " + bruteForce);

    }

    private static class Solution {

        public int bruteForce(int[] arr, int k) {
            // for an empty array the mising 3 value is 3 , so for array containg sorted
            // values if the elem is less than k increase the k value until k is less than
            // elem
            for (int ele : arr) {
                if (ele <= k) {
                    k++;
                } else {
                    break;
                }
            }
            return k;
        }

    }
}
