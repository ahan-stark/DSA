import java.util.HashMap;
import java.util.Map;

public class ConstructBTfromInorderPostorder {
    public static void main(String[] args) {
        int postOrder[] = { 40, 50, 20, 60, 30, 10 };
        int inOrder[] = { 40, 20, 50, 10, 60, 30 };
        CreateBT createBT = new CreateBT();
        createBT.createBTfrmINPOST(inOrder, postOrder);

    }

    private static class CreateBT {
        private Node createBTfrmINPOST(int[] inOrder, int[] postOrder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inOrder.length; i++) {
                map.put(inOrder[i], i);
            }
            int postStart = 0, postEnd = postOrder.length - 1, inStart = 0, inEnd = inOrder.length - 1;
            Node tree = createTree(postStart, postEnd, postOrder, inStart, inEnd, inOrder, map);
            return tree;

        }

        private Node createTree(int postStart, int postEnd, int[] postOrder, int inStart,
                int inEnd, int[] inOrder, Map<Integer, Integer> map) {
            if (postStart > postEnd || inStart > inEnd)
                return null;
            Node root = new Node(postOrder[postEnd]);
            int inRoot = map.get(root.data);
            int leftNodes = inRoot - inStart;
            root.left = createTree(postStart, postStart + leftNodes - 1, postOrder, inStart, inRoot - 1, inOrder, map);
            root.right = createTree(postStart + leftNodes, postEnd - 1, postOrder, inRoot + 1, inEnd, inOrder, map);
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
// in this problem we have to create BT from postOrder and inOrder... we have to
// take pointers postStart, postEnd, inStart, inEnd, we take postEnd at first
// and create an root, because in postOrder we have LRRoot, so we take postEnd,
// then we will have hashMap with inorder as key and index as values, so after
// we create root that is postEnd, we create root.left & root.right, from the
// map we take the postEnd and in inorder map wherever we found postEnd, the
// left of it will be in root.left and right side will be in root.right... Now
// change the pointers accordingly and recursively find root.left and
// root.right. Since its postOrder, make sure postEnd is not considered for next
// recursion. Do it untill postStart > postEnd or inStart > inEnd
// Solve this while seeing and checking the values in arrays