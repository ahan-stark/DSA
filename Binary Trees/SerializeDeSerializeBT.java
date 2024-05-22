//serialize - convert tree to string
//deserialize - convert string to tree

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeSerializeBT {
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
        SerialDeSerialBT serialDeSerialBT = new SerialDeSerialBT();
        String str = serialDeSerialBT.getSerializedString(root);
        serialDeSerialBT.getDeserialNode(str);
    }

    private static class SerialDeSerialBT {
        private String getSerializedString(Node root) {
            StringBuilder string = new StringBuilder();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node cur = queue.poll();
                    if (cur == null) {
                        string.append("null ");
                        continue;
                    }
                    string.append(cur.data + " ");
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
            return string.toString();
        }

        private Node getDeserialNode(String str) {
            if (str.length() == 0 || str.charAt(0) == 'n')
                return null;
            Queue<Node> queue = new LinkedList<>();
            String[] nodes = str.split(" ");
            Node root = new Node(Integer.parseInt(nodes[0]));
            queue.add(root);
            for (int i = 1; i < nodes.length; i++) {
                Node parent = queue.poll();
                if (!nodes[i].equals("null")) {
                    Node left = new Node(Integer.parseInt(nodes[i]));
                    parent.left = left;
                    queue.add(parent.left);
                }
                if (!nodes[++i].equals("null")) {
                    Node right = new Node(Integer.parseInt(nodes[i]));
                    parent.right = right;
                    queue.add(parent.right);
                }
            }
            return root;
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
// we have to first serailize the given tree and then from deserailize the
// string and form the Binary tree...so in the serailizing what we do is Level
// order traversal.. put that in queue and if the node is null we have to add
// that nodes.data as a string with " " and then add nodes.left and nodes.right
// to queue.... if in case the node becomes null then we have to append "null "
// to string and we shouldn't add the left and right of it.

// In deserializing we have to obtain a string array first form the given
// string... then add arr[0] as root... after we create always add that node
// to queue.. the children of arr[0] will be arr[1] and arr[2] in same way child
// of arr[1] will arr[3] and arr[4]...so we get that parent from queue and check
// if it has children by comparing the string array then respectively add it to
// queue...only add if its a node