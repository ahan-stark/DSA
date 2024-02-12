import java.util.ArrayList;

public class OddEvenList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[] { 10, 20, 30, 40, 50, 60 };
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
        System.out.println("Optimal Sol : ");
        cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        Node optimalNode = solution.optimalSol(head);
        while (optimalNode != null) {
            System.out.println(optimalNode.data);
            optimalNode = optimalNode.next;
        }
    }

    private static class Solution {
        private Node bruteForce(Node head) {
            Node temp = head;
            ArrayList<Integer> arr = new ArrayList<>();
            while (temp != null && temp.next != null) {
                arr.add(temp.data);
                temp = temp.next.next;
            }
            // thus if the temp is last it will skip that so assign directly
            if (temp != null)
                arr.add(temp.data);
            temp = head.next;
            while (temp != null && temp.next != null) {
                arr.add(temp.data);
                temp = temp.next.next;
            }
            if (temp != null) {
                arr.add(temp.data);
            }
            temp = head;
            int i = 0;
            while (temp != null) {
                temp.data = arr.get(i++);
                temp = temp.next;
            }
            return head;
        }

        private Node optimalSol(Node head) {
            Node oddNodes = head;
            Node evenNodes = head.next;
            Node evenHead = head.next;
            while (oddNodes != null && evenNodes != null && oddNodes.next != null && evenNodes.next != null) {
                oddNodes.next = oddNodes.next.next;
                evenNodes.next = evenNodes.next.next;
                oddNodes = oddNodes.next;
                evenNodes = evenNodes.next;
            }
            oddNodes.next = evenHead;
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
