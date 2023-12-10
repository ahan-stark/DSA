public class ElementsAppearingOnce {
    static private int[] arr = new int[] { 1, 1, 2, 2, 3, 4, 4, 5, 5 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int num = solution.bruteForce(arr);
        System.out.println("The element appearing only once is : " + num);
        // Better Approach
        int oneElem = solution.betterApproach(arr);
        System.out.println("The element appearing only once is : " + oneElem);
        // Optimal Approach
        int oneTime = solution.optimalApproach(arr);
        System.out.println("The element appearing only once is : " + oneTime);

    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            int count;
            for (int i = 0; i < arr.length; i++) {
                count = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == arr[i]) {
                        count++;
                    }
                }
                if (count == 1)
                    return arr[i];
            }
            return -1;
        }

        private int betterApproach(int arr[]) {
            int hash[] = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                hash[arr[i]]++;
            }
            for (int i = 1; i <= arr.length; i++) {
                if (hash[i] == 1)
                    return i;
            }
            return -1;
        }

        private int optimalApproach(int arr[]) {
            int xor = 0;
            for (int val : arr) {
                xor = xor ^ val;
            }
            return xor;
        }

    }
}
