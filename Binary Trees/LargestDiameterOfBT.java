public class LargestDiameterOfBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        Diameter diameter = new Diameter();
        System.out.println("Diameter of given BT : " + diameter.getDiameter(root));
    }

    private static class Diameter {
        private int getDiameter(Node root) {
            int ans[] = { 0 };
            findLargestDiameter(root, ans);
            return ans[0];
        }

        private int findLargestDiameter(Node root, int[] ans) {
            if (root == null)
                return 0;
            int left = findLargestDiameter(root.left, ans);
            int right = findLargestDiameter(root.right, ans);
            ans[0] = Math.max(ans[0], left + right);
            return 1 + Math.max(left, right);
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
// for each of the root calculate the left and right, then we get the diameter
// as (left + right) length of that root.. then rest same as finding the depth
// of root