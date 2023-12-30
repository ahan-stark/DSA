public class MaximumProductSubArray {
    public static void main(String[] args) {
        int arr[] = { -3, 4, 3, 0, 0, 1, -2 };
        Solution solution = new Solution();
        int bruteSol = solution.bruteForce(arr);
        System.out.println("Brute Force Solution");
        System.out.println(bruteSol);
        int betterSol = solution.betterApproach(arr);
        System.out.println("Better Approach : ");
        System.out.println(betterSol);
        int optimalSol = solution.optimalApproach(arr);
        System.out.println("Optimal Solution : ");
        System.out.println(optimalSol);
    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            int maxProduct = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    int product = 1;
                    for (int k = i; k <= j; k++) {
                        product = product * arr[k];
                    }
                    maxProduct = Math.max(maxProduct, product);
                }
            }
            return maxProduct;
        }

        private int betterApproach(int[] arr) {
            int maxProduct = arr[0];
            for (int i = 0; i < arr.length; i++) {
                int product = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    maxProduct = Math.max(maxProduct, product);
                    product = product * arr[j];

                }
                maxProduct = Math.max(maxProduct, product);
            }
            return maxProduct;
        }

        private int optimalApproach(int arr[]) {
            // using prefix product and suffix product method
            int maxProduct = Integer.MIN_VALUE;
            int prefix = 1, suffix = 1;
            for (int i = 0; i < arr.length; i++) {
                if (prefix == 0)
                    prefix = 1;
                if (suffix == 0)
                    suffix = 1;
                prefix = prefix * arr[i];
                suffix = suffix * arr[arr.length - i - 1];
                maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
            }
            return maxProduct;
        }

    }
}
