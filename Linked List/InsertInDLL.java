public class InsertInDLL {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        DoubleNode head = new DoubleNode(arr[0]);
        DoubleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode temp = new DoubleNode(arr[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
        }
        head = insertAtHead(head, new DoubleNode(5));
        cur = head;
        System.out.println("Inserted at head");
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        head = insertAtTail(head, new DoubleNode(65));
        cur = head;
        System.out.println("Inserted at tail");
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        head = insertAtKPos(head, new DoubleNode(15), 3);
        cur = head;
        System.out.println("Inserted at k pos");
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        cur = head;
        // Backward traversal
        while (cur.next != null)
            cur = cur.next;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.prev;
        }
    }

    private static DoubleNode insertAtHead(DoubleNode head, DoubleNode temp) {
        DoubleNode cur = head;
        cur.prev = temp;
        temp.next = cur;
        return head.prev;
    }

    private static DoubleNode insertAtTail(DoubleNode head, DoubleNode temp) {
        DoubleNode cur = head;
        while (cur.next != null)
            cur = cur.next;
        cur.next = temp;
        temp.prev = cur;
        return head;
    }

    private static DoubleNode insertAtKPos(DoubleNode head, DoubleNode temp, int k) {
        DoubleNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            if (count == k)
                break;
            cur = cur.next;
        }
        DoubleNode previousN = cur.prev;
        previousN.next = temp;
        cur.prev = temp;
        temp.next = cur;
        temp.prev = previousN;
        return head;
    }

    private static class DoubleNode {
        int data;
        DoubleNode prev;
        DoubleNode next;

        DoubleNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
