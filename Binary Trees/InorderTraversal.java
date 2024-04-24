public class InorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        Inorder inorder = new Inorder();
        inorder.printInorder(root);

    }

    private static class Inorder {
        private void printInorder(Node root) {
            if (root == null)
                return;
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
