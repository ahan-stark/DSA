import java.util.Scanner;

public class ImplementStackUsingLinkedList {
    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Implementing stack using queue");
            System.out.println("1 - Push");
            System.out.println("2 - Pop");
            System.out.println("3 - Print Stack");
            System.out.println("4 - Get top element");
            System.out.println("5 - Check if stack is empty");
            System.out.println("6 - Check size of stack");
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
                    System.out.println("Peek element : " + stack.getTop());
                    break;
                case 5:
                    System.out.println("Stack is empty ? : " + stack.isEmpty());
                    break;
                case 6:
                    System.out.println("Stack size  : " + stack.getSize());
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

    private static class StackUsingLL {
        Node top;
        int size = 0;

        StackUsingLL() {
            top = null;
        }

        private int getSize() {
            return size;
        }

        private boolean isEmpty() {
            return top == null ? true : false;
        }

        private void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            size++;
        }

        private int pop() {
            if (top == null) {
                System.out.println("Stack UnderFlow");
                System.exit(0);
            }
            int val = top.data;
            top = top.next;
            size--;
            return val;

        }

        private void printStack() {
            if (top == null) {
                System.out.println("Stack is empty!");
            } else {
                Node temp = top;
                while (temp != null) {
                    System.out.println(temp.data);
                    temp = temp.next;
                }
            }
        }

        private int getTop() {
            return top.data;
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
};
