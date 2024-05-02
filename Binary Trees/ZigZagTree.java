import java.util.Deque;
import java.util.LinkedList;

public class ZigZagTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ZigZag zigzag = new ZigZag();
        zigzag.printZigZag(root);
    }

    private static class ZigZag {
        private void printZigZag(Node root) {
            Deque<Node> dequeue = new LinkedList<>();
            dequeue.addFirst(root);
            boolean flag = true;
            while (!dequeue.isEmpty()) {
                int size = dequeue.size();
                for (int i = 0; i < size; i++) {
                    Node node;
                    if (flag == true) {
                        node = dequeue.removeLast();
                        if (node.left != null)
                            dequeue.addFirst(node.left);
                        if (node.right != null)
                            dequeue.addFirst(node.right);
                    } else {
                        node = dequeue.removeFirst();
                        if (node.right != null)
                            dequeue.addLast(node.right);
                        if (node.left != null)
                            dequeue.addLast(node.left);
                    }
                    System.out.println(node.data);
                }
                flag = !flag;
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
// here we will assume that flag = true says that we have to traverse in left to
// right so print that elem(removeLast) means we have to remove from the last
// and add node.right and node.left in the queue, such that node.right should be
// the first node...if flag = false means we have to add reversely to the queue
// such that add elements to queue such that it is in reverse order
