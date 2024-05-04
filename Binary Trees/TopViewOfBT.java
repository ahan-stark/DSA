import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);
        TopView topView = new TopView();
        List<Integer> top = topView.getTopView(root);
        System.out.println("Top View : ");
        for (Integer val : top) {
            System.out.println(val);
        }
    }

    private static class TopView {
        private List<Integer> getTopView(Node root) {
            List<Integer> list = new ArrayList<>();
            if (root == null)
                return list;
            Queue<Pair> queue = new LinkedList<>();
            Map<Integer, Integer> map = new TreeMap<>();
            queue.add(new Pair(root, 0));
            while (!queue.isEmpty()) {
                Pair pair = queue.remove();
                int line = pair.line;
                Node cur = pair.node;
                if (!map.containsKey(line)) {
                    map.put(line, cur.data);
                }
                if (cur.left != null) {
                    queue.add(new Pair(cur.left, line - 1));
                }
                if (cur.right != null) {
                    queue.add(new Pair(cur.right, line + 1));
                }
            }
            for (Map.Entry<Integer, Integer> val : map.entrySet()) {
                list.add(val.getValue());
            }
            return list;
        }

    }

    private static class Pair {
        Node node;
        int line;

        Pair(Node node, int line) {
            this.node = node;
            this.line = line;
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
// we are using treemap since we need it in ascending order.. here the logic is
// get the line number saying at which pos is that node occuring.. the root node
// is at 0 in line, so we put to queue as a pair (node,0)...then we take that
// pair..get the node and line.. whatever the line interval that comes first
// only that has to be considered since if we see from top only that will be
// visible ... so if it is not in map..means we have to add that line and
// node.data... same way after taking one node add the left and right of those
// nodes...this is generally the BFS traversal - level order traversal