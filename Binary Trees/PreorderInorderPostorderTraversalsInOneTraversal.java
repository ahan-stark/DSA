import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderInorderPostorderTraversalsInOneTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        DepthSearch depthSearch = new DepthSearch();
        depthSearch.depthFirstSearch(root);
    }

    private static class DepthSearch {
        private void depthFirstSearch(Node root) {
            List<Integer> preOrder = new ArrayList<>();
            List<Integer> inOrder = new ArrayList<>();
            List<Integer> postOrder = new ArrayList<>();
            Stack<ElemComb> stack = new Stack<>();
            stack.push(new ElemComb(root, 1));
            while (!stack.isEmpty()) {
                ElemComb temp = stack.pop();
                if (temp.count == 1) {
                    preOrder.add(temp.node.data);
                    stack.push(new ElemComb(temp.node, 2));
                    if (temp.node.left != null) {
                        stack.push(new ElemComb(temp.node.left, 1));
                    }
                } else if (temp.count == 2) {
                    inOrder.add(temp.node.data);
                    stack.push(new ElemComb(temp.node, 3));
                    if (temp.node.right != null) {
                        stack.push(new ElemComb(temp.node.right, 1));
                    }
                } else {
                    postOrder.add(temp.node.data);
                }
            }
            System.out.println("Pre order : ");
            for (Integer val : preOrder) {
                System.out.println(val);
            }
            System.out.println("In order : ");
            for (Integer val : inOrder) {
                System.out.println(val);
            }
            System.out.println("Post order : ");
            for (Integer val : postOrder) {
                System.out.println(val);
            }
        }

    }

    private static class ElemComb {
        Node node;
        int count;

        public ElemComb(Node node, int count) {
            this.node = node;
            this.count = count;
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
