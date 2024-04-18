public class BinaraySubArrWithSumK {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 0, 1 };
        int k = 2;
        Solution solution = new Solution();
        int totalSubArr = solution.getTotalSubArr(arr, k);
        System.out.println(totalSubArr);

    }

    private static class Solution {
        private int getTotalSubArr(int arr[], int k) {
            int totalSubArr = findTotalSubArr(arr, k) - findTotalSubArr(arr, k - 1);
            return totalSubArr;
        }

        private int findTotalSubArr(int arr[], int k) {
            if (k < 0)
                return 0;
            int count = 0;
            int sum = 0;
            int left = 0, right = 0;
            while (right < arr.length) {
                sum = sum + arr[right];
                while (sum > k) {
                    sum = sum - arr[left];
                    left = left + 1;
                }
                count = count + (right - left + 1);
                right = right + 1;
            }
            return count;
        }
    }
}
// using 2 pointer and sliding window method it is not possible to generate the
// exact count of subArr with sum = k, because as it is binary numbers, we will
// miss some of them when 0 occurs, because when we calculate sum = sum +
// arr[right], if it goes above k, then we have to move the left pointer, there
// will be some issues when 0 occurs because we wont be able to calculate exact
// subArr.... so we find all the subArr less than k and also find all the
// subArr less than k - 1, then we find exact k by finding difference between
// them, that is find(arr, k) - find(arr, k - 1);