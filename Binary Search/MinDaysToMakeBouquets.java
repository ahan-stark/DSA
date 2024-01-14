// for the given array consists of no. days req to bloom each flower
//find the min day so that it can make 'm' bouquets
//it should contain in k adjacents
public class MinDaysToMakeBouquets {
    public static void main(String[] args) {
        int arr[] = { 7, 7, 7, 7, 13, 11, 12, 7 };
        // no. of req bouquets
        int m = 2;
        // k represnts adjacents
        int k = 3;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr, k, m);
        System.out.println("Brute Force : " + bruteForce);
        int binarySearch = solution.binarySerach(arr, k, m);
        System.out.println("Binary Search : " + binarySearch);
    }

    private static class Solution {
        public int bruteForce(int[] arr, int k, int m) {
            // get max and min value
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i : arr) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
            for (int i = min; i <= max; i++) {
                if (checkIfBlooms(arr, i, k, m) == true) {
                    return i;
                }
            }
            return -1;
        }

        private int binarySerach(int[] arr, int k, int m) {
            int low = Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;
            for (int i : arr) {
                low = Math.min(low, i);
                high = Math.max(high, i);
            }
            int ans = high;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (checkIfBlooms(arr, mid, k, m) == true) {
                    high = mid - 1;
                    ans = Math.min(ans, mid);
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }

        private boolean checkIfBlooms(int[] arr, int days, int k, int m) {
            int count = 0;
            int noOfBlooms = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= days) {
                    count++;
                } else {
                    noOfBlooms += (count / k);
                    count = 0;
                }
            }
            noOfBlooms += (count / k);
            return noOfBlooms >= m ? true : false;
        }
    }
}
