import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
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
        int k = 3;
        KthElemInBST bst = new KthElemInBST();
        int kthVal = bst.getKthElem(root, k);
        System.out.println("K th element is : " + kthVal);
    }

    private static class KthElemInBST {
        private int getKthElem(Node root, int k) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            return list.get(k - 1);

        }

        private void inorder(Node root, List<Integer> list) {
            if (root == null)
                return;
            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
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

// Inorder of BST will always be in ascending form... so we do inorder traversal
// and store the elements.. and return list.get(k);