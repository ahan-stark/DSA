public class PostOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        PostOrder postOrder = new PostOrder();
        postOrder.printPostOrder(root);
    }

    private static class PostOrder {
        private void printPostOrder(Node root) {
            if (root == null)
                return;
            System.out.println(root.data);
            printPostOrder(root.left);
            printPostOrder(root.right);
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