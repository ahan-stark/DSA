import java.util.Stack;

public class ReverseDLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 10, 20, 30, 40, 50, 60 };
        DoubleNode head = new DoubleNode(arr[0]);
        DoubleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode temp = new DoubleNode(arr[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
        }
        cur = head;
        System.out.println("Brute Force : ");
        DoubleNode bruteForceNode = solution.bruteForce(head);
        while (bruteForceNode != null) {
            System.out.println(bruteForceNode.data);
            bruteForceNode = bruteForceNode.next;
        }
        head = new DoubleNode(arr[0]);
        cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode temp = new DoubleNode(arr[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
        }
        System.out.println("Optimal Solution : ");
        DoubleNode optimalNode = solution.optimalSol(head);
        while (optimalNode != null) {
            System.out.println(optimalNode.data);
            optimalNode = optimalNode.next;
        }
    }

    private static class Solution {
        private DoubleNode bruteForce(DoubleNode head) {
            Stack<Integer> stack = new Stack<>();
            DoubleNode cur = head;
            while (cur != null) {
                stack.push(cur.data);
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                cur.data = stack.pop();
                cur = cur.next;
            }
            return head;
        }

        private DoubleNode optimalSol(DoubleNode head) {
            DoubleNode cur = head;
            DoubleNode prev = null;
            DoubleNode next = null;
            while (cur != null) {
                prev = cur.prev;
                next = cur.next;
                cur.next = prev;
                cur.prev = next;
                cur = next;
            }
            return prev.prev;
        }

    }

    private static class DoubleNode {
        int data;
        DoubleNode prev;
        DoubleNode next;

        DoubleNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
