public class Add1toLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        Node bruteForce = solution.bruteForce(head);
        System.out.println("Brute Force : ");
        while (bruteForce != null) {
            System.out.println(bruteForce.data);
            bruteForce = bruteForce.next;
        }
        head = null;
        head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        Node optimalSol = solution.optimalSol(head);
        System.out.println("Optimal Solution : ");
        while (optimalSol != null) {
            System.out.println(optimalSol.data);
            optimalSol = optimalSol.next;
        }
    }

    private static class Solution {
        private Node bruteForce(Node head) {
            // adding 1 so keep it in carry
            int carry = 1;
            Node reverseHead = reverse(head);
            Node cur = reverseHead;
            while (cur != null) {
                cur.data = cur.data + carry;
                // if we get digit that is less than 10 so carry will 0 so no point of adding
                // other values with 0, it will be same
                if (cur.data < 10) {
                    carry = 0;
                    break;
                }
                cur.data = 0;
                carry = 1;
                cur = cur.next;
            }
            // if carry is still 1 that means extra one digit has to be added that is 1
            if (carry == 1) {
                Node newHead = new Node(1);
                Node head1 = reverse(reverseHead);
                newHead.next = head1;
                return newHead;
            }
            return reverse(reverseHead);
        }

        private Node optimalSol(Node head) {
            int carry = checkCarry(head);
            if (carry == 1) {
                Node newNode = new Node(1);
                newNode.next = head;
                return newNode;
            }
            return head;
        }

        private int checkCarry(Node head) {
            if (head == null)
                // assign the carry at last for adding 1
                return 1;
            Node temp = head;
            int carry = checkCarry(head.next);
            temp.data = temp.data + carry;
            if (temp.data >= 10) {
                temp.data = 0;
                return 1;
            } else
                return 0;
        }

        private Node reverse(Node head) {
            Node cur = head;
            Node next = null, prev = null;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
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
