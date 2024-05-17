public class CountTotalNodesInCompleteBinarytree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(11);
        TotalNodesInCBT cbt = new TotalNodesInCBT();
        int totalNodes = cbt.getTotalNodesInCBT(root);
        System.out.println("Total Nodes : " + totalNodes);
    }

    private static class TotalNodesInCBT {
        private int getTotalNodesInCBT(Node root) {
            if (root == null)
                return 0;
            int left = findLeftnodes(root);
            int right = findRightNodes(root);
            if (left == right)
                return (1 << left) - 1;
            return 1 + getTotalNodesInCBT(root.left) + getTotalNodesInCBT(root.right);
        }

        private int findLeftnodes(Node root) {
            int count = 0;
            while (root != null) {
                count = count + 1;
                root = root.left;
            }
            return count;
        }

        private int findRightNodes(Node root) {
            int count = 0;
            while (root != null) {
                count = count + 1;
                root = root.right;
            }
            return count;
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
// in complete binary tree... all the nodes will be complete except for the last
// node.. also the left part...to calculate the total nodes..if we are sure all
// the nodes will have complete children(L & R).. then total nodes will be 2 pow
// height - 1..if level 3 so 2 pow 3 - 1 = 7..in case it is not equal then we
// say root is 1 + find(root.left) + find(root.right) in a recursive way.. we
// calculated 2 pow using the bit manipulation