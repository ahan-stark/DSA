// The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
public class Add2NumsInLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head1 = new Node(7);
        head1.next = new Node(4);
        head1.next.next = new Node(5);
        Node head2 = new Node(8);
        head2.next = new Node(4);
        head2.next.next = new Node(9);
        Node sumNode = solution.optimalSol(head1, head2);
        while (sumNode != null) {
            System.out.println(sumNode.data);
            sumNode = sumNode.next;
        }
    }

    private static class Solution {

        public Node optimalSol(Add2NumsInLL.Node head1, Add2NumsInLL.Node head2) {
            Node sumNode = new Node(-1);
            Node cur = sumNode;
            int carry = 0;
            while (head1 != null || head2 != null) {
                int val1 = head1 != null ? head1.data : 0;
                int val2 = head2 != null ? head2.data : 0;
                int sum = val1 + val2 + carry;
                cur.next = new Node(sum % 10);
                carry = sum / 10;
                cur = cur.next;
                if (head1 != null)
                    head1 = head1.next;
                if (head2 != null)
                    head2 = head2.next;
            }
            if (carry != 0) {
                cur.next = new Node(carry);
            }
            return sumNode.next;
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
