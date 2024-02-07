import java.util.HashMap;

public class DetectLoopInLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;
        boolean bruteForce = solution.bruteForce(head);
        System.out.println("Cycle Exists in Linked List = " + bruteForce);
        boolean optimalSol = solution.optimalSolution(head);
        System.out.println("Cycle Exists in Linked List = " + optimalSol);
    }

    private static class Solution {
        private boolean bruteForce(Node cur) {
            HashMap<Node, Integer> map = new HashMap<>();
            while (cur != null) {
                if (map.containsKey(cur))
                    return true;
                else {
                    map.put(cur, 1);
                    cur = cur.next;
                }
            }
            return false;
        }

        private boolean optimalSolution(Node cur) {
            Node fast = cur;
            Node slow = cur;
            while (fast.next != null || fast != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)
                    return true;
            }
            return false;
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
