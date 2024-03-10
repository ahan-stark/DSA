public class findPower {
    public static void main(String[] args) {
        double x = 0.00001;
        int n = 2147483647;
        Solution solution = new Solution();
        double optimalApproach = solution.optimalApproach(x, n);
        System.out.println(x + " power of " + n + " : " + optimalApproach);
    }

    private static class Solution {
        private double optimalApproach(double x, int n) {
            double ans = 1;
            long nval = n;
            // handling the negative n
            if (n < 0) {
                nval = nval * (-1);
            }
            while (nval > 0) {
                if (nval % 2 == 0) {
                    x = x * x;
                    nval = nval / 2;
                } else {
                    ans = ans * x;
                    nval = nval - 1;
                }
            }
            if (n < 0)
                ans = 1 / ans;
            return ans;

        }
    }
}
