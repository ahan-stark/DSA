public class SearchNodeInBST {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        FindInBST findInBST = new FindInBST();
        Node ans = findInBST.findEle(root, 10);
        if (ans != null) {
            System.out.println("Element found in BST");
        } else {
            System.out.println("Element Not Found!");
        }
    }

    private static class FindInBST {
        private Node findEle(Node node, int ele) {
            if (node == null)
                return null;
            if (ele == node.data)
                return node;
            if (ele < node.data)
                return findEle(node.left, ele);
            else
                return findEle(node.right, ele);
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