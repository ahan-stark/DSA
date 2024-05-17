//after summing the two children the root should be equal to sum..we can only increment no decrement is allowed....we can change the entire data of tree

public class ChildrenSumProperty {
    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.left = new Node(30);
        root.right.right = new Node(40);
        ChildSum childSum = new ChildSum();
        childSum.makeChildSum(root);
        System.out.println(root.data);

    }

    private static class ChildSum {
        private void makeChildSum(Node root) {
            if (root == null)
                return;
            int sum = 0;
            if (root.left != null)
                sum = sum + root.left.data;
            if (root.right != null)
                sum = sum + root.right.data;
            if (sum >= root.data)
                root.data = sum;
            else {
                if (root.left != null)
                    root.left.data = root.data;
                if (root.right != null)
                    root.right.data = root.data;
            }
            makeChildSum(root.left);
            makeChildSum(root.right);
            int total = 0;
            if (root.left != null)
                total = total + root.left.data;
            if (root.right != null)
                total = total + root.right.data;
            if (root.left != null || root.right != null)
                root.data = total;
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
// in this problem we have to make the root = root.left and root.right....so
// check at first sum = root.left + root.right...if sum is greater than
// root.data that means we have to make root.data = sum... if in case sum
// becomes < root.data...we cannot decrement anything so we assign the left and
// right with the root.data .... do it till the last node... while coming back
// that is back tackng we have to check whether that left + right = root..we
// have to update the root again... only update if it is not the leaf node