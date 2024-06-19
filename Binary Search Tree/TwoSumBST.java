import java.util.Stack;

public class TwoSumBST {
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
        int k = 17;
        Find2Sum find2Sum = new Find2Sum();
        System.out.println(" The given k : " + k + " is found in BST? : " + find2Sum.get2SumBST(root, k));

    }

    private static class Find2Sum {
        private boolean get2SumBST(Node root, int k) {
            BSTiterator left = new BSTiterator(root, "left");
            BSTiterator right = new BSTiterator(root, "right");
            int leftInorder = left.getNext();
            int rightInorder = right.getNext();
            while (leftInorder < rightInorder) {
                if (leftInorder + rightInorder == k)
                    return true;
                if (leftInorder + rightInorder < k) {
                    leftInorder = left.getNext();
                } else {
                    rightInorder = right.getNext();
                }
            }
            return false;
        }
    }

    private static class BSTiterator {
        Stack<Node> stack = new Stack<>();
        String iterativeDir;

        public BSTiterator(Node root, String direction) {
            this.iterativeDir = direction;
            pushAll(root);
        }

        private int getNext() {
            Node cur = stack.pop();
            if (iterativeDir == "left") {
                pushAll(cur.right);
            } else {
                pushAll(cur.left);
            }
            return cur.data;
        }

        private void pushAll(Node root) {
            if (iterativeDir == "left") {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            } else {
                while (root != null) {
                    stack.push(root);
                    root = root.right;
                }
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

// in a single class only we have implemented 2 traversal ways..one is LMR..and
// one more RML... if direction == left then it will follow LMR....
// to find the two sum what will apply logic is one element from the left side
// starting and other element from right end... compare and check the with sum
// k..since it is BST it will be in ascending order only from left and
// descending order from right.

// this problem can also be solved using ..do inorder traversal and create an
// array then use 2 pointer and find 2 SUM