import java.util.HashMap;

public class GetTheStartingCycle {
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
        Node bruteForce = solution.bruteForce(head);
        System.out.println("Starting Node of Cycle : " + bruteForce.data);
        Node optimalSol = solution.optimalSol(head);
        System.out.println("Starting Node of Cycle : " + optimalSol.data);

    }

    private static class Solution {
        private Node bruteForce(Node head) {
            HashMap<Node, Integer> map = new HashMap<>();
            while (head != null) {
                if (map.containsKey(head))
                    return head;
                else {
                    map.put(head, 1);
                    head = head.next;
                }
            }
            return null;
        }

        private Node optimalSol(Node head) {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                // if they collide take the slow from start and fast from collision and move
                // again untill they meet each other, the point of meeting is starting of cycle
                if (fast == slow) {
                    slow = head;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }
            return null;
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
