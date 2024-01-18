// Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
// Allocate books in such a way that:

// Each student gets at least one book.
// Each book should be allocated to only one student.
// Book allocation should be in a contiguous manner.
// You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1

//our goal is to allocate all the boks to students and only continuous books can be allocate to students
public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        int arr[] = { 25, 46, 28, 49, 24 };
        int totStudents = 4;
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr, totStudents);
        System.out.println("Brute Force : " + bruteForce);
        int binarySearch = solution.binarySearch(arr, totStudents);
        System.out.println("Binary search : " + binarySearch);
    }

    private static class Solution {
        private int bruteForce(int arr[], int students) {
            // to allocate each book atleast to one student he should be able to recieve
            // that so min should be the max in array, max will be the sum of array such
            // that all the book can be held by one student
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int ele : arr) {
                max = Math.max(max, ele);
                sum = sum + ele;
            }
            for (int i = max; i <= sum; i++) {
                if (calculateTotalStudents(arr, i) == students) {
                    return i;
                }
            }
            return -1;
        }

        private int binarySearch(int arr[], int students) {
            // binary search works in the same way
            // we will check with low and high , if we consider the high the number of
            // students holding capacity wll be very high so one student will be able to
            // hold all, so if we get val of mid less students we have to decrease the mid ,
            // if we get more no. of students than given condition that means we have to
            // move the low
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int ele : arr) {
                max = Math.max(max, ele);
                sum = sum + ele;
            }
            int low = max;
            int high = sum;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (calculateTotalStudents(arr, mid) > students)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return low;
        }

        private int calculateTotalStudents(int[] arr, int i) {
            int totStudents = 1;
            int sumOfPages = 0;
            for (int j = 0; j < arr.length; j++) {
                if (sumOfPages + arr[j] <= i) {
                    sumOfPages = sumOfPages + arr[j];
                } else {
                    totStudents++;
                    sumOfPages = arr[j];
                }
            }
            return totStudents;
        }
    }
}
