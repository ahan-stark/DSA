public class DelNthNodeFromLast {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[] { 10, 20, 30, 40, 50, 60 };
        int n = 3;
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        Node bruteForceNode = solution.bruteForce(head, n);
        System.out.println("Brute Force : ");
        while (bruteForceNode != null) {
            System.out.println(bruteForceNode.data);
            bruteForceNode = bruteForceNode.next;
        }
        head = new Node(arr[0]);
        cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        Node optimalNode = solution.optimalSolution(head, n);
        System.out.println("Optimal Solution : ");
        while (optimalNode != null) {
            System.out.println(optimalNode.data);
            optimalNode = optimalNode.next;
        }

    }

    private static class Solution {
        private Node bruteForce(Node head, int n) {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            temp = head;
            for (int i = 1; i < count - n; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }

        private Node optimalSolution(Node head, int n) {
            // use 2 pointers fast and slow
            // move fast to first n times, then move both fast and slow untill
            // fast.next becomes null
            Node fast = head;
            Node slow = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
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
