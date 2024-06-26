// Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

// A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);
        Solution solution = new Solution();
        Node newRoot = solution.getBalanacedBST(root);
        solution.preintTree(newRoot);
    }

    private static class Solution {
        private Node getBalanacedBST(Node root) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            int start = 0;
            int end = list.size() - 1;
            int mid = (start + end) / 2;
            Node newRoot = new Node(list.get(mid));
            newRoot.left = createNodes(list, start, mid - 1);
            newRoot.right = createNodes(list, mid + 1, end);
            return newRoot;
        }

        private Node createNodes(List<Integer> list, int start, int end) {
            if (end < start)
                return null;
            int mid = (start + end) / 2;
            Node root = new Node(list.get(mid));
            root.left = createNodes(list, start, mid - 1);
            root.right = createNodes(list, mid + 1, end);
            return root;
        }

        private void inOrder(Node root, List<Integer> list) {
            if (root == null)
                return;
            inOrder(root.left, list);
            list.add(root.data);
            inOrder(root.right, list);
        }

        private void preintTree(Node root) {
            if (root == null)
                return;
            preintTree(root.left);
            System.out.println(root.data);
            preintTree(root.right);
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
