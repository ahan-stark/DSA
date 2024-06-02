public class FindFloorInBST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.left.right.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(14);
        FindFloor findFloor = new FindFloor();
        int key = 8;
        int ceil = findFloor.getFloor(root, key);
        System.out.println("Floor " + key + " is  : " + ceil);
    }

    private static class FindFloor {
        private int getFloor(Node root, int key) {
            Node cur = root;
            int floor = -1;
            while (cur != null) {
                if (key > cur.data) {
                    floor = cur.data;
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
            return floor;
        }

    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
