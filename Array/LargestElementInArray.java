public class LargestElementInArray {
    static int arr[] = new int[] { 16, 21, 45, 85, 12 };

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Brute Force
        int sortArr[] = sol.sort(arr);
        System.out.println("Largest element using Brute Force :" + sortArr[arr.length - 1]);
        // optimal approach
        int largest = sol.largest(arr);
        System.out.println("Largest element using Optimal sol :" + largest);

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

        private int largest(int arr[]) {
            int lar = arr[0];
            for (int val : arr) {
                if (val > lar)
                    lar = val;
            }
            return lar;
        }
    }
}
