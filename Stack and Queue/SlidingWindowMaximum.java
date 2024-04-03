import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int arr[] = { 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        Solution solution = new Solution();
        int ans[] = solution.getMaxInSlidingWindow(arr, k);
        for (int val : ans) {
            System.out.println(val);
        }
    }

    private static class Solution {
        private int[] getMaxInSlidingWindow(int arr[], int k) {
            int res[] = new int[arr.length - k + 1];
            int ptr = 0;
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < arr.length; i++) {
                if (!deque.isEmpty() && deque.getFirst() == (i - k))
                    deque.removeFirst();
                while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.add(i);
                if (i >= k - 1) {
                    res[ptr++] = arr[deque.peek()];
                }
            }
            return res;
        }

    }
}
// store the Dequeue as Next greater elements in queue, if arr[i] is smaller
// insert it into queue, else if its greater , pop elements from last untill
// arr[i] is lesser than dequeue.getLast(), then for the sliding window we
// should consider after the k positions so insert the res[i] only if
// i >= k - 1, only from here the sliding window starts
// if dequeue.getFirst() is equal to i - k, that means the window has moved
// to new window, that means that dequeue.getFirst() is not needed, pop it
