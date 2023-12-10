import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    private static int arr[] = { 1, 6, 3, 5, 4, 2, 3 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int bruteSol[] = solution.bruteForce(arr);
        System.out.println("Brute Force :");
        for (int val : bruteSol) {
            System.out.println(val);
        }
        // Optimal Solution
        int optArr[] = solution.optimal(arr);
        System.out.println("Optimal Approach :");
        for (int val : optArr) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private int[] bruteForce(int arr[]) {
            boolean isLeader;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length - 1; i++) {
                isLeader = true;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] < arr[j]) {
                        isLeader = false;
                        break;
                    }
                }
                if (isLeader) {
                    list.add(arr[i]);
                }
            }
            list.add(arr[arr.length - 1]);
            int newArr[] = new int[list.size()];
            int i = 0;
            for (Integer val : list) {
                newArr[i++] = val;
            }
            return newArr;
        }

        private int[] optimal(int arr[]) {
            List<Integer> list = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    list.add(arr[i]);
                    max = arr[i];
                }
            }
            int i = list.size() - 1;
            int newArr[] = new int[list.size()];
            for (Integer val : list) {
                newArr[i--] = val;
            }
            return newArr;
        }

    }
}
