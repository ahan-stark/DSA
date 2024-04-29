//Balanced Binary tree means the left root and right (left - right) <= 1..depth should be less than 1
public class BalancedBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(10);
        // root.left.left.left.left = new Node(15); include this for not balanced case
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        CheckBalanced balanced = new CheckBalanced();
        if (balanced.checkBalanced(root) != -1) {
            System.out.println("Tree is perfectly balanced");
        } else {
            System.out.println("Tree is not balanced");
        }
    }

    private static class CheckBalanced {
        private int checkBalanced(Node root) {
            if (root == null)
                return 0;
            int left = checkBalanced(root.left);
            int right = checkBalanced(root.right);
            if (left == -1 || right == -1)
                return -1;
            if (Math.abs(left - right) > 1)
                return -1;
            return 1 + Math.max(left, right);
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
// this is same as finding the depth of binary tree, for each root we find the
// left depth and right depth and return 1 + Math.max(left, right); , in this
// problem also we are checking the balanced left and right if any root has(left
// - right) > 1 then it is not balanced so return -1... this will be either
// returned to left call or right call if any left or right becomes - 1.. then
// return -1 directly saying this is unbalanced