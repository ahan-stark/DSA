public class NthRootOfM {
    public static void main(String[] args) {
        // 1*1*1=1
        // 2*2*2=8
        // 3*3*3=27
        Solution solution = new Solution();
        int n = 3, m = 27;
        int binarySearch = solution.binarySearch(n, m);
        System.out.println("Nth root of M is : " + binarySearch);
    }

    private static class Solution {
        private int binarySearch(int n, int m) {
            int low = 1, high = m;
            while (low <= high) {
                int mid = (low + high) / 2;
                // check if mid to power n matches the m value, if matched it will return 1
                if (check(mid, n, m) == 1)
                    return mid;
                if (check(mid, n, m) == 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return -1;
        }

        private int check(int mid, int n, int m) {
            int ans = 1;
            for (int i = 1; i <= n; i++) {
                ans = ans * mid;
                // if the number is getting exceded from the m value just return 0
                if (ans > m) {
                    return 0;
                }
            }
            if (ans == m)
                return 1;
            else
                return 2;
        }

    }
}
