public class SortArrayOf0s1s2s {
    private static int arr[] = { 1, 2, 0, 1, 1, 2, 0, 0, 2, 1 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int bruteSol[] = solution.bruteForce(arr);
        System.out.println("Brute Force Approach : ");
        for (int val : bruteSol) {
            System.out.println(val);
        }
        // Better Approach
        int betterSol[] = solution.betterApproach(arr);
        System.out.println("Better Approach");
        for (int val : betterSol) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private int[] bruteForce(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[i]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            return arr;
        }

        private int[] betterApproach(int arr[]) {
            int count0 = 0, count1 = 0, count2 = 0;
            for (int val : arr) {
                if (val == 0)
                    count0++;
                else if (val == 1)
                    count1++;
                else
                    count2++;
            }
            for (int i = 0; i < count0; i++) {
                arr[i] = 0;
            }
            for (int i = count0; i < count0 + count1; i++) {
                arr[i] = 1;
            }
            for (int i = count0 + count1; i < count0 + count1 + count2; i++) {
                arr[i] = 2;
            }
            return arr;

        }
    }
}
