public class Sort0s1s2sInLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[] { 2, 0, 0, 1, 2, 1, 1, 0, 2, 1, 0, 1, 1 };
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
        head = new Node(arr[0]);
        cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        System.out.println("Optimal Solution : ");
        Node optimalNode = solution.optimalSol(head);
        while (optimalNode != null) {
            System.out.println(optimalNode.data);
            optimalNode = optimalNode.next;
        }
    }

    private static class Solution {
        private Node bruteForce(Node head) {
            Node cur = head;
            int count0 = 0, count1 = 0;
            while (cur != null) {
                if (cur.data == 0)
                    count0++;
                else if (cur.data == 1)
                    count1++;
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                if (count0 > 0) {
                    cur.data = 0;
                    count0--;
                } else if (count1 > 0) {
                    cur.data = 1;
                    count1--;
                } else {
                    cur.data = 2;
                }
                cur = cur.next;
            }
            return head;
        }

        private Node optimalSol(Node head) {
            Node zeroNode = new Node(-1);
            Node oneNode = new Node(-1);
            Node twoNode = new Node(-1);
            Node zeroHead = zeroNode;
            Node oneHead = oneNode;
            Node twoHead = twoNode;
            Node cur = head;
            while (cur != null) {
                if (cur.data == 0) {
                    zeroNode.next = cur;
                    zeroNode = zeroNode.next;
                } else if (cur.data == 1) {
                    oneNode.next = cur;
                    oneNode = oneNode.next;
                } else {
                    twoNode.next = cur;
                    twoNode = twoNode.next;
                }
                cur = cur.next;
            }
            twoNode.next = null;
            zeroNode.next = oneHead.next != null ? oneHead.next : twoHead.next;
            oneNode.next = twoHead.next;
            return zeroHead.next;
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
