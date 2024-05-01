public class MaximumPathSumBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        GetMaxSum getMaxSum = new GetMaxSum();
        int maxPath = getMaxSum.getMaxPath(root);
        System.out.println("Max Path : " + maxPath);
    }

    private static class GetMaxSum {
        private int getMaxPath(Node root) {
            int max[] = { Integer.MIN_VALUE };
            findMax(root, max);
            return max[0];
        }

        private int findMax(Node root, int max[]) {
            if (root == null)
                return 0;
            int left = findMax(root.left, max);
            int right = findMax(root.right, max);
            if (left < 0)
                left = 0;
            if (right < 0)
                right = 0;
            max[0] = Math.max(max[0], (left + right + root.data));
            return root.data + Math.max(left, right);
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
// in each root we find the left side sum and right side sum, so for that root
// the maxPath is left + right + root, but in case if there is any negative
// elements dont consider that so directly say it as zero and then sum it up