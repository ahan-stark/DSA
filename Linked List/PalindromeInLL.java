import java.util.Stack;

public class PalindromeInLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[] { 10, 20, 30, 30, 20, 10, };
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        boolean bruteForce = solution.bruteforce(head);
        System.out.println("Brute Force of palindrome : " + bruteForce);
        boolean optimalSol = solution.optimalSol(head);
        System.out.println("Optimal Solution of palindrome :  " + optimalSol);
    }

    private static class Solution {
        private boolean bruteforce(Node head) {
            Stack<Integer> stack = new Stack<>();
            Node cur = head;
            while (cur != null) {
                stack.push(cur.data);
                cur = cur.next;
            }
            while (head != null) {
                if (head.data != stack.pop()) {
                    return false;
                }
                head = head.next;
            }
            return true;
        }

        private boolean optimalSol(Node head) {
            Node slow = head;
            Node fast = head;
            Node reverseNode = null;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // if fast will point to null that means it has even nodes
            if (fast == null) {
                reverseNode = reverse(slow);
            } else {
                reverseNode = reverse(slow.next);
            }
            while (reverseNode != null) {
                if (reverseNode.data != head.data)
                    return false;
                reverseNode = reverseNode.next;
                head = head.next;
            }
            return true;
        }

        private Node reverse(Node head) {
            Node prev = null, next = null;
            while (head != null) {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
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
