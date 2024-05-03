import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.left.left = new Node(6);
        root.left.right.right = new Node(7);
        root.left.right.right.right = new Node(8);
        root.right.right = new Node(9);
        Boundary boundary = new Boundary();
        List<Integer> boundaries = boundary.getBoundary(root);
        for (Integer val : boundaries) {
            System.out.println(val);
        }
    }

    private static class Boundary {
        private List<Integer> getBoundary(Node root) {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            getLeftBoundary(root, list);
            getLeaf(root, list);
            getRightBoundary(root, list);
            return list;
        }

        private void getLeftBoundary(Node root, List<Integer> list) {
            Node curr = root.left;
            while (curr != null) {
                if (!isLeaf(curr)) {
                    list.add(curr.data);
                }
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
        }

        void getLeaf(Node root, List<Integer> list) {
            if (root == null) {
                return;
            }
            if (isLeaf(root)) {
                list.add(root.data);
                return;
            }
            if (root.left != null) {
                getLeaf(root.left, list);
            }
            if (root.right != null) {
                getLeaf(root.right, list);
            }
        }

        void getRightBoundary(Node root, List<Integer> res) {
            Node curr = root.right;
            List<Integer> temp = new ArrayList<>();
            while (curr != null) {
                if (!isLeaf(curr)) {
                    temp.add(curr.data);
                }
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
            for (int i = temp.size() - 1; i >= 0; --i) {
                res.add(temp.get(i));
            }
        }

        private boolean isLeaf(Node root) {
            if (root.left == null && root.right == null)
                return true;
            else
                return false;
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

// In this boundary traversal we find first the left nodes, keep checking left
// nodes, if there is no left in the path, check right of that left also untill
// we reach the leaf node. Once we reach leaf node stop, then find the leaf
// nodes, for this we use inorder traversal method go to extreme left end then
// check for all the roots, This inorder will also check all the roots even in
// the right side of tree. Then once we have left boundary, leaf nodes, then we
// should get right boundary, since we are going in anti clockwise, follow the
// same step for right and put it in temp, to get it in anti clock wise right
// boundary, reverse way add the temp to the list.