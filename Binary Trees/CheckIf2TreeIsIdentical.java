public class CheckIf2TreeIsIdentical {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        CheckIdentical checkIdentical = new CheckIdentical();
        System.out.println("Two trees are : " + checkIdentical.checkIdenticalTree(root1, root2));
    }

    private static class CheckIdentical {
        private boolean checkIdenticalTree(Node root1, Node root2) {
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null)
                return false;
            return ((root1.data == root2.data) && checkIdenticalTree(root1.left, root2.left)
                    && checkIdenticalTree(root1.right, root2.right));
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
