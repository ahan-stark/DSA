import java.util.Stack;

public class ReverseLL {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        cur = head;
        Node stackReverse = stackReverse(cur);
        System.out.println("Stack Approach :");
        while (stackReverse != null) {
            System.out.println(stackReverse.data);
            stackReverse = stackReverse.next;
        }
        head = new Node(arr[0]);
        cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        cur = head;
        Node iterativNode = iterativeApproach(cur);
        System.out.println("Iterative Approach :");
        while (iterativNode != null) {
            System.out.println(iterativNode.data);
            iterativNode = iterativNode.next;
        }
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        cur = head;
        System.out.println("Recursion Method :");
        Node recusrNode = recursion(head);
        while (recusrNode != null) {
            System.out.println(recusrNode.data);
            recusrNode = recusrNode.next;
        }
    }

    private static Node stackReverse(Node cur) {
        Stack<Integer> stack = new Stack<>();
        Node head1 = cur;
        while (cur != null) {
            stack.push(cur.data);
            cur = cur.next;
        }
        cur = head1;
        while (cur != null) {
            cur.data = stack.pop();
            cur = cur.next;
        }
        return head1;
    }

    private static Node iterativeApproach(Node head) {
        Node cur = head;
        Node prev = null, nextNode = null;
        while (cur != null) {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    private static Node recursion(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newNode = recursion(head.next);
        Node frontNode = head.next;
        frontNode.next = head;
        head.next = null;
        return newNode;
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
