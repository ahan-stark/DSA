public class MedianOfRowWiseSorted2dMatrix {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 4, 9, },
                { 2, 5, 6 },
                { 3, 8, 7 } };
        Solution solution = new Solution();
        int sol = solution.binarySearch(matrix);
        System.out.println("Median of sorted row 2D Array is : " + sol);
    }

    private static class Solution {
        // as the rows are in sorted form, we can find low as min value of first col
        // that will be minimum in matrix and high as max val of last col that will be
        // the max elem val of matrix
        // median val will be (n * m) / 2;
        // then we find a mid and check how many element are less than that, if its
        // smaller elem is less than (n * m) / 2 that means most of the elems are in
        // right side , so cut down right or if small elem is greater than cut down left
        // part

        private int binarySearch(int matrix[][]) {
            int low = Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                low = Math.min(low, matrix[i][0]);
                high = Math.max(high, matrix[i][matrix[0].length - 1]);
            }
            while (low <= high) {
                int mid = (low + high) / 2;
                int smallerThanMid = totalSmallerThanMid(matrix, mid);
                if (smallerThanMid <= ((matrix.length * matrix[0].length) / 2)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        private int totalSmallerThanMid(int matrix[][], int mid) {
            int totalSmallerElem = 0;
            for (int i = 0; i < matrix.length; i++) {
                // upper bound will always contain the next big elem
                // so we can calculate the total number of smaller elements using upperbound
                // index
                totalSmallerElem += upperBound(matrix[i], mid);
            }
            return totalSmallerElem;
        }

        private int upperBound(int arr[], int ele) {
            int low = 0;
            int high = arr.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > ele) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }
    }
}
