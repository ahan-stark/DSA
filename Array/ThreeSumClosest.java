import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 0 };
        int target = -100;
        Solution solution = new Solution();
        int ans = solution.bruteForce(arr, target);
        System.out.println(ans);
        int optimalSol = solution.optimalSol(arr, target);
        System.out.println(optimalSol);
    }

    private static class Solution {
        private int bruteForce(int arr[], int target) {
            int ans = Math.abs((arr[0] + arr[1] + arr[2]) - target);
            for (int i = 0; i < arr.length - 2; i++) {
                for (int j = i + 1; j < arr.length - 1; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        int sum = arr[i] + arr[j] + arr[k];
                        if (Math.abs(sum - target) < Math.abs(ans - target)) {
                            ans = sum;
                        }
                    }
                }
            }
            return ans;
        }

        private int optimalSol(int arr[], int target) {
            int ans = arr[0] + arr[1] + arr[arr.length - 1];
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                int j = i + 1;
                int k = arr.length - 1;
                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (Math.abs(sum - target) < Math.abs(ans - target)) {
                        ans = sum;
                    }
                    if (sum < target) {
                        j = j + 1;
                    } else {
                        k = k - 1;
                    }
                }

            }
            return ans;
        }

    }
}