import java.util.Stack;

public class FlattenBTtoLL {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        FlattenBT flattenBT = new FlattenBT();
        flattenBT.flattenBTtoLL(root);
        while (root != null) {
            System.out.println(root.data);
            root = root.right;
        }
    }

    private static class FlattenBT {
        private void flattenBTtoLL(Node root) {
            if (root == null)
                return;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (!stack.isEmpty()) {
                    cur.right = stack.peek();
                }
                cur.left = null;
            }
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
// Linked List should be on same root and order should be like pre order
// to flatten a BT to Linked List... we have to take root and put it in stack
// and then we have to take it as cur and check left and right then add to stack
// based on the way it should be printed ... do like level order traversal...
// always make the cur root left as null and cur.right should be connected to
// stack.peek()