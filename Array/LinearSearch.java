public class LinearSearch {
    static int arr[] = new int[] { 1, 5, 6, 8, 9, 3, 4 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        int pos = solution.search(arr, 9);
        System.out.println("The elemnt 9 is found at " + pos);
    }

    private static class Solution {
        private int search(int arr[], int elem) {
            int pos = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == elem) {
                    pos = i;
                    break;
                }
            }
            return pos;
        }
    }
}
