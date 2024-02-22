public class RotateLLByKtimes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[] { 1, 2, 3, 4, 5 };
        int k = 3;
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        cur = head;
        Node rotatedNode = solution.optimalSol(head, k);
        while (rotatedNode != null) {
            System.out.println(rotatedNode.data);
            rotatedNode = rotatedNode.next;
        }
    }

    private static class Solution {
        private Node optimalSol(Node head, int k) {
            int len = 1;
            Node cur = head;
            Node kthNode = null;
            while (cur.next != null) {
                len = len + 1;
                cur = cur.next;
            }
            // if the given k is larger than len , we find modules and traverse
            k = k % len;
            if (k == len)
                return head;
            // make last connected to first
            cur.next = head;
            kthNode = findKthNode(head, len - k);
            // make kthNode.next as the head and point kthNode.next = null
            head = kthNode.next;
            kthNode.next = null;
            return head;
        }

        private Node findKthNode(Node temp, int k) {
            int count = 1;
            while (temp != null) {
                if (count == k)
                    return temp;
                count++;
                temp = temp.next;
            }
            return temp;
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
