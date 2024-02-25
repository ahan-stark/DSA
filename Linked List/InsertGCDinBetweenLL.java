public class InsertGCDinBetweenLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[] { 18, 6, 10, 3};
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        Node betterApproach = solution.betterApproach(head);
        while (betterApproach != null) {
            System.out.println(betterApproach.data);
            betterApproach = betterApproach.next;
        }

    }

    private static class Solution {
        private Node betterApproach(Node head) {
            if(head == null || head.next == null)
                return head;
            Node cur = head;
            Node prev = cur;
            cur = cur.next;
            while (cur != null) {
                int gcd = findGCD(prev.data, cur.data);
                Node newNode = new Node(gcd);
                prev.next = newNode;
                newNode.next = cur;
                prev = cur;
                cur = cur.next;
            }
            return head;
        }

        private int findGCD(int num1, int num2) {
            int gcd = 1;
            for (int i = 2; i <= Math.min(num1, num2); i++) {
                if (num1 % i == 0 && num2 % i == 0)
                    gcd = i;
            }
            return gcd;
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
