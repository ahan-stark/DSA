public class InorderSuccessor {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.left.right = new Node(6);
        root.left.right.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(14);
        InorderNextElem nextElem = new InorderNextElem();
        int k = 6;
        Node nextOccurence = nextElem.getInorderSuccessor(root, k);
        System.out.println("Inorder Successor : " + nextOccurence.data);
    }

    private static class InorderNextElem {
        private Node getInorderSuccessor(Node root, int k) {
            Node successor = null;
            while (root != null) {
                if (k >= root.data) {
                    root = root.right;
                } else {
                    successor = root;
                    root = root.left;
                }
            }
            return successor;
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

// In this method to get the next inorder successor, we check and keep moving
// right & left based on condition. Since it is inorder:- LMR, when we go to
// left paert we have to keep the M as the successor Node and then go.