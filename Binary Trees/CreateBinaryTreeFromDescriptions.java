// You are given a 2D integer array descriptionsriptions where descriptionsriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

// If isLefti == 1, then childi is the left child of parenti.
// If isLefti == 0, then childi is the right child of parenti.
// Construct the binary tree descriptionsribed by descriptionsriptions and return its root.

import java.util.HashMap;

public class CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        int descriptions[][] = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
        Solution solution = new Solution();
        Node root = solution.createTree(descriptions);
        System.out.println(root);
    }

    private static class Solution {
        private Node createTree(int descriptions[][]) {
            Node finalRoot = null;
            Node parent, child;
            HashMap<Integer, Node> map = new HashMap<>();
            for (int[] arr : descriptions) {
                int parentVal = arr[0];
                int childVal = arr[1];
                boolean isLeft = arr[2] == 1;
                if (map.containsKey(parentVal)) {
                    parent = map.get(parentVal);
                } else {
                    parent = new Node(parentVal);
                }
                if (map.containsKey(childVal)) {
                    child = map.get(childVal);
                } else {
                    child = new Node(childVal);
                }
                if (isLeft) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                map.put(parentVal, parent);
                map.put(childVal, child);
            }
            HashMap<Integer, Boolean> checkroot = new HashMap<>();
            for (int[] arr : descriptions) {
                checkroot.put(arr[1], false);
            }
            for (int[] arr : descriptions) {
                if (!checkroot.containsKey(arr[0])) {
                    finalRoot = map.get(arr[0]);
                }
            }
            return finalRoot;
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
