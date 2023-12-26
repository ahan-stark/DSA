import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[] = { 1, 4, 8, 10 };
        int arr2[] = { 2, 3, 9 };
        Solution solution = new Solution();
        // Brute Force solution
        solution.bruteForce(arr1, arr2);
        // Optimal Solution
        solution.optimalSolution(arr1, arr2);
    }

    private static class Solution {
        private void bruteForce(int arr1[], int arr2[]) {
            int left = 0;
            int right = 0;
            int i = 0;
            int newArr[] = new int[arr1.length + arr2.length];
            while (left < arr1.length && right < arr2.length) {
                if (arr1[left] <= arr2[right]) {
                    newArr[i++] = arr1[left];
                    left = left + 1;
                } else if (arr1[left] > arr2[right]) {
                    newArr[i++] = arr2[right];
                    right = right + 1;
                }
            }
            // add remaining directly
            while (left < arr1.length) {
                newArr[i++] = arr1[left];
                left = left + 1;
            }
            while (right < arr2.length) {
                newArr[i++] = arr2[right];
                right = right + 1;
            }
            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = newArr[j];
            }
            int m = 0;
            for (int k = arr1.length; k < newArr.length; k++) {
                arr2[m++] = newArr[k];
            }
            // print both array
            System.out.println("Brute Force Solution : ");
            System.out.println("Array 1 :");
            for (int ele : arr1) {
                System.out.println(ele);
            }
            System.out.println("Array 2 :");
            for (int ele : arr2) {
                System.out.println(ele);
            }
        }

        private void optimalSolution(int arr1[], int arr2[]) {
            // Thus the arrays are already in sorted form
            // comapare the last element of the array1 and first elemenent of array2
            // if array1 elem is greater than array2 elem, then swap it, if its greater than
            // break out
            int leftptr = arr1.length - 1;
            int rightptr = 0;
            while (leftptr >= 0 && rightptr < arr2.length) {
                if (arr1[leftptr] > arr2[rightptr]) {
                    int temp = arr1[leftptr];
                    arr1[leftptr] = arr2[rightptr];
                    arr2[rightptr] = temp;
                    leftptr = leftptr - 1;
                    rightptr = rightptr + 1;
                } else {
                    break;
                }
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            System.out.println("Optimal Solution");
            System.out.println("Array 1 :");
            for (int ele : arr1) {
                System.out.println(ele);
            }
            System.out.println("Array 2 :");
            for (int ele : arr2) {
                System.out.println(ele);
            }
        }
    }
}
