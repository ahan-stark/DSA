public class MoveAllZeroToLast {
    static int arr[] = new int[] { 1, 0, 4, 5, 0, 6, 0, 7 };

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Brute Force
        System.out.println("Brute Force");
        int newArr[] = solution.bruteForce(arr);
        for (int val : newArr) {
            System.out.println(val);
        }
        // optimal solution
        System.out.println("Optimal Solution");
        int optArr[] = solution.optimal(arr);
        for (int val : optArr) {
            System.out.println(val);
        }

    }

    private static class Solution {
        private int[] bruteForce(int arr[]) {
            int temp[] = new int[arr.length];
            int index = 0;
            for (int element : arr) {
                if (element != 0) {
                    temp[index] = element;
                    index++;
                }
            }
            for (int i = index; i < temp.length; i++) {
                temp[i] = 0;
            }
            return temp;
        }

        private int[] optimal(int arr[]) {
            int j = 0, i = 0;
            while (arr[i] != 0) {
                i++;
            }
            j = i + 1;
            while (j < arr.length) {
                if (arr[j] != 0) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            return arr;
        }
    }
}
