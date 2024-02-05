public class DeleteKthElemFromDLL {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int k = 3;
        DoubleNode head = new DoubleNode(arr[0]);
        DoubleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode temp = new DoubleNode(arr[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
        }
        cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            if (count == k)
                break;
            cur = cur.next;
        }
        DoubleNode previousNode = cur.prev;
        DoubleNode nextNode = cur.next;
        // single element
        if (previousNode == null && nextNode == null) {
            cur = null;
        }
        // first to be deleted
        else if (previousNode == null) {
            DoubleNode previous = head;
            head = head.next;
            head.prev = null;
            previous.next = null;
        }
        // last to be deleted
        else if (nextNode == null) {
            DoubleNode previous = cur.prev;
            previous.next = null;
            cur.prev = null;
        } else {
            DoubleNode previous = cur.prev;
            DoubleNode nextN = cur.next;
            previous.next = nextN;
            nextN.prev = previous;
        }
        // traversing
        cur = head;
        System.out.println("Forward Traversal");
        while (cur.next != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        System.out.println(cur.data);
        System.out.println("Backward Traversal");
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.prev;
        }
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
