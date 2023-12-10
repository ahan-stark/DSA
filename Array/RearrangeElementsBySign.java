public class RearrangeElementsBySign {
    private static int arr[] = { 3, 1, -2, -5, 2, -4 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force approacj
        int bruteSol[] = solution.bruteForce(arr);
        for (int val : bruteSol) {
            System.out.println(val);
        }
        System.out.println("optimal Approach");
        // Optimal Approach
        int optimalSol[] = solution.optimalApproach(arr);
        for (int val : optimalSol) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private int[] bruteForce(int arr[]) {
            int pos[] = new int[arr.length/2];
            int neg[] = new int[arr.length/2];
            int i = 0, j = 0;
            for (int val : arr) {
                if (val < 0) {
                    neg[i++] = val;
                } else {
                    pos[j++] = val;
                }
            }
            int p = 0, n = 0;
            for (int m = 0; m < arr.length - 1; m = m + 2) {
                arr[m] = pos[p++];
                arr[m + 1] = neg[n++];
            }
            return arr;
        }

        private int[] optimalApproach(int arr[]) {
            int pos = 0, neg = 1;
            int newArr[] = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    newArr[pos] = arr[i];
                    pos = pos + 2;
                } else {
                    newArr[neg] = arr[i];
                    neg = neg + 2;
                }
            }
            return newArr;
        }
    }
}
