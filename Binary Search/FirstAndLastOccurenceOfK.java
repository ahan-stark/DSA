//array will be sorted
public class FirstAndLastOccurenceOfK {
    public static void main(String[] args) {
        int arr[] = { 5, 7, 7, 8, 8, 10 };
        int elem = 8;
        Solution solution = new Solution();
        // brute Force linear search
        int bruteForce[] = solution.bruteForce(arr, elem);
        System.out.println("Brute Force = " + " first : " + bruteForce[0] + " second : " + bruteForce[1]);
        // better approach using lower bound and upper bound
        int betterApproach[] = solution.betterApproach(arr, elem);
        System.out.println("Better  Approach = " + " first : " + betterApproach[0] + " second : " + betterApproach[1]);
        // optimal approach
        int optimalApproach[] = solution.optimalApproach(arr, elem);
        System.out.println("Optimal Approach = " + "first : " + optimalApproach[0] + " second : " + optimalApproach[1]);
    }

    private static class Solution {
        private int[] bruteForce(int arr[], int elem) {
            int ans[] = new int[2];
            int first = -1, last = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == elem) {
                    if (first == -1)
                        first = i;
                    last = i;

                }
            }
            ans[0] = first;
            ans[1] = last;
            return ans;
        }

        private int[] betterApproach(int arr[], int elem) {
            int lowB = lowerBound(arr, elem);
            if (lowB == arr.length || arr[lowB] != elem)
                return new int[] { -1, -1 };
            // hence the upper bound points to the next element add - 1;
            int upperB = upperBound(arr, elem);
            return new int[] { lowB, upperB - 1 };
        }

        private int[] optimalApproach(int arr[], int elem) {
            int lowIndex = arr.length;
            int highIndex = arr.length;
            int low = 0, high = arr.length - 1;
            // get the lowIndex by finding the element and going extreme left
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == elem) {
                    lowIndex = mid;
                    high = mid - 1;
                } else if (arr[mid] < elem) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // get the highIndex by finding the element and going extreme right
            low = 0;
            high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == elem) {
                    highIndex = mid;
                    low = mid + 1;
                } else if (arr[mid] < elem) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return new int[] { lowIndex, highIndex };
        }
    }

    private static int lowerBound(int arr[], int elem) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= elem) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int arr[], int elem) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > elem) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
