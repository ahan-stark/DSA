import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UnionOfSortedArrays {
    static int arr1[] = new int[] { 1, 2, 2, 4, 5 };
    static int arr2[] = new int[] { 2, 3, 4, 5, 5, 6 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int newArr[] = solution.bruteForce(arr1, arr2);
        System.out.println("Union of 2 array in brute force approach");
        for (int val : newArr) {
            System.out.println(val);
        }
        // Optimal Solution
        System.out.println("Union of 2 array in Optimal approach");
        int unionArr[] = solution.optimal(arr1, arr2);
        for (int val : unionArr) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private int[] bruteForce(int arr1[], int arr2[]) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int val : arr1) {
                hashSet.add(val);
            }
            for (int val : arr2) {
                hashSet.add(val);
            }
            int unionArr[] = new int[hashSet.size()];
            int i = 0;
            for (int val : hashSet) {
                unionArr[i++] = val;
            }
            return unionArr;
        }

        private int[] optimal(int arr1[], int arr2[]) {
            List<Integer> list = new ArrayList<>();
            int i = 0, j = 0;
            int prev = Integer.MIN_VALUE;
            while (i < arr1.length && j < arr2.length) {
                if (arr1[i] <= arr2[j]) {
                    if (arr1[i] != prev) {
                        list.add(arr1[i]);
                        prev = arr1[i];
                    }
                    i++;
                } else {
                    if (arr2[j] != prev) {
                        list.add(arr2[j]);
                        prev = arr2[j];
                    }
                    j++;
                }
            }
            while (i < arr1.length) {
                if (arr1[i] != prev) {
                    list.add(arr1[i]);
                    prev = arr1[i];
                }
                i++;
            }
            while (j < arr2.length) {
                if (arr2[j] != prev) {
                    list.add(arr2[j]);
                    prev = arr2[j];
                }
                j++;
            }
            int[] unionArr = new int[list.size()];
            int index = 0;
            for (int val : list) {
                unionArr[index++] = val;
            }
            return unionArr;
        }
    }
}
