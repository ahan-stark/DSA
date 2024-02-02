public class LengthOfLL {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Node node = new Node(arr[0]);
        Node cur = node;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        int length = lengthOfLL(node);
        System.out.println("length of linked list : " + length);
    }

    private static int lengthOfLL(Node cur) {
        int count = 0;
        while (cur != null) {
            count++;
            System.out.println(cur.data);
            cur = cur.next;
        }
        return count;
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
