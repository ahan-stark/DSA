public class DeleteLeavesWithGivenValues {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        int target = 2;
        Solution solution = new Solution();
        Node newRoot = solution.getRoot(root, target);
        solution.traversal(newRoot);
    }

    private static class Solution {
        private Node getRoot(Node root, int target) {
            Node prev = null;
            dfs(root, prev, target);
            return root;
        }
        private void dfs(Node root, Node prev, int target) {
            if (root == null)
                return;
            dfs(root.left, root, target);
            dfs(root.right, root, target);
            if ((root.data == target) && (root.left == null && root.right == null)) {
                if (prev != null) {
                    if (prev.left == root) {
                        prev.left = null;
                    } else if (prev.right == root) {
                        prev.right = null;
                    }
                }
            }
        }

        private void traversal(Node root) {
            if (root == null)
                return;
            traversal(root.left);
            System.out.println(root.data);
            traversal(root.right);
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
