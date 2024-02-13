public class DeleteMidOfLL {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 20, 30, 40, 50 };
        Solution solution = new Solution();
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        Node bruteForceNode = solution.bruteForce(head);
        System.out.println("Brute Force : ");
        while (bruteForceNode != null) {
            System.out.println(bruteForceNode.data);
            bruteForceNode = bruteForceNode.next;
        }
        cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        Node optimalNode = solution.optimalSol(head);
        System.out.println("Optimal Solution :");
        while (optimalNode != null) {
            System.out.println(optimalNode.data);
            optimalNode = optimalNode.next;
        }

    }

    private static class Solution {
        private Node bruteForce(Node head) {
            int len = 0;
            Node cur = head;
            while (cur != null) {
                len = len + 1;
                cur = cur.next;
            }
            cur = head;
            for (int i = 1; i < (len / 2); i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return head;
        }

        private Node optimalSol(Node head) {
            if (head == null || head.next == null)
                return null;
            Node fast = head, slow = head;
            fast = head.next.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return head;
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
