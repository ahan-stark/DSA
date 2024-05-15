import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        FindMaxWidth findMaxWidth = new FindMaxWidth();
        int maxWidth = findMaxWidth.getMax(root);
        System.out.println("Maximum Width : " + maxWidth);
    }

    private static class FindMaxWidth {
        private int getMax(Node root) {
            int maxWidth = 0;
            if (root == null)
                return maxWidth;
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root, 0));
            while (!queue.isEmpty()) {
                int size = queue.size();
                int first = 0, last = 0;
                for (int i = 0; i < size; i++) {
                    Pair pair = queue.remove();
                    if (i == 0)
                        first = pair.curOrder;
                    if (i == size - 1)
                        last = pair.curOrder;
                    if (pair.node.left != null)
                        queue.add(new Pair(pair.node.left, (2 * pair.curOrder) + 1));
                    if (pair.node.right != null)
                        queue.add(new Pair(pair.node.right, (2 * pair.curOrder) + 2));
                }
                maxWidth = Math.max(maxWidth, (last - first) + 1);
            }
            return maxWidth;
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

    private static class Pair {
        Node node;
        int curOrder;

        Pair(Node node, int curOrder) {
            this.node = node;
            this.curOrder = curOrder;
        }

    }
}
// we create each node of the tree like 0 -> 1 -> 2 -> 3 -> 4 ->5 (identities)
// ...first level is 0..second level is 1 and 2..third level is
// 3...4...5...6.... like this with the nodes we keep it as a pair with their
// numbers.... so maxwidth will be (last(id) - first(id)) + 1 in that particular
// level order traversal.... to traverse each level we keep it queue and
// traverse based on size for that level order traversal....whenever i == 0 we
// consider first and i == size - 1 we consider last.... to get that pattern
// when adding left (2 * curOrder) + 1 and when adding right (2 * curOrder) + 2