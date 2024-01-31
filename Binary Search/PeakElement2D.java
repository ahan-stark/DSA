public class PeakElement2D {
    public static void main(String[] args) {
        int arr[][] = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };
        Solution solution = new Solution();
        int binarySearch[] = solution.binarySearch(arr);
        System.out.println("Peak element is at index row : " + binarySearch[0] + " col : " + binarySearch[1]);
    }

    private static class Solution {
        private int[] binarySearch(int arr[][]) {
            // we take a col and get the max of it , so the above that max and below that
            // max the values will be lesser
            // and then we compare it with nearby rows left and right
            // if its less then its the peak element, if there is greater num in left that
            // means trim all the right part and check in left part,
            // else check opposite part
            int low = 0, high = arr[0].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int rowIndexOfMax = getMax(arr, mid);
                int left = (mid - 1) >= 0 ? arr[rowIndexOfMax][mid - 1] : -1;
                int right = (mid + 1) < arr[0].length ? arr[rowIndexOfMax][mid + 1] : -1;
                if (left < arr[rowIndexOfMax][mid] && right < arr[rowIndexOfMax][mid]) {
                    return new int[] { rowIndexOfMax, mid };
                } else if (left > arr[rowIndexOfMax][mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return new int[] { -1, -1 };
        }

        private int getMax(int arr[][], int col) {
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][col] > max) {
                    max = arr[i][col];
                    index = i;
                }
            }
            return index;
        }
    }
}
