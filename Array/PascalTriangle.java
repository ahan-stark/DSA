public class PascalTriangle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // find the value in pascal traingle if given row and col
        int row = 5, col = 3;
        int pascalVal = solution.pascalValue(row, col);
        System.out.println("Pascal value at given row : " + row + " and col : " + col + " :  " + pascalVal);
        // print the entire row in an pascal traingle
        System.out.println("Entire row of pascal triangle at row : " + row);
        solution.bruteForcePrintRow(row);
        // print the entire row in an pascal traingle
        System.out.println();
        System.out.println("Entire row of pascal triangle at row : " + row);
        solution.optimalPrintRow(row);
        // print the entire pascal triangle
        System.out.println("Pascal triangle for rows of : " + row);
        solution.printPascal(row);
    }

    private static class Solution {
        private int pascalValue(int row, int col) {
            // finding the combination of row-1 and col-1
            // combination of 2 numbers is... if 3 in deno ...the extedn the numer to 3
            // number and divide by deno
            // 10c3 == 10 * 9 * 8 / 1 * 2 * 3
            int res = 1;
            // because the row anc ol index starts from 0
            int rowVal = row - 1, colVal = col - 1;
            for (int i = 0; i < colVal; i++) {
                res = res * (rowVal - i);
                res = res / (i + 1);
            }
            return res;

        }

        private void bruteForcePrintRow(int row) {
            int rowVal = row - 1;
            for (int i = 0; i < rowVal + 1; i++) {
                System.out.print(combination(rowVal, i) + " ");
            }
        }

        private void optimalPrintRow(int row) {
            // lets say we want to print 6 th row, so the combination
            // will be 5c0 , 5c1 , 5c2 ....5c5
            int res = 1;
            System.out.print(res);
            for (int i = 1; i < row; i++) {
                res = res * (row - i);
                res = res / i;
                System.out.print(" " + res);
            }
            System.out.println();
        }

        private void printPascal(int row) {
            for (int i = 1; i <= row; i++) {
                optimalPrintRow(i);
            }
        }

        private int combination(int row, int col) {
            int res = 1;
            if (col == 0 || col == row)
                return 1;
            for (int i = 0; i < col; i++) {
                res = res * (row - i);
                res = res / (i + 1);
            }
            return res;
        }
    }
}
