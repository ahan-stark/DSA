public class ReverseAnArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 1, 2, 3, 4, 5 };
        int[] newArr = solution.betterApproach(arr);
        for (int ele : newArr) {
            System.out.println(ele);
        }
    }

    private static class Solution {
        private int[] betterApproach(int arr[]) {
            return recursiveApproach(arr, 0, arr.length - 1);
        }

        private int[] recursiveApproach(int arr[], int left, int right) {
            if (left >= right)
                return arr;
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            return recursiveApproach(arr, left + 1, right - 1);
        }

    }
}
