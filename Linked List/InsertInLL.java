public class InsertInLL {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 20, 30, 40, 50, 60 };
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        Node temp = new Node(5);
        head = insertHead(temp, head);
        cur = head;
        System.out.println("Insert at head");
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        Node newTEmp = new Node(65);
        head = insertAtTail(newTEmp, head);
        cur = head;
        System.out.println("Insert at Tail");
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        int k = 3;
        Node kTemp = new Node(17);
        head = insertAtK(kTemp, head, k);
        cur = head;
        System.out.println("Insert at k pos");
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    private static Node insertHead(Node temp, Node head) {
        temp.next = head;
        head = temp;
        return head;
    }

    private static Node insertAtTail(Node temp, Node head) {
        Node cur = head;
        while (cur.next != null)
            cur = cur.next;
        cur.next = temp;
        return head;
    }

    private static Node insertAtK(Node temp, Node head, int k) {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            if (count == k - 1)
                break;
            cur = cur.next;
        }
        Node front = cur.next;
        cur.next = temp;
        temp.next = front;
        return head;

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
