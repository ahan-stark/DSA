public class DeleteFromLL {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 20, 30, 40, 50, 60 };
        Node node = new Node(arr[0]);
        Node cur = node;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        cur = node;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        // print and check
        cur = node;
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
    }
}
