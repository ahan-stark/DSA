// For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

// A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

// Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.

public class FlipEquidataentBTs {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.left.right.left = new Node(7);
        root1.left.right.right = new Node(8);
        root1.right = new Node(30);
        root1.right.left = new Node(6);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.left.right = new Node(6);
        root2.right = new Node(2);
        root2.right.left = new Node(4);
        root2.right.right = new Node(5);
        root2.right.right.left = new Node(8);
        root2.right.right.right = new Node(7);
        Solution solution = new Solution();
        boolean isEqual = solution.flipEquiv(root1, root2);
        System.out.println(isEqual);

    }

    private static class Solution {
        private boolean flipEquiv(Node root1, Node root2) {
            return checkFlips(root1, root2);
        }

        private boolean checkFlips(Node root1, Node root2) {
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null)
                return false;

            if (root1.data != root2.data)
                return false;

            if ((root1.left == null && root2.left != null) || (root1.left != null && root2.left == null)
                    || (root1.right == null && root2.right != null) || (root1.right != null && root2.right == null)) {
                swap(root1);
            } else if ((root1.left != null && root2.left != null && root1.left.data != root2.left.data)
                    || (root1.right != null && root2.right != null && root1.right.data != root2.right.data)) {
                swap(root1);
            }

            if ((root1.left == null && root2.left != null) || (root2.left == null && root1.left != null))
                return false;
            if ((root1.right == null && root2.right != null) || (root2.right == null && root1.right != null))
                return false;

            if ((root1.left != null && root2.left != null && root1.left.data != root2.left.data)
                    || (root1.right != null && root2.right != null && root1.right.data != root2.right.data)) {
                return false;
            }

            boolean leftCheck = checkFlips(root1.left, root2.left);
            boolean rightCheck = checkFlips(root1.right, root2.right);

            return leftCheck && rightCheck;
        }

        private void swap(Node root) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
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
