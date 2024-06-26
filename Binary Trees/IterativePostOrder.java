import java.util.Stack;

public class IterativePostOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        PostOrder postOrder = new PostOrder();
        postOrder.printPostOrder(root);
        postOrder.printPostOrder1Stack(root);
    }

    private static class PostOrder {
        private void printPostOrder(Node root) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                Node node = stack1.pop();
                stack2.push(node);
                if (node.left != null)
                    stack1.push(node.left);
                if (node.right != null)
                    stack1.push(node.right);
            }
            System.out.println("Post order : ");
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().data);
            }
        }

        private void printPostOrder1Stack(Node root) {
            Node cur = root;
            System.out.println("Post Order using 1 stack :");
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    Node temp = stack.peek().right;
                    if (temp == null) {
                        temp = stack.pop();
                        System.out.println(temp.data);
                        while (!stack.isEmpty() && temp == stack.peek().right) {
                            System.out.println(stack.peek().data);
                            temp = stack.pop();
                        }
                    } else {
                        cur = temp;
                    }
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
