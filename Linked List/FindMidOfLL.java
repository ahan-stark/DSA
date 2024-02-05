public class FindMidOfLL {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 20, 30, 40, 50 };
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        int mid = 0;
        cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        mid = (count / 2);
        cur = head;
        for (int i = 0; i < mid; i++) {
            cur = cur.next;
        }
        System.out.println("The middle of Linked List : " + cur.data);

        // Tortoise and Hare method
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("The middle of Linked List : " + slow.data);
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}