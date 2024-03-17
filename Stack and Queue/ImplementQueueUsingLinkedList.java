import java.util.Scanner;

public class ImplementQueueUsingLinkedList {
    public static void main(String[] args) {
        QueueUsingLL queue = new QueueUsingLL();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Implementing queue using LinkedList");
            System.out.println("1 - Enqueue");
            System.out.println("2 - Dequeue");
            System.out.println("3 - Print queue");
            System.out.println("4 - Get top element");
            System.out.println("5 - Check if queue is empty");
            System.out.println("6 - Check size of queue");
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
                    System.out.println("Peek element : " + queue.getTop());
                    break;
                case 5:
                    System.out.println("Stack is empty ? : " + queue.isEmpty());
                    break;
                case 6:
                    System.out.println("Stack size  : " + queue.getSize());
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

    private static class QueueUsingLL {
        Node start;
        Node end;
        int size = 0;

        private void enqueue(int data) {
            if (size == 0) {
                Node newNode = new Node(data);
                start = newNode;
                end = start;
                size = size + 1;
            } else {
                Node newNode = new Node(data);
                start.next = newNode;
                start = start.next;
                size = size + 1;
            }
        }

        private int dequeue() {
            if (end == null) {
                return -1;
            } else {
                int val = end.data;
                end = end.next;
                return val;
            }
        }

        private void printQueue() {
            if (end == null) {
                System.out.println("Queue is Empty");
            } else {
                Node temp = end;
                while (temp != start) {
                    System.out.println(temp.data);
                    temp = temp.next;
                }
                System.out.println(temp.data);
            }
        }

        private boolean isEmpty() {
            return size == 0 ? true : false;

        }

        private int getSize() {
            return size;
        }

        private int getTop() {
            return start.data;
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
