import java.util.Scanner;
import java.util.Stack;

public class ImplementMinStack {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Implementing stack using LinkedList");
            System.out.println("1 - Push");
            System.out.println("2 - Pop");
            System.out.println("3 - Get top element");
            System.out.println("4 - Get Min");
            System.out.println("0 - Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter the element to be inserted");
                    int ele = sc.nextInt();
                    stack.push(ele);
                    break;
                case 2:
                    System.out.println("Popped Element  : " + stack.pop());
                    break;
                case 3:
                    System.out.println("Peek element : " + stack.top());
                    break;
                case 4:
                    System.out.println("Current Min : " + stack.getMin());
                    break;
                case 0:
                    System.out.println("Exited successfully!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input!");
            }

        }
    }

    private static class MinStack {
        Stack<Integer> st = new Stack<>();
        int min;

        public MinStack() {
            min = Integer.MAX_VALUE;
        }

        private void push(int val) {
            if (st.isEmpty()) {
                min = val;
                st.push(val);
            } else {
                if (val < min) {
                    st.push(2 * val - min);
                    min = val;
                } else {
                    st.push(val);
                }
            }
        }

        private int pop() {
            if (st.isEmpty()) {
                System.out.println("Stack Underflow!");
                System.exit(0);
            }

            int val = st.pop();
            if (val < min) {
                int newVal = min;
                min = 2 * min - val;
                return newVal;
            }
            return val;
        }

        private int top() {
            int val = st.peek();
            if (val < min) {
                return min;
            }
            return val;
        }

        private int getMin() {
            return min;
        }
    }
}
// this intution is like if we get any element that is less than min , the min
// will be that value and we dont insert directly, we modify the vale as (2 *
// val - min) ...so while popping if that stack.peek() is less than cur min ,
// then we get to knwo its the modified value, so the dur pop will the min as
// that was element we modified and cur min will be (2 * min - st.peek())



// we can also us method like inserting stack with objects containing currnet
// element with cur min for all the elements
// at each elemet wit will have mapped cur min