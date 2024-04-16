//convert k number of 0 to 1 such that the consecutive length is maximum
public class MaxConsecutive1sWithK {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 0 };
        int k = 2;
        Solution solution = new Solution();
        int bruteForce = solution.getBruteForce(arr, k);
        System.out.println(bruteForce);
        int betterSol = solution.getOptimal(arr, k);
        System.out.println(betterSol);

    }

    private static class Solution {
        private int getBruteForce(int arr[], int k) {
            int maxLen = 0;
            for (int i = 0; i < arr.length; i++) {
                int zeros = 0;
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] == 0) {
                        zeros++;
                    }
                    if (zeros <= k)
                        maxLen = Math.max(maxLen, j - i + 1);
                    if (zeros > k)
                        break;
                }
            }
            return maxLen;
        }

        private int getOptimal(int arr[], int k) {
            int zeroCount = 0;
            int left = 0;
            int right = 0;
            int maxLen = 0;
            while (right < arr.length) {
                if (arr[right] == 0)
                    zeroCount = zeroCount + 1;
                while (zeroCount > k) {
                    if (arr[left] == 0)
                        zeroCount = zeroCount - 1;
                    left = left + 1;
                }
                maxLen = Math.max(maxLen, right - left + 1);
                right = right + 1;
            }
            return maxLen;
        }
    }
}
// here the approach is we use 2 pointer and sliding window, we keep moving
// right and check if the val is zero, if it is zero then increase the
// zerocount, once the zerocount exceeds the k value, that means now we have to
// shift the window between left and right so we keep moving left pointer such
// that it reaches the element 0 and decrements the zercount, once sliding
// window contains zerocount less than k then we check subArray size