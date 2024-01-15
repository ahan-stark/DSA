public class CapacitytoShipPackageswithinDDays {
    public static void main(String[] args) {
        int weights[] = { 5, 4, 5, 2, 3, 4, 5, 6 };
        int d = 5;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(weights, d);
        System.out.println("Brute Force  : " + bruteForce);
        int binarySearch = solution.binarySeach(weights, d);
        System.out.println("Binary Search : " + binarySearch);

    }

    private static class Solution {
        private int bruteForce(int weights[], int days) {
            // if we have weights 1, 2, 3, 4, and 8, the array should be capable of carrying
            // at least 8 to accommodate all the weights for shipping.
            int max = Integer.MIN_VALUE;
            int totalSum = 0;
            // if we carry the total sum of array we can do it in 1 day so that will be the
            // last option
            for (int ele : weights) {
                max = Math.max(max, ele);
                totalSum += ele;
            }
            for (int i = max; i <= totalSum; i++) {
                if (checkTotalDays(weights, i) <= days) {
                    return i;
                }
            }
            return totalSum;
        }

        private int binarySeach(int weights[], int days) {
            int max = Integer.MIN_VALUE;
            int totalSum = 0;
            for (int ele : weights) {
                max = Math.max(max, ele);
                totalSum += ele;
            }
            int low = max;
            int high = totalSum;
            while (low <= high) {
                int mid = (low + high) / 2;
                if ((checkTotalDays(weights, mid)) <= days)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return low;
        }

        private int checkTotalDays(int[] weights, int capacity) {
            int totalDays = 1;
            int sum = 0;
            for (int ele : weights) {
                if (ele + sum > capacity) {
                    totalDays++;
                    sum = ele;
                } else {
                    sum += ele;
                }
            }
            return totalDays;
        }
    }
}
