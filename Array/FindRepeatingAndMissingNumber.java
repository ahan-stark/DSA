public class FindRepeatingAndMissingNumber {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 5, 3 };
        Solution solution = new Solution();
        // bruteForce Solution
        solution.bruteForce(arr);
        // better approach
        solution.betterApproach(arr);
        // optimal Approach
        solution.optimalSolution(arr);
    }

    private static class Solution {
        public void bruteForce(int arr[]) {
            int repeatNum = Integer.MIN_VALUE;
            int missingNum = Integer.MAX_VALUE;
            for (int i = 1; i <= arr.length; i++) {
                int elem = i;
                int count = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (elem == arr[j]) {
                        count++;
                    }
                }
                if (count == 2)
                    repeatNum = elem;
                else if (count == 0)
                    missingNum = elem;
            }
            System.out.println("repeating Num : " + repeatNum);
            System.out.println("Missing Number : " + missingNum);
        }

        public void betterApproach(int[] arr) {
            int checkArr[] = new int[arr.length + 1];
            int repeatNum = Integer.MIN_VALUE;
            int missingNum = Integer.MAX_VALUE;
            for (int i = 1; i <= arr.length; i++) {
                checkArr[arr[i - 1]]++;
            }
            for (int i = 1; i < checkArr.length; i++) {
                if (checkArr[i] > 1)
                    repeatNum = i;
                if (checkArr[i] == 0)
                    missingNum = i;
            }
            System.out.println("repeating Num : " + repeatNum);
            System.out.println("Missing Number : " + missingNum);
        }

        // Optimal Approach
        // using Maths
        private void optimalSolution(int arr[]) {
            // find x-y
            // x is sum of the given array nad y is sum of 1 -> n
            int s = 0, sn = 0;
            int n = arr.length;
            for (int i = 0; i < arr.length; i++) {
                s = s + arr[i];
            }
            sn = n * (n + 1) / 2;
            // x - y -> s - sn
            int val = s - sn;
            // find the sqaures of the elements and 1 -> n
            int s2 = 0, s2n = 0;
            for (int i = 0; i < arr.length; i++) {
                s2 = s2 + (arr[i] * arr[i]);
            }
            // to find the sqaures from 1 to n
            s2n = (n * (n + 1) * (2 * n + 1)) / 6;
            // now we have x-y and x2-y2 (sqaure)
            // x2-y2 can be (x-y)(x+y) => (x+y)= s2n / (x-y)
            int val2 = s2 - s2n;
            // val2 will hold value x+y
            // find x + y = x2 - y2 / x - y
            val2 = val2 / val;
            // s2n => becomes x + y
            // now (x+y) + (x-y) = > x = (val2 + val1)/2 equating both
            int x = (val2 + val) / 2;
            int y = x - val;
            System.out.println("repeating number : " + x);
            System.out.println("Missing Number : " + y);
        }
    }
}
