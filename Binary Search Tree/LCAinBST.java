public class LCAinBST {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        FindLCA findLCA = new FindLCA();
        int p = 5, q = 0;

        Node lca = findLCA.getLCA(root, p, q);
        System.out.println("Least Common Ancestor : " + lca.data);
    }

    private static class FindLCA {
        private Node getLCA(Node root, int p, int q) {
            if (root == null)
                return null;
            while (root != null) {
                if (p < root.data && q < root.data)
                    root = root.left;
                else if (p > root.data && q > root.data)
                    root = root.right;
                else
                    return root;
            }
            return null;
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
// since it is a BST we know it will be properly ordered... so p and q we check
// if both are in left side or both are in right side...if both in left
// side...move left ...if both in right side...move right...else if one is left
// and one is right...then the cur node itself is the LCA