//in this a BST is given where two nodes are swapped...we have to swap it again so that a proper ...in the below 6 and 13 has to be swapped to form proper BST

public class RecoverBSTfrom1Swap {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.left.right = new Node(13);
        root.left.right.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(14);
        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverBST(root);
    }

    private static class RecoverBST {
        Node prev, first, last, middle;

        private void recoverBST(Node root) {
            first = prev = last = middle = null;
            inorder(root);
            if (first != null && last != null) {
                // swap the first and last violoation
                int temp = first.data;
                first.data = last.data;
                last.data = temp;
            } else {
                // swap the first and middle violation
                int temp = first.data;
                first.data = middle.data;
                middle.data = temp;
            }
        }

        private void inorder(Node root) {
            if (root == null)
                return;
            inorder(root.left);
            if (prev != null && prev.data > root.data) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }
            prev = root;
            inorder(root.right);

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
// we have to swap two nodes that are making the violation of BST... we can
// create an array of inorder and check which are not in sorted form then we
// will get to know which has to be swapped...in the same waay keep pointers
// prev,first violation pointer and last violoation pointer and middle violation
// pointer.....we run an inorder traversal and keep checking the prev node with
// the cur node.. if the prevNode is greater than cur node that means the
// prevNode was the first violation... and continue again and find the last
// violation...then at the end we swap both the values and get a proper BST...

// in case where we found only the first violation...that means no last
// violation .. we have to keep the cur node as the middle .. so that we can
// only swap the first and middle...bcz 1,2,3,4,7,5,8...here we wont get the
// last violation where we find prev the first violation so only that cur will
// be the middle violation.