import java.util.Scanner;

public class StackImplementation {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        System.out.println("Stack Implementation using arrays : ");
        while (true) {
            System.out.println("1 - Create stack");
            System.out.println("2 - Insert into stack");
            System.out.println("3 - Delete from stack");
            System.out.println("4 - Print stack");
            System.out.println("5 - Get top element");
            System.out.println("0 - Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("enter stack size : ");
                    int size = sc.nextInt();
                    stack.createStack(size);
                    break;
                case 2:
                    System.out.println("enter element to insert : ");
                    int ele = sc.nextInt();
                    stack.push(ele);
                    break;
                case 3:
                    System.out.println("element popped : " + stack.pop());
                    break;
                case 4:
                    stack.printStack();
                    break;
                case 5:
                    stack.getPeek();
                    break;
                case 0:
                    System.out.println("exited!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("try again!");
                    break;
            }

        }
    }

    private static class Stack {
        int top = -1;
        int arr[];

        private void createStack(int size) {
            arr = new int[size];
        }

        private void push(int ele) {
            if (top >= arr.length - 1) {
                System.out.println("Stack over flow");
                System.exit(0);
            }
            arr[++top] = ele;
        }

        private int pop() {
            if (top == -1) {
                System.out.println("Stack under flow!");
                System.exit(0);
            }
            return arr[top--];
        }

        private void printStack() {
            for (int i = 0; i <= top; i++) {
                System.out.println(arr[i]);
            }
        }

        private void getPeek() {
            System.out.println("peek element : " + arr[top]);
        }

    }
}