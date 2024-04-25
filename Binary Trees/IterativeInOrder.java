import java.util.Stack;

public class IterativeInOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        InOrder inOrder = new InOrder();
        inOrder.printInOrder(root);
    }

    private static class InOrder {
        private void printInOrder(Node root) {
            Stack<Node> stack = new Stack<>();
            while (true) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    if (stack.isEmpty())
                        break;
                    root = stack.pop();
                    System.out.println(root.data);
                    root = root.right;
                }
            }
        }

    }

    static class Node {
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
