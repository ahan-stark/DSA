public class RevereseLLinKgroups {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 3;
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        cur = head;
        Node solNode = solution.reverseLLinGroups(cur, k);
        while (solNode != null) {
            System.out.println(solNode.data);
            solNode = solNode.next;
        }
    }

    private static class Solution {
        private Node reverseLLinGroups(Node head, int k) {
            Node cur = head;
            Node nextNode = null;
            Node prevNode = null;
            while (cur != null) {
                Node kthNode = findKthNode(cur, k);
                if (kthNode == null) {
                    if (prevNode != null)
                        prevNode.next = cur;
                    break;
                }
                nextNode = kthNode.next;
                kthNode.next = null;
                reverse(cur);
                if (cur == head) {
                    head = kthNode;
                } else {
                    prevNode.next = kthNode;
                }
                prevNode = cur;
                cur = nextNode;
            }
            return head;
        }

        private Node findKthNode(Node cur, int k) {
            k = k - 1;
            while (cur != null && k > 0) {
                cur = cur.next;
                k = k - 1;
            }
            return cur;
        }

        private void reverse(Node kthNode) {
            Node cur = kthNode;
            Node next = null;
            Node prev = null;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
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
