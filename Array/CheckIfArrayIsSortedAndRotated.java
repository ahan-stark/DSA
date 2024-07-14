public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 2 };
        Solution solution = new Solution();
        boolean res = solution.checkArray(arr);
        System.out.println(res);
    }

    private static class Solution {
        private boolean checkArray(int arr[]) {
            int count = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    count++;
                }
            }
            if (arr[arr.length - 1] > arr[0])
                count++;
            return count <= 1 ? true : false;
        }
    }
}
// if the the prev element is greater than cur elem that means it is a
// violation..if sorted and rotated it can have max of 1 violation if not its
// not sorted rotated array