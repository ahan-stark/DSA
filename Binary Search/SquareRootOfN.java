public class SquareRootOfN {
    public static void main(String[] args) {
        int n = 39;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(n);
        System.out.println("Brute-Force sqrt : " + bruteForce);
        int binarySearch = solution.binarySearch(n);
        System.out.println("Binary Serach sqrt : " + binarySearch);

    }

    private static class Solution {
        private int bruteForce(int n) {
            int sqrt = 1;
            for (int i = 1; i < n / 2; i++) {
                if ((i * i) <= n)
                    sqrt = i;
                else
                    break;
            }
            return sqrt;
        }

        private int binarySearch(int n) {
            int low = 0;
            int high = n;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (mid * mid <= n)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return high;
        }
    }
}
