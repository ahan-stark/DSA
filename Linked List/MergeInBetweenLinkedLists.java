// Given two linked lists: list1 and list2
// Remove list1's nodes from the ath node to the bth node, and put list2 in their place

public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 2, b = 5;
        int arr1[] = new int[] { 0, 1, 2, 3, 4, 5, 6 };
        Node list1 = new Node(arr1[0]);
        Node cur = list1;
        for (int i = 1; i < arr1.length; i++) {
            Node temp = new Node(arr1[i]);
            cur.next = temp;
            cur = cur.next;
        }
        int arr2[] = new int[] { 1000000, 1000001, 1000002, 1000003, 1000004 };
        Node list2 = new Node(arr2[0]);
        cur = list2;
        for (int i = 1; i < arr2.length; i++) {
            Node temp = new Node(arr2[i]);
            cur.next = temp;
            cur = cur.next;
        }
        Node finalNode = solution.betterApproach(list1, list2, a, b);
        while (finalNode != null) {
            System.out.println(finalNode.data);
            finalNode = finalNode.next;
        }

    }

    private static class Solution {
        private Node betterApproach(Node list1, Node list2, int a, int b) {
            Node startPoint = list1;
            Node endPoint = null;
            for (int i = 0; i < a - 1; i++)
                startPoint = startPoint.next;
            endPoint = startPoint;
            for (int i = 0; i <= b - a; i++)
                endPoint = endPoint.next;
            startPoint.next = list2;
            while (list2.next != null)
                list2 = list2.next;
            list2.next = endPoint.next;
            return list1;
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
