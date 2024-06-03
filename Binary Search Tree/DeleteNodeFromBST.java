public class DeleteNodeFromBST {
    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(7);
        root.left.left.left.left = new Node(2);
        root.left.left.left.right = new Node(4);
        root.left.left.left.left.left = new Node(1);
        root.left.left.right.left = new Node(6);
        root.left.left.right.right = new Node(8);
        root.right.left = new Node(10);
        root.right.right = new Node(13);
        root.right.left.right = new Node(11);
        DeleteNode deleteNode = new DeleteNode();
        int key = 5;
        Node newroot = deleteNode.deleteNodeBST(root, key);
        System.out.println(newroot);

    }

    private static class DeleteNode {
        private Node deleteNodeBST(Node root, int key) {
            if (root == null)
                return null;
            Node cur = root;
            while (cur != null) {
                if (key < cur.data) {
                    if (cur.left != null && cur.left.data == key) {
                        Node leftSide = findHelper(cur.left);
                        cur.left = leftSide;
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right != null && cur.right.data == key) {
                        Node righSide = findHelper(cur.right);
                        cur.right = righSide;
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
            }
            return root;
        }

        private Node findHelper(Node root) {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            Node getExtremeRightEnd = getExtremeRight(root.left);
            getExtremeRightEnd.right = root.right;
            return root.left;
        }

        private Node getExtremeRight(Node root) {
            while (root.right != null) {
                root = root.right;
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
// In this binary search tree, we need to delete a node. To achieve this, we
// first locate the node to be deleted. If the node is in the left subtree, we
// check if the left child is the node we need to remove. If it is, we should
// not traverse directly to the left child because we need to delete it.
// Instead, we modify root.left. Specifically, we find the rightmost node of the
// left subtree of the node to be deleted and connect it to the right child of
// the node being removed. This ensures that the binary search tree remains in
// correct order.
// If the left child is not the node we are searching for, we move to root.left
// and follow the same procedure. The same logic applies to the right subtree:
// if the node to be deleted is in the right subtree, we check root.right, and
// if it is the node to be removed, we adjust the tree accordingly.