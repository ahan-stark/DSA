public class MergeNodesInBetweenZeros {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[] { 0, 3, 1, 0, 4, 5, 2, 0 };
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        Node betterApproachNode = solution.betterApproach(head);
        while (betterApproachNode != null) {
            System.out.println(betterApproachNode.data);
            betterApproachNode = betterApproachNode.next;
        }
    }

    private static class Solution {
        private Node betterApproach(Node head) {
            Node newNode = new Node(-1);
            Node newHead = newNode;
            Node cur = head;
            cur = cur.next;
            while (cur.next != null) {
                if (cur.data != 0) {
                    int sum = cur.data;
                    while (cur.next.data != 0) {
                        cur = cur.next;
                        sum = sum + cur.data;
                    }
                    newNode.next = new Node(sum);
                    newNode = newNode.next;
                }
                cur = cur.next;
            }
            return newHead.next;
        }

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
