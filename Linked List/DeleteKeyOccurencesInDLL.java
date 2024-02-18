public class DeleteKeyOccurencesInDLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 70, 20, 30, 10, 40, 10, 30, 10 };
        int key = 10;
        DoubleNode head = new DoubleNode(arr[0]);
        DoubleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode temp = new DoubleNode(arr[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
        }
        DoubleNode optimalNode = solution.optimalSol(head, key);
        while (optimalNode != null) {
            System.out.println(optimalNode.data);
            optimalNode = optimalNode.next;
        }
    }

    private static class Solution {
        private DoubleNode optimalSol(DoubleNode head, int key) {
            DoubleNode cur = head;
            DoubleNode prevNode = null;
            DoubleNode nextNode = null;
            while (cur != null) {
                if (cur.data == key) {
                    // check if the key is in head,
                    // if its in head move head one step and then modify
                    if (head == cur) {
                        head = head.next;
                    }
                    prevNode = cur.prev;
                    nextNode = cur.next;
                    if (prevNode != null) {
                        prevNode.next = nextNode;
                    }
                    if (nextNode != null) {
                        nextNode.prev = prevNode;
                    }
                }
                cur = cur.next;
            }
            return head;
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
