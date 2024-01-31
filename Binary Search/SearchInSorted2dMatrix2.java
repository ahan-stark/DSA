// : You have been given a 2-D array ‘mat’ of size ‘N x M’ where ‘N’ and ‘M’ denote the number of rows and columns, respectively.
// But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists).
public class SearchInSorted2dMatrix2 {
    public static void main(String[] args) {
        int arr[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target = 14;
        Solution solution = new Solution();
        int ans[] = solution.bruteForce(arr, target);
        System.out.println("Brute Force : " + "row : " + ans[0] + " col : " + ans[1]);
        int betterSol[] = solution.betterApproach(arr, target);
        System.out.println("Better Approach : " + "row : " + betterSol[0] + " col : " + betterSol[1]);
        int optimalSol[] = solution.optimalSol(arr, target);
        System.out.println("Optimal Approach : " + "row : " + optimalSol[0] + " col : " + optimalSol[1]);

    }

    private static class Solution {
        private int[] bruteForce(int arr[][], int target) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
            return new int[] { -1, -1 };
        }

        private int[] betterApproach(int arr[][], int target) {
            for (int i = 0; i < arr.length; i++) {
                int index = checkRow(arr[i], target);
                if (index != -1) {
                    return new int[] { i, index };
                }
            }
            return new int[] { -1, -1 };
        }

        private int checkRow(int arr[], int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target)
                    return mid;
                if (arr[mid] <= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return -1;
        }

        // optimal solution
        // always the straight row and ending row col vertical will be sorted
        // mid = arr[row][col]
        // so keep the pointer at last, of row and start of col as mid ele and compare
        // if the mid is less than target row will not have the target so increment the
        // row
        // if the mid is greater than target col will not have the target so decrement
        // the target
        private int[] optimalSol(int arr[][], int target) {
            int row = 0, col = arr[0].length - 1;
            while (row < arr.length && col >= 0) {
                if (arr[row][col] == target) {
                    return new int[] { row, col };
                } else if (arr[row][col] < target) {
                    row++;
                } else {
                    col--;
                }
            }
            return new int[] { -1, -1 };
        }
    }
}
