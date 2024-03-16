import java.util.Scanner;

public class QueueImplementation {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Create Queue");
            System.out.println("2 - Enqueue");
            System.out.println("3 - Dequeue");
            System.out.println("4 - Print Queue");
            System.out.println("5 - Get top element");
            System.out.println("0 - Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter Queue Size : ");
                    int size = sc.nextInt();
                    queue.createQueue(size);
                    break;
                case 2:
                    System.out.println("Enter the element to be inserted");
                    int ele = sc.nextInt();
                    queue.enqueue(ele);
                    break;
                case 3:
                    System.out.println("Dequeue : " + queue.dequeue());
                    break;
                case 4:
                    queue.printQueue();
                    break;
                case 5:
                    System.out.println("Peek element : " + queue.getPeek());
                case 0:
                    System.out.println("Exited successfully!");
                    System.exit(0);
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    private static class Queue {
        int arr[];
        int start = -1;
        int end = 0;
        int curSize = 0;

        private void createQueue(int size) {
            arr = new int[size];
        }

        private void enqueue(int val) {
            if (curSize >= arr.length) {
                System.out.println("Queue is full!");
                System.exit(0);
            }
            start++;
            start = start % arr.length;
            arr[start] = val;
            curSize++;
        }

        private int dequeue() {
            if (start == -1 || curSize == 0) {
                System.out.println("Queue is Empty");
                System.exit(0);
            }
            curSize--;
            int dequeue = arr[end];
            end++;
            end = end % arr.length;
            return dequeue;
        }

        private void printQueue() {
            int i = end;
            while (i != start) {
                System.out.println(arr[i]);
                i++;
                i = i % arr.length;
            }
            System.out.println(arr[i]);

        }

        private int getPeek() {
            return arr[start];
        }

    }
}
