import java.util.Scanner;
import java.util.Stack;

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Implementing queue using stack");
            System.out.println("1 - Enqueue");
            System.out.println("2 - Dequeue");
            System.out.println("3 - Print Queue");
            System.out.println("4 - Check if stack is empty");
            System.out.println("0 - Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter the element to be inserted");
                    int ele = sc.nextInt();
                    queue.enqueue(ele);
                    break;
                case 2:
                    System.out.println("Popped Element  : " + queue.dequeue());
                    break;
                case 3:
                    queue.printQueue();
                    break;
                case 4:
                    System.out.println("Queue is empty ? : " + queue.empty());
                    break;
                case 5:
                    System.out.println("Queue peek element : " + queue.peek());
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

    private static class QueueUsingStack {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        QueueUsingStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void enqueue(int ele) {
            if (stack1.isEmpty()) {
                stack1.push(ele);
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                stack1.push(ele);
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
        }

        public int dequeue() {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                return stack1.pop();
            }
        }

        public int peek() {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                return stack1.peek();
            }
        }

        private void printQueue() {
            for (Integer val : stack1) {
                System.out.println(val);
            }
        }

        public boolean empty() {
            return stack1.isEmpty();
        }

    }
}
