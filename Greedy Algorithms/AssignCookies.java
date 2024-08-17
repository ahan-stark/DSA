import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int greed[] = { 3, 4, 5, 3, 1 };
        int cookies[] = { 1, 2, 2, 3, 1, 4 };
        Solution solution = new Solution();
        int total = solution.getTotalSatisfied(greed, cookies);
        System.out.println(total);

    }

    private static class Solution {
        private int getTotalSatisfied(int[] greed, int[] cookies) {
            Arrays.sort(greed);
            Arrays.sort(cookies);
            int i = 0;
            int j = 0;
            while (i < greed.length && j < cookies.length) {
                if (cookies[j] >= greed[i]) {
                    i++;
                }
                j++;
            }
            return i;
        }

    }

}