import java.util.HashMap;

public class LengthOfLoopInLL {
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

        int bruteForce = solution.burteForce(head);
        System.out.println("Length of Cycle is : " + bruteForce);
        int optimalSol = solution.optimalSol(head);
        System.out.println("Length of Cycle is : " + optimalSol);
    }

    private static class Solution {
        private int burteForce(Node head) {
            int length = 0;
            HashMap<Node, Integer> map = new HashMap<>();
            int count = 1;
            while (head != null) {
                if (map.containsKey(head)) {
                    length = count - map.get(head);
                    break;
                } else {
                    map.put(head, count++);
                    head = head.next;
                }
            }
            return length;
        }

        private int optimalSol(Node head) {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    // loop exists
                    int len = 1;
                    fast = fast.next;
                    while (slow != fast) {
                        len++;
                        fast = fast.next;
                    }
                    return len;
                }
            }
            return 0;
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
