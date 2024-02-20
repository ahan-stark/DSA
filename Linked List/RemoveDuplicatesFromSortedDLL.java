public class RemoveDuplicatesFromSortedDLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 6, 6 };
        DoubleNode head = new DoubleNode(arr[0]);
        DoubleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode temp = new DoubleNode(arr[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
        }
        DoubleNode solutionNode = solution.optimalApproach(head);
        while (solutionNode != null) {
            System.out.println(solutionNode.data);
            solutionNode = solutionNode.next;
        }
    }

    private static class Solution {
        private DoubleNode optimalApproach(DoubleNode head) {
            DoubleNode cur = head;
            DoubleNode nextNode = null;
            while (cur != null && cur.next != null) {
                nextNode = cur.next;
                if (nextNode != null && nextNode.data == cur.data) {
                    while (nextNode != null && nextNode.data == cur.data) {
                        nextNode = nextNode.next;
                    }
                    cur.next = nextNode;
                    if (nextNode != null)
                        nextNode.prev = cur;
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
