public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        reverse(arr, 0, arr.length - 1);
        for (int val : arr) {
            System.out.println(val);
        }
    }

    private static void reverse(int[] arr, int i, int j) {
        if (i >= j)
            return;
        reverse(arr, i + 1, j - 1);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
