public class InsertNodeinBST {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        InsertinBST insertinBST = new InsertinBST();
        int val = 5;
        Node newRoot = insertinBST.insertNode(root, val);
        System.out.println(newRoot);
    }

    private static class InsertinBST {
        private Node insertNode(Node root, int val) {
            if (root == null)
                return new Node(val);
            Node cur = root;
            while (true) {
                if (val <= cur.data) {
                    if (cur.left != null)
                        cur = cur.left;
                    else {
                        cur.left = new Node(val);
                        break;
                    }
                } else {
                    if (cur.right != null)
                        cur = cur.right;
                    else {
                        cur.right = new Node(val);
                        break;
                    }
                }
            }
            return root;
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
