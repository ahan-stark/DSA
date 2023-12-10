public class LeftRotateArray1Place {
    static int[] arr = new int[] { 1, 2, 3, 4, 5 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        int newArr[] = solution.leftRotate(arr);
        // optimal solution
        for (int val : newArr) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private int[] leftRotate(int arr[]) {
            int val = arr[0];
            int i = 1;
            for (i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[i - 1] = val;
            return arr;

        }
    }
}
