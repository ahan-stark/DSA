public class LinkedListImplementation {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20, new Node(30));
        Node cur = node;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}