import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
                    //     1
                    //    / \
                    //   2   3
                    //  /     \
                    // 4       5
public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> order = levelOrder.getLevelOrder(root);
        for (List<Integer> list : order) {
            System.out.println(list);
        }

    }

    private static class LevelOrder {
        private List<List<Integer>> getLevelOrder(Node root) {
            Queue<Node> queue = new LinkedList<>();
            List<List<Integer>> list = new ArrayList<>();
            if (root == null)
                return list;
            queue.add(root);
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                List<Integer> subList = new ArrayList<>();
                for (int i = 0; i < queueSize; i++) {
                    if (queue.peek().left != null) {
                        queue.add(queue.peek().left);
                    }
                    if (queue.peek().right != null) {
                        queue.add(queue.peek().right);
                    }
                    subList.add(queue.remove().data);
                }
                list.add(subList);
            }
            return list;
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
