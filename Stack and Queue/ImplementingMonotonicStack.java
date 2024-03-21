// A monotonic stack is a stack whose elements are monotonically increasing or decreasing.
// It contains all qualities that a typical stack has and its elements are all monotonic decreasing or increasing.

import java.util.Stack;

public class ImplementingMonotonicStack {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 5, 3, 12, 10 };
        MonotonicStack monotonicStack = new MonotonicStack();
        monotonicStack.creatMonotonicStack(arr);
        monotonicStack.printStack();
    }

    private static class MonotonicStack {
        Stack<Integer> stack;

        private void creatMonotonicStack(int arr[]) {
            stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                stack.push(arr[i]);
            }
        }

        private void printStack() {
            for (Integer val : stack) {
                System.out.println(val);
            }
        }
    }
}
