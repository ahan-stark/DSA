import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Implementing stack using queue");
            System.out.println("1 - Push");
            System.out.println("2 - Pop");
            System.out.println("3 - Print Stack");
            System.out.println("4 - Get top element");
            System.out.println("5 - Check if stack is empty");
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
                    stack.printStack();
                    break;
                case 4:
                    System.out.println("Peek element : " + stack.top());
                    break;
                case 5:
                    System.out.println("Stack is empty ? : " + stack.empty());
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

    private static class StackUsingQueue {
        Queue<Integer> q1;
        Queue<Integer> q2;

        private StackUsingQueue() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        private void push(int x) {
            if (q1.isEmpty()) {
                q1.add(x);
            } else {
                q2.add(x);
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }

        private int pop() {
            if (q1.isEmpty()) {
                return -1;
            }
            return q1.remove();
        }

        private int top() {
            if (q1.isEmpty()) {
                return -1;
            }
            return q1.peek();
        }

        private void printStack() {
            for (int ele : q1) {
                System.out.println(ele);
            }
        }

        private boolean empty() {
            return q1.isEmpty();
        }
    }
}
