public class DirectionsFromABinaryTreeNodeToAnother {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.left.left = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(6);
        root.right.right = new Node(4);
        Solution solution = new Solution();
        String res = solution.findPath(root, 3, 6);
        System.out.println(res);
    }

    private static class Solution {
        String src2LCA = "";
        String dest2LCA = "";

        private String findPath(Node root, int startVal, int destVal) {
            Node lca = getLCA(root, startVal, destVal);
            StringBuilder strPath = new StringBuilder();
            dfs(lca, startVal, destVal, strPath);
            String src2LCAmodify = "";
            for (int i = 0; i < src2LCA.length(); i++) {
                src2LCAmodify = src2LCAmodify + "U";
            }
            return src2LCAmodify + dest2LCA;
        }

        private void dfs(Node root, int startVal, int destVal, StringBuilder strPath) {
            if (root == null)
                return;
            if (root.data == startVal)
                src2LCA = strPath.toString();
            if (root.data == destVal)
                dest2LCA = strPath.toString();
            strPath.append("L");
            dfs(root.left, startVal, destVal, strPath);
            strPath.deleteCharAt(strPath.length() - 1);
            strPath.append("R");
            dfs(root.right, startVal, destVal, strPath);
            strPath.deleteCharAt(strPath.length() - 1);
        }

        private Node getLCA(Node root, int p, int q) {
            if (root == null)
                return null;
            if (root.data == p || root.data == q)
                return root;
            Node left = getLCA(root.left, p, q);
            Node right = getLCA(root.right, p, q);
            if (left != null && right != null)
                return root;
            if (left == null)
                return right;
            else
                return left;

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
// do find the LCA of both src and dest...and find the dfs of and try to get the
// path and keep checking if its in src or dest and assign it accordingly before
// going to left append "L" and right "R".. this is backtracking