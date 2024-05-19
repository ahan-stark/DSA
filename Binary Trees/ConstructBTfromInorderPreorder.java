import java.util.HashMap;
import java.util.Map;

public class ConstructBTfromInorderPreorder {
    public static void main(String[] args) {
        int preOrder[] = { 10, 20, 40, 50, 30, 60 };
        int inOrder[] = { 40, 20, 50, 10, 60, 30 };
        CreateBT createBT = new CreateBT();
        createBT.createBTfrmINPRE(inOrder, preOrder);

    }

    private static class CreateBT {
        private Node createBTfrmINPRE(int[] inOrder, int[] preOrder) {
            Map<Integer, Integer> inOrderMap = new HashMap<>();
            for (int i = 0; i < inOrder.length; i++) {
                inOrderMap.put(inOrder[i], i);
            }
            int preStart = 0, preEnd = preOrder.length - 1, inStart = 0, inEnd = inOrder.length - 1;
            Node tree = createTree(preStart, preEnd, preOrder, inStart, inEnd, inOrder, inOrderMap);
            return tree;
        }

        private Node createTree(int preStart, int preEnd, int[] preOrder, int inStart,
                int inEnd, int[] inOrder, Map<Integer, Integer> inOrderMap) {
            if (preStart > preEnd || inStart > inEnd)
                return null;
            Node root = new Node(preOrder[preStart]);
            int inRoot = inOrderMap.get(root.data);
            int leftNodes = inRoot - inStart;
            root.left = createTree(preStart + 1, preStart + leftNodes, preOrder, inStart, inRoot - 1, inOrder,
                    inOrderMap);
            root.right = createTree(preStart + leftNodes + 1, preEnd, preOrder, inRoot + 1, inEnd, inOrder, inOrderMap);
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
// in this problem we have to create a binary tree using the inorder and
// preorder... what we do is ..we have to have pointers in inorderStart
// inorderLast and preorderStart preorderLast...we take preOrder first one as
// the root bcz the preOrder first elem is always root...next we use recursive
// to find root.left and root.right... here how we find is left and right ... we
// get the total nodes in left sid and right side of that root using the inorder
// array.. the point we get that preorder elem in hashMap of inOrder.. that
// point left side everything belongs to leftPart and rightSide belong to
// rightPart... we have to rearrange the points of everything again for
// respectiovce left and right roots and change in inorder and preorder... the
// moment start exceeds the inorder array or preOrder array then we get to know
// that it is out of index hence return null..the inOrder is maintained in
// hashMap with index as values so we can get that index when we have that
// particular node