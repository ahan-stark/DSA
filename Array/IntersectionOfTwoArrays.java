import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int nums1[] = { 1, 2, 2, 1 };
        int nums2[] = { 2, 2 };
        Intersection intersection = new Intersection();
        int[] ans = intersection.getInterSection(nums1, nums2);
        for (int val : ans) {
            System.out.println(val);
        }
    }

    private static class Intersection {
        private int[] getInterSection(int nums1[], int nums2[]) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int prev = Integer.MIN_VALUE;
            List<Integer> list = new ArrayList<>();
            int left = 0, right = 0;
            while (left < nums1.length && right < nums2.length) {
                if (nums1[left] == nums2[right] && nums1[left] != prev) {
                    list.add(nums1[left]);
                    prev = nums1[left];
                    left = left + 1;
                    right = right + 1;
                    continue;
                }
                if (nums1[left] < nums2[right])
                    left = left + 1;
                else
                    right = right + 1;
            }
            int newArr[] = new int[list.size()];
            int i = 0;
            for (int val : list) {
                newArr[i++] = val;
            }
            return newArr;
        }

    }
}
