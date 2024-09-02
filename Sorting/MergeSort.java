import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 4, 7, 8, 1, 6, 2, 1, 3 };
        System.out.println("Before applying merge sort : ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        Solution solution = new Solution();
        int low = 0;
        int high = arr.length - 1;
        solution.divide(arr, low, high);
        System.out.println();
        System.out.println("After applying merge sort : ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    private static class Solution {
        private void divide(int nums[], int low, int high) {
            if (low == high) // single element
                return;
            int mid = (low + high) / 2;
            divide(nums, low, mid);
            divide(nums, mid + 1, high);
            conquer(nums, low, mid, high);
        }

        private void conquer(int nums[], int low, int mid, int high) {
            List<Integer> list = new ArrayList<>();
            int left = low;
            int right = mid + 1;
            while (left <= mid && right <= high) {
                if (nums[left] <= nums[right]) {
                    list.add(nums[left]);
                    left++;
                } else {
                    list.add(nums[right]);
                    right++;
                }
            }
            while (left <= mid) {
                list.add(nums[left]);
                left++;
            }
            while (right <= high) {
                list.add(nums[right]);
                right++;
            }
            int index = 0;
            for (int i = low; i <= high; i++) {
                nums[i] = list.get(index++);
            }
        }

    }
}