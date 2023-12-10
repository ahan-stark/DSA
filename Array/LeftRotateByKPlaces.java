public class LeftRotateByKPlaces {
    static int arr[] = new int[] { 10, 20, 30, 40, 50, 60, 70 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        int newArr[] = solution.sol(arr, 3);
        for (int val : newArr) {
            System.out.println(val);
        }
    }
    private static class Solution {
        private int[] sol(int arr[], int k) {
            int temp[] = new int[k];
            for (int i = 0; i < k; i++) {
                temp[i] = arr[i];
            }
            for (int i = 0; i < arr.length - k; i++) {
                arr[i] = arr[i + k];
            }
            int j = 0;
            for (int i = arr.length - k; i < arr.length; i++) {
                arr[i] = temp[j++];
            }
            return arr;
        }
    }
}
