import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class RightViewOfBT {
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
        RightView rightView = new RightView();
        List<Integer> bruteForce = rightView.getRightViewBruteforce(root);
        System.out.println("Right side of BT : ");
        for (Integer num : bruteForce) {
            System.out.println(num);
        }
        List<Integer> recursive = rightView.getRecursive(root);
        System.out.println("Right side of BT : ");
        for (Integer num : recursive) {
            System.out.println(num);
        }
    }

    private static class RightView {
        private List<Integer> getRightViewBruteforce(Node root) {
            List<Integer> list = new ArrayList<>();
            if (root == null)
                return list;
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root, 0));
            Map<Integer, Integer> map = new TreeMap<>();
            while (!queue.isEmpty()) {
                Pair pair = queue.remove();
                Node cur = pair.node;
                int level = pair.level;
                if (!map.containsKey(level)) {
                    map.put(level, cur.data);
                }
                if (cur.right != null)
                    queue.add(new Pair(cur.right, level + 1));
                if (cur.left != null)
                    queue.add(new Pair(cur.left, level + 1));
            }
            for (Map.Entry<Integer, Integer> val : map.entrySet()) {
                list.add(val.getValue());
            }
            return list;
        }

        private List<Integer> getRecursive(Node root) {
            List<Integer> list = new ArrayList<>();
            findRightView(root, 0, list);
            return list;
        }

        private void findRightView(Node root, int level, List<Integer> list) {
            if (root == null)
                return;
            if (level == list.size())
                list.add(root.data);
            findRightView(root.right, level + 1, list);
            findRightView(root.left, level + 1, list);
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
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
// the brute force approach is using the level order traversal...since we need
// right side view add root.right first to queue and then add root.right
// everytime....check in pair whether we have already line(level of traversal)
// in Map..if it is there no need to add again...repeat untill the very last
// node

// in the recursive solution we use a modified pre-order traversal...since we
// need from right side view....we go right and then left...to make sure we only
// add 1 element from each level we will keep an "final list" as "list".. for
// each level we check if the list.size().. for level 0 the list.size() is 0
// then add that first element to list...same way do for all the levels nodes
// this works like if the size is 0 and we are in 0 level..that means no
// elements were added from that level..so add that to the list
