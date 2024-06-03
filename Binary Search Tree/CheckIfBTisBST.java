public class CheckIfBTisBST {
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
        FindIfBST bst = new FindIfBST();
        System.out.println("The given tree is BST ? " + ((bst.checkBST(root) == true) ? true : false));
    }

    private static class FindIfBST {
        private boolean checkBST(Node root) {
            int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
            return checkBTforBST(root, min, max);
        }

        private boolean checkBTforBST(Node root, int min, int max) {
            if (root == null)
                return true;
            if (root.data >= max || root.data <= min)
                return false;
            if (checkBTforBST(root.left, min, root.data) == false)
                return false;
            if (checkBTforBST(root.right, root.data, max) == false)
                return false;
            else
                return true;
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
// we know for any binary tree the left value should be less than root.data and
// right value should be greater..so for the root node we say min can be
// int.min_val and max can be int.max_val.... so if we go left we can say min
// can be anything that is int_min only but max should be root.data..same way in
// right side max can be anything say int.max_val but min should be root.data