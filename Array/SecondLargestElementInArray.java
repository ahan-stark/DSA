public class SecondLargestElementInArray {
    static int[] arr = new int[] { 1, 2, 4, 7, 7, 5 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        int[] sortArr = solution.sort(arr);
        int val = solution.bruteForce(sortArr);
        System.out.println("Second Largest element using Brute Force :" + val);
        // Better Way
        System.out.println("Better solution : " + solution.betterSol(arr));
        // Optimal Solution
        System.out.println("Optimal solution : " + solution.optimalSolution(arr));

    }

    private static class Solution {
        private int[] sort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[i]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            return arr;
        }

        private int bruteForce(int[] arr) {
            int largest = arr[arr.length - 1];
            int secondLargest = 0;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] != largest) {
                    secondLargest = arr[i];
                    break;
                }
            }
            return secondLargest;
        }

        private int betterSol(int[] arr) {
            int largest = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > largest)
                    largest = arr[i];
            }
            int secondLargest = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > secondLargest && arr[i] < largest) {
                    secondLargest = arr[i];
                }
            }
            return secondLargest;

        }

        private int optimalSolution(int arr[]) {
            int largest = arr[0];
            int secondLargest = Integer.MIN_VALUE;
            for (int val : arr) {
                if (val > largest) {
                    secondLargest = largest;
                    largest = val;
                }
            }
            return secondLargest;
        }
    }
}
