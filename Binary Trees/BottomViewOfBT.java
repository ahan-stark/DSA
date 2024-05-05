import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBT {
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
        BottomView bottomView = new BottomView();
        List<Integer> bottom = bottomView.getBottomView(root);
        System.out.println("Bottom View : ");
        for (Integer val : bottom) {
            System.out.println(val);
        }

    }

    private static class BottomView {
        private List<Integer> getBottomView(Node root) {
            Map<Integer, Integer> map = new TreeMap<>();
            List<Integer> list = new ArrayList<>();
            if (root == null)
                return list;
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root, 0));
            while (!queue.isEmpty()) {
                Pair val = queue.remove();
                int line = val.line;
                Node cur = val.node;
                map.put(line, cur.data);
                if (cur.left != null)
                    queue.add(new Pair(cur.left, line - 1));
                if (cur.right != null)
                    queue.add(new Pair(cur.right, line + 1));
            }
            for (Map.Entry<Integer, Integer> val : map.entrySet()) {
                list.add(val.getValue());
            }
            return list;

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
        int line;

        Pair(Node node, int line) {
            this.node = node;
            this.line = line;
        }

    }
}
// this problem is similar to top view of BT... in this we do level order
// traversal...and also we keep the line number and for each visit of that
// particular line in level order traversal we put that in map... if we put the
// left side then we say left = line = 1 and right = line + 1
