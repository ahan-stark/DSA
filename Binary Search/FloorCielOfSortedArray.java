public class FloorCielOfSortedArray {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60 };
        int elem = 15;
        Solution solution = new Solution();
        int floor = solution.floor(arr, elem);
        System.out.println("Floor value is : " + floor);
        int ciel = solution.ciel(arr, elem);
        System.out.println("Ciel value is  : " + ciel);

    }

    private static class Solution {
        private int floor(int arr[], int elem) {
            int low = 0, high = arr.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] <= elem) {
                    ans = arr[mid];
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;
        }

        private int ciel(int arr[], int elem) {
            int low = 0, high = arr.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (elem <= arr[mid]) {
                    ans = arr[mid];
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }

    }
}
