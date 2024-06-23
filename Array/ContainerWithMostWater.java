public class ContainerWithMostWater {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        FindContainer findContainer = new FindContainer();
        int bruteAns = findContainer.getMaxBruteForce(arr);
        System.out.println(bruteAns);
        int optimalSol = findContainer.getOptimalSol(arr);
        System.out.println(optimalSol);
    }

    private static class FindContainer {
        private int getMaxBruteForce(int arr[]) {
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int min = Math.min(arr[i], arr[j]);
                    ans = Math.max(ans, (j - i) * min);
                }
            }
            return ans;
        }

        private int getOptimalSol(int arr[]) {
            int ans = Integer.MIN_VALUE;
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                int min = Math.min(arr[start], arr[end]);
                ans = Math.max(ans, min * (end - start));
                if (arr[start] <= arr[end])
                    start = start + 1;
                else
                    end = end - 1;
            }
            return ans;
        }

    }
}
