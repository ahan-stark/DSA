public class DeleteHeadFromDLL {
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
        DoubleNode prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
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
