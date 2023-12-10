import java.util.HashSet;

public class LongestConsecutiveSequence {
    private static int arr[] = { 102, 4, 103, 1, 101, 3, 2, 1, 1 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int bruteSol = solution.bruteForce(arr);
        System.out.println(bruteSol);
        // Better Approach
        int betterApproachVal = solution.betterApproach(arr);
        System.out.println(betterApproachVal);
        // optimal Approach
        int optimalSol = solution.optimal(arr);
        System.out.println(optimalSol);

    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            int count, val, max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                count = 0;
                val = arr[i];
                while (linearSearch(val, arr) == true) {
                    val = val + 1;
                    count = count + 1;
                }
                max = Math.max(max, count);
            }
            return max;

        }

        private int betterApproach(int arr[]) {
            int lastEle = Integer.MIN_VALUE;
            int count = 1;
            int max = 0;
            int[] newArr = sort(arr);
            for (int i = 0; i < newArr.length; i++) {
                if (lastEle + 1 == arr[i]) {
                    count = count + 1;
                    lastEle = arr[i];

                } else if (arr[i] != lastEle) {
                    count = 1;
                    lastEle = arr[i];
                }
                max = Math.max(max, count);
            }
            return max;
        }

        private int optimal(int arr[]) {
            int max = 0, count = 0;
            HashSet<Integer> hashSet = new HashSet<>();
            for (Integer val : arr) {
                hashSet.add(val);
            }
            for (Integer elem : hashSet) {
                if (!hashSet.contains(elem - 1)) {
                    count = 1;
                    int nextelem = elem + 1;
                    while (hashSet.contains(nextelem)) {
                        count++;
                        nextelem = nextelem + 1;
                    }
                }
                max = Math.max(max, count);
            }
            return max;
        }

        private boolean linearSearch(int val, int[] arr) {
            for (int elem : arr) {
                if (elem == val)
                    return true;
            }
            return false;
        }

        private int[] sort(int arr[]) {
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
    }

}