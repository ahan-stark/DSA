public class CheckArrayIsSorted {
    static int arr1[] = new int[] { 1, 2, 3, 4, 4, 5 };
    static int arr2[] = new int[] { 1, 2, 5, 4, 3 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("The elements of arr1 is sorted ? " + solution.checkSorted(arr1));
        System.out.println("The elements of arr2 is sorted ? " + solution.checkSorted(arr2));

    }

    private static class Solution {
        private boolean checkSorted(int arr[]) {
            int prev = arr[0];
            for (int val : arr) {
                if (prev > val) {
                    return false;
                }
                prev = val;
            }
            return true;
        }
    }
}
