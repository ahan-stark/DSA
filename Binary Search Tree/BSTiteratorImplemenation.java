import java.util.Stack;

public class BSTiteratorImplemenation {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.left.right = new Node(6);
        root.left.right.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(14);
        BSTiterator bst = new BSTiterator(root);
        System.out.println(bst.hasNext());
        System.out.println(bst.getNext());
    }

    private static class BSTiterator {
        Stack<Node> stack = new Stack<>();

        public BSTiterator(Node root) {
            pushAll(root);
        }

        private int getNext() {
            Node cur = stack.pop();
            pushAll(cur.right);
            return cur.data;
        }

        private boolean hasNext() {
            return !stack.isEmpty() ? true : false;
        }

        private void pushAll(Node root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
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

// Implementation of the inorder for BST... at first go till extreme left end
// and keep adding the nodes to stack.

// hashNext() - > to check if the further nodes are there for inorder, since we
// are storing in stack just keep checking whether the stack is empty or not.

// while doing getNext() , remove one from stack... check if it has right, if it
// has add all the elements of left side of cur.right and return cur.data

// if we want in the form of reverse that is RML..Right Mid Left...we need to
// keep moving right and add to stack and the moment we remove any elem we have
// to check for left of that elem and go to extreme right adding those to stack.