import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
        Solution solution = new Solution();
        List<Integer> bruteSol = solution.sol(arr);
        for (Integer integer : bruteSol) {
            System.out.print(integer + "  ");
        }

    }

    private static class Solution {
        private List<Integer> sol(int arr[][]) {
            List<Integer> list = new ArrayList<>();
            int top = 0, bottom = arr.length - 1, left = 0, right = arr.length - 1;
            while (top <= bottom && left <= right) {
                // if conditions to check if there is any col or rows 
                if (top <= bottom) {
                    for (int i = left; i <= right; i++) {
                        list.add(arr[top][i]);
                    }
                    top = top + 1;
                }
                if (left <= right) {
                    for (int i = top; i <= bottom; i++) {
                        list.add(arr[i][right]);
                    }
                    right = right - 1;
                }
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        list.add(arr[bottom][i]);
                    }
                    bottom = bottom - 1;
                }
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        list.add(arr[i][left]);
                    }
                    left = left + 1;
                }
            }
            return list;

        }
    }
}
