import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        int targetNode = 7;
        GetNode getNode = new GetNode();
        List<Integer> path = getNode.getPathNode(root, targetNode);
        for (Integer val : path) {
            System.out.println(val);
        }
    }

    private static class GetNode {
        private List<Integer> getPathNode(Node node, int targetNode) {
            List<Integer> list = new ArrayList<>();
            getPath(node, targetNode, list);
            return list;
        }

        private boolean getPath(Node node, int targetNode, List<Integer> list) {
            if (node == null)
                return false;
            list.add(node.data);
            if (node.data == targetNode)
                return true;
            if (getPath(node.left, targetNode, list) == true)
                return true;
            if (getPath(node.right, targetNode, list) == true)
                return true;
            list.remove(list.size() - 1);
            return false;
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
// in this approach we first check if the given root is null, if not then we
// will directly add that root.data that list and assume that it can we a part
// of path.. then we check if that root.data is itself the target..if this is
// the case return true... if not then check the left part if its return true..
// then return true.. if not then check the right part if true...return true..
// else we know left also we didnt get any target, right also we didnt get the
// target..so remove the root.data from that list and return false