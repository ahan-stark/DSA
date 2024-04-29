import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        DepthOfBT depthOfBT = new DepthOfBT();
        int depth = depthOfBT.getDepth(root);
        System.out.println("Depth : " + depth);
        int depth2 = depthOfBT.getDepthIterative(root);
        System.out.println("Depth : " + depth2);
    }

    private static class DepthOfBT {
        private int getDepth(Node root) {
            if (root == null)
                return 0;
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            return 1 + Math.max(left, right);
        }

        private int getDepthIterative(Node root) {
            Queue<Node> queue = new LinkedList<>();
            int depth = 0;
            if (root == null)
                return depth;
            queue.add(root);
            while (!queue.isEmpty()) {
                int queuSize = queue.size();
                depth = depth + 1;
                for (int i = 0; i < queuSize; i++) {
                    Node node = queue.remove();
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
            return depth;
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
