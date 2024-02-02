public class ArrayToLinkedList {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 20, 30, 40, 50, 60 };
        Node node = new Node(arr[0]);
        Node cur = node;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
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
