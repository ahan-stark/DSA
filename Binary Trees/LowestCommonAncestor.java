public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
        int p = 4, q = 7;
        LCAncestor ancestor = new LCAncestor();
        Node lca = ancestor.getLCA(root, p, q);
        System.out.println("Common ancestor is : " + lca.data);
    }

    private static class LCAncestor {
        private Node getLCA(Node root, int p, int q) {
            if (root == null)
                return null;
            if (root.data == p || root.data == q)
                return root;
            Node left = getLCA(root.left, p, q);
            Node right = getLCA(root.right, p, q);
            if (left != null && right != null)
                return root;
            if (left == null)
                return right;
            else
                return left;
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
// In this algorithm for finding the lowest common ancestor of two nodes p and q
// in a binary tree, we start by checking if the current root is null. If it is,
// we return null. Otherwise, we check if the current root is either p or q. If
// so, we have found one of the nodes, and we return that root.

// If the current root is not one of the nodes, we recursively search the left
// and right subtrees. If the left subtree returns null, it indicates that both
// p and q are on the right side of the current root, so we return the result
// from the right subtree. Similarly, if the right subtree returns null, we
// return the result from the left subtree.

// If both the left and right subtrees return non-null values, it means we have
// found both p and q in different subtrees, so the current root is the lowest
// common ancestor. We return this root to the parent caller in the recursion
// stack.

// As we move up the recursion stack, if we encounter a null value from either
// the left or right subtree, we consider the other subtree, as the lowest
// common ancestor must be in the non-null subtree.