import java.util.ArrayList;
import java.util.List;

public class SortLL {
    public static void main(String[] args) {
        int arr[] = new int[] { 3, 5, 1, 2, 4 };
        Solution solution = new Solution();
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
    }

    private static class Solution {
        private Node bruteForce(Node head) {
            List<Integer> list = new ArrayList<>();
            Node cur = head;
            while (cur != null) {
                list.add(cur.data);
                cur = cur.next;
            }
            cur = head;
            list.sort(null);
            for (int i = 0; i < list.size(); i++) {
                cur.data = list.get(i);
                cur = cur.next;
            }
            return head;
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
