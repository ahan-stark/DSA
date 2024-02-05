public class DeleteNodeFromDLL {
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
        // delete 3rd node
        deleteNode(head.next.next);
        cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    private static void deleteNode(DoubleNode node) {
        // we have to delete the given node
        // this question will not ask to del the first elem
        DoubleNode previousN = node.prev;
        DoubleNode nextN = node.next;
        // check if its the last node
        if (nextN == null) {
            previousN.next = null;
        } else {
            previousN.next = node.next;
            nextN.prev = node.prev;
            node.next = null;
            node.prev = null;
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
