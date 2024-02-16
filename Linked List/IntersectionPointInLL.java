import java.util.HashMap;

public class IntersectionPointInLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node head1 = node1;
        node1.next = node2;
        node1.next.next = node3;
        node1.next.next.next = node4;
        node1.next.next.next.next = node5;
        Node head2 = node6;
        node6.next = node7;
        node6.next.next = node8;
        node6.next.next.next = node9;
        // this is the intersection
        node6.next.next.next.next = node4;
        // brute - force solution
        int bruteSol = solution.bruteForce(head1, head2);
        System.out.println("Brute Force : " + bruteSol);
        // optimal solution
        int optimalSol = solution.optimalSol(head1, head2);
        System.out.println("Optimal Solution : " + optimalSol);
    }

    private static class Solution {

        private Integer bruteForce(Node head1, Node head2) {
            HashMap<Node, Integer> map = new HashMap<>();
            Node cur1 = head1;
            Node cur2 = head2;
            while (cur1 != null) {
                map.put(cur1, 1);
                cur1 = cur1.next;
            }
            while (cur2 != null) {
                if (map.containsKey(cur2))
                    return cur2.data;
                cur2 = cur2.next;
            }
            return -1;
        }

        private Integer optimalSol(Node head1, Node head2) {
            // we keep traversing untill both are not met if any node reaches end then
            // if temp1 reaches head1 end we assign temp1 = head2 and traverse
            // if temp2 reaches head2 end we assign temp2 = head1 and traverse
            // if both becomes null its terminated or if both becomes equal its terminated
            // always when one node reaches end the other node will be at the distance
            // difference of both
            // so when second temp goes to other head they both will traversing together
            Node temp1 = head1;
            Node temp2 = head2;
            while (temp1 != temp2) {
                temp1 = temp1.next;
                temp2 = temp2.next;
                if (temp1 == temp2)
                    return temp1 != null ? temp1.data : -1;
                if (temp1 == null) {
                    temp1 = head2;
                }
                if (temp2 == null) {
                    temp2 = head1;
                }
            }
            return temp1 != null ? temp1.data : -1;
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
