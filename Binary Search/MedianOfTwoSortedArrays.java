public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int nums1[] = { 2, 4, 6 };
        int nums2[] = { 1, 3, 5 };
        Solution solution = new Solution();
        double bruteForce = solution.bruteForce(nums1, nums2);
        System.out.println("Brute Force : " + bruteForce);
        double binarySearch = solution.binarySearch(nums1, nums2);
        System.out.println("Binary Search : " + binarySearch);
    }

    private static class Solution {
        private double bruteForce(int nums1[], int nums2[]) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int ptr1 = 0;
            int ptr2 = 0;
            int ptr = 0;
            int ans = 0;
            int finalArr[] = new int[n1 + n2];
            while (ptr1 < n1 && ptr2 < n2) {
                if (nums1[ptr1] <= nums2[ptr2]) {
                    finalArr[ptr++] = nums1[ptr1++];
                } else {
                    finalArr[ptr++] = nums2[ptr2++];
                }
            }
            while (ptr1 < n1) {
                finalArr[ptr++] = nums1[ptr1++];
            }
            while (ptr2 < n2) {
                finalArr[ptr++] = nums2[ptr2++];
            }
            if ((n1 + n2) % 2 == 0) {
                ans = (finalArr[(finalArr.length) / 2]) + (finalArr[(finalArr.length) / 2 - 1]);
                return (double) ans / 2;
            } else {
                ans = (finalArr[(int) Math.floor(finalArr.length / 2)]);
                return (double) ans;
            }
        }

        private double binarySearch(int nums1[], int nums2[]) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            // we need n1 to be small array
            if (n1 > n2)
                return binarySearch(nums2, nums1);
            // we will consider small array for our operations
            // we do indexing like we consider 0 items from nums1(smallArr),1 items ,2
            // items, 3items....
            int low = 0;
            int high = n1;
            // we ned to calculate the left part... that is how many elements should be in
            // left side... if we have 8 elems then 4 will be on left else if we have 7
            // elements 4 will be on left
            int left = (n1 + n2 + 1) / 2;
            while (low <= high) {
                // mid will point to the starting point of right half..bcz we are going frm 0 to
                // n1 not n-1
                int mid1 = (low + high) / 2;
                // calculate the left out to fill in left
                int mid2 = left - mid1;
                // calculate l1, l2 r1,r2
                // l1 = last elem of nums1 in left half
                // l2 = last elem of nums2 in left half
                // r1 = first elem of rest of nums1
                // r2 = first elem of rest of nums2
                int l1 = (mid1) > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
                int l2 = (mid2) > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
                int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
                int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;
                // the pointer are mentioned above, l1,l2 in same half r1,r2 in same half
                // if L1 < R2 and L2 < R1 only then we can say the array is sorted
                if (l1 <= r2 && l2 <= r1) {
                    if ((n1 + n2) % 2 == 1) {
                        // odd number of total elems then we consider l1 and l2 find max of both that is
                        // the answer
                        return Math.max(l1, l2);
                    } else {
                        // we have even number of elems, then we find max of left side, then we find min
                        // of right side
                        return (double) ((Math.max(l1, l2) + Math.min(r1, r2))) / 2;
                    }
                }
                // if the l1 is larger than r2 that means that l1 should be on right side so we
                // trim the high
                else if (l1 > r2)
                    high = mid1 - 1;
                else
                    low = mid1 + 1;
            }
            return -1;
        }
    }
}
