// Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board.
// Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint. 
// You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.
public class PainterPartition {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40 };
        int k = 2;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr, k);
        System.out.println("Brute Force : " + bruteForce);
        int binarySearch = solution.binarySearch(arr, k);
        System.out.println("Binary Search : " + binarySearch);
    }

    private static class Solution {
        private int bruteForce(int arr[], int k) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int ele : arr) {
                max = Math.max(max, ele);
                sum = sum + ele;
            }
            for (int i = max; i <= sum; i++) {
                // i represents time allocated to each painters
                if (checkTotalPainters(arr, i) <= k) {
                    return i;
                }
            }
            return sum;
        }

        private int binarySearch(int arr[], int k) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int ele : arr) {
                max = Math.max(max, ele);
                sum = sum + ele;
            }
            int low = max, high = sum;
            while (low <= high) {
                int mid = (low + high) / 2;
                // check with the time of mid if its less than given k trim down high else trim
                // low
                if (checkTotalPainters(arr, mid) <= k)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return low;
        }

        private int checkTotalPainters(int[] arr, int time) {
            int totalPainter = 1;
            int sum = 0;
            for (int ele : arr) {
                if (sum + ele <= time) {
                    sum = sum + ele;
                } else {
                    totalPainter++;
                    sum = ele;
                }
            }
            return totalPainter;
        }
    }
}
