//for a given deadline hour we have to find the minimum amount of Banana the koko have to eat , so that it finishes all the bananas
// if we consider the max element in the array and say it eats the max element value every hour than thats correct, because it will inside the deadline
//we have to find the minimum 
public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 7, 15, 6, 3 };
        int hour = 8;
        int bruteForce = solution.bruteForce(arr, hour);
        System.out.println("Brute Force : " + bruteForce);
        int binarySerach = solution.binarySerach(arr, hour);
        System.out.println("Minimum number of banana consumed by koko is : " + binarySerach);
    }

    private static class Solution {
        private int bruteForce(int arr[], int hour) {
            // if the kiko eats per hour the max element value, it will finish off within
            // the given deadline so assign it at start
            int max = maxElement(arr);
            int totalHour = 1;
            for (int i = 1; i <= max; i++) {
                totalHour = calculateTotalHours(arr, i);
                // the moment we get the min value return it
                if (totalHour <= hour) {
                    return i;
                }
            }
            return max;
        }

        private int binarySerach(int arr[], int hour) {
            int low = 1;
            int high = maxElement(arr);
            int ans = Integer.MAX_VALUE;
            while (low <= high) {
                int mid = (low + high) / 2;
                int totalHours = calculateTotalHours(arr, mid);
                if (totalHours <= hour) {
                    ans = Math.min(mid, ans);
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }

        private int maxElement(int[] arr) {
            int max = Integer.MIN_VALUE;
            for (int val : arr) {
                max = Math.max(val, max);
            }
            return max;
        }

        private int calculateTotalHours(int arr[], int mid) {
            int totalH = 0;
            int n = arr.length;
            // find total hours:
            for (int i = 0; i < n; i++) {
                totalH += Math.ceil((double) (arr[i]) / (double) (mid));
            }
            return totalH;
        }
    }
}
