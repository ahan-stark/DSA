public class PreOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        PreOrder preOrder = new PreOrder();
        preOrder.printPreOrder(root);
    }

    private static class PreOrder {
        private void printPreOrder(Node root) {
            if (root == null)
                return;
            System.out.println(root.data);
            printPreOrder(root.left);
            printPreOrder(root.right);
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