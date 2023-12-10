import java.util.HashSet;

public class RemoveDuplictaesFromArray {
    static int arr[] = new int[] { 1, 2, 2, 3, 3, 3 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // BruteForce
        int bruteForce[] = solution.bruteForce(arr);
        System.out.println("Brute force :");
        for (int val : bruteForce) {
            System.out.println(val);
        }
        // optimal apptoach
        System.out.println("Optimal Approach");
        int optimal[] = solution.optimal(arr);
        for (int val : optimal) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private int[] bruteForce(int[] arr) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                hashSet.add(arr[i]);
            }
            int index = 0;
            for (int val : hashSet) {
                arr[index++] = val;
            }
            return arr;
        }

        private int[] optimal(int[] arr) {
            int i = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] != arr[j]) {
                    arr[i + 1] = arr[j];
                    i++;
                }
            }
            return arr;

        }
    }
}
