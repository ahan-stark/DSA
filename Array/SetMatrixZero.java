public class SetMatrixZero {
    private static int arr1[][] = { { 1, 1, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 1 }, { 1, 1, 1, 1 } };
    private static int arr2[][] = { { 1, 1, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 1 }, { 1, 1, 1, 1 } };
    private static int m = 4;
    private static int n = 4;

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        System.out.println("Brute Force Approach");
        int bruteForceArr[][] = solution.bruteForce(arr1, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(bruteForceArr[i][j]);
            }
            System.out.println();
        }
        // Better Approach
        System.out.println("Better Approach");
        int betterApproachArr[][] = solution.betterApproach(arr2, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(betterApproachArr[i][j]);
            }
            System.out.println();
        }

    }

    private static class Solution {
        private int[][] bruteForce(int arr[][], int row, int col) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (arr[i][j] == 0) {
                        for (int m = 0; m < col; m++) {
                            if (arr[i][m] != 0) {
                                arr[i][m] = -1;
                            }

                        }
                        for (int n = 0; n < row; n++) {
                            if (arr[n][j] != 0) {
                                arr[n][j] = -1;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (arr[i][j] == -1) {
                        arr[i][j] = 0;
                    }
                }
            }
            return arr;
        }

        private int[][] betterApproach(int arr[][], int row, int col) {
            boolean rowCheck[] = new boolean[row];
            boolean colCheck[] = new boolean[col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (arr[i][j] == 0) {
                        rowCheck[i] = true;
                        colCheck[j] = true;
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (rowCheck[i] || colCheck[j]) {
                        arr[i][j] = 0;
                    }
                }
            }
            return arr;

        }
    }
}
