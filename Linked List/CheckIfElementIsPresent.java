public class CheckIfElementIsPresent {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 20, 30, 40, 50, 60 };
        Node node = new Node(arr[0]);
        Node cur = node;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        boolean found = false;
        int ele = 50;
        cur = node;
        while (cur != null) {
            if (cur.data == ele) {
                found = true;
                break;
            }
            cur = cur.next;
        }
        System.out.println("Element " + ele + " is found : " + found);
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
