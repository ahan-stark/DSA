public class FibonacciNumbers {
    public static void main(String[] args) {
        int n = 10;
        Solution solution = new Solution();
        for (int i = 1; i <= n; i++) {
            System.out.println(solution.findFib(i));
        }
    }

    private static class Solution {
        private int findFib(int n) {
            if (n == 1)
                return 0;
            if (n == 2 || n == 3)
                return 1;
            return findFib(n - 1) + findFib(n - 2);
        }

    }
}
