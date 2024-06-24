public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        MinSizeSubArr subArr = new MinSizeSubArr();
        int minLen = subArr.getMinSubArr(arr, target);
        System.out.println(minLen);

    }

    private static class MinSizeSubArr {
        private int getMinSubArr(int arr[], int target) {
            int minLen = Integer.MAX_VALUE;
            int sum = arr[0];
            int i = 0, j = 0;
            while (j < arr.length && i <= j) {
                if (sum < target) {
                    j = j + 1;
                    if(j < arr.length)
                    sum = sum + arr[j];
                } else if (sum >= target) {
                    minLen = Math.min(minLen, ((j - i) + 1));
                    sum = sum - arr[i];
                    i = i + 1;
                }
            }

            return minLen != Integer.MAX_VALUE ? minLen : 0;
        }

    }
}
