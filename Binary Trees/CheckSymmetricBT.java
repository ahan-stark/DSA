public class CheckSymmetricBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        CheckSymmetric checkSymmetric = new CheckSymmetric();
        boolean symmetric = checkSymmetric.checkForSymmetric(root);
        System.out.println("The Binary tree is symmetrical : " + symmetric);
    }

    private static class CheckSymmetric {
        private boolean checkForSymmetric(Node root) {
            if (root == null)
                return true;
            return check(root.left, root.right);
        }

        private boolean check(Node root1, Node root2) {
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null)
                return false;
            return (root1.data == root2.data) && check(root1.left, root2.right) && check(root1.right, root2.left);
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
// this problem is similar to finding whether 2 trees are identical...but in
// case of symmetrical we have to check the mirror side is that root.left should
// be equal to root.right..similarly root.left.left should be eqaul to
// root.right.right... so break down the main root as 2 roots (left & right)
// then check accordingly