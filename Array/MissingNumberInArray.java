public class MissingNumberInArray {
    static int[] arr = new int[] { 1, 2, 3, 4, 6 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int missing = solution.bruteForce(arr);
        System.out.println(missing);
        // Better approach
        int missingNum = solution.betterApproach(arr);
        System.out.println(missingNum);
        // Optimal Approach
        int num = solution.optimal(arr);
        System.out.println(num);

    }

    static private class Solution {
        private int bruteForce(int arr[]) {
            int n = arr.length;
            boolean found;
            for (int i = 1; i <= n; i++) {
                found = false;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == i) {
                        found = true;
                    }
                }
                if (!found) {
                    return i;
                }
            }
            return -1;
        }

        private int betterApproach(int arr[]) {
            int hash[] = new int[arr.length + 1];
            for (int i = 0; i < arr.length - 1; i++) {
                hash[arr[i]] = 1;
            }

            for (int i = 1; i <= arr.length; i++) {
                if (hash[i] == 0) {
                    return i;
                }
            }
            return -1;

        }

        private int optimal(int arr[]) {
            int sum = 0;
            int arrSum = 0;
            int n = arr.length + 1;
            sum = n * (n + 1) / 2;
            for (int val : arr) {
                arrSum = arrSum + val;
            }
            return sum - arrSum;
        }
    }
}
