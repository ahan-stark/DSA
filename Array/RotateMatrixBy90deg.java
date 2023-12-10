public class RotateMatrixBy90deg {
    private static int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int[][] bruteMatrix = solution.bruteForce(arr);
        System.out.println("Brute Force");
        for (int i = 0; i < bruteMatrix.length; i++) {
            for (int j = 0; j < bruteMatrix.length; j++) {
                System.out.print("  " + bruteMatrix[i][j] + "  ");
            }
            System.out.println();
        }
        // optimal Approach
        int[][] optimalMatrix = solution.optimalApproach(arr);
        System.out.println("Optimal Approach");
        for (int i = 0; i < optimalMatrix.length; i++) {
            for (int j = 0; j < optimalMatrix.length; j++) {
                System.out.print("  " + optimalMatrix[i][j] + "  ");
            }
            System.out.println();
        }

    }

    private static class Solution {
        private int[][] bruteForce(int arr[][]) {
            int index = arr.length - 1;
            int newArr[][] = new int[arr.length][arr.length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    newArr[j][index] = arr[i][j];
                }
                index--;
            }
            return newArr;
        }

        private int[][] optimalApproach(int arr[][]) {
            // Find transpose
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }

            // reverse the transpose matrix to obtain rotation of 90 degree
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length / 2; j++) {
                    int temp = arr[i][(arr.length - 1) - j];
                    arr[i][(arr.length - 1) - j] = arr[i][j];
                    arr[i][j] = temp;
                }
            }
            return arr;
        }

    }
}
