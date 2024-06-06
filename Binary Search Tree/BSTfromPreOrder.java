import java.util.Stack;

public class BSTfromPreOrder {
    public static void main(String[] args) {
        int[] preOrder = { 8, 5, 1, 7, 10, 12 };
        CreateBST bst = new CreateBST();
        Node createdBST = bst.getBST(preOrder);
        System.out.println(createdBST);
    }

    private static class CreateBST {
        private Node getBST(int[] preOrder) {
            if (preOrder.length == 0)
                return null;
            Stack<Node> stack = new Stack<>();
            Node root = new Node(preOrder[0]);
            stack.push(root);
            for (int i = 1; i < preOrder.length; i++) {
                Node currentNode = new Node(preOrder[i]);
                if (preOrder[i] < stack.peek().data) {
                    stack.peek().left = currentNode;
                } else {
                    Node parent = null;
                    while (!stack.isEmpty() && preOrder[i] > stack.peek().data) {
                        parent = stack.pop();
                    }
                    parent.right = currentNode;
                }

                stack.push(currentNode);
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
// in this we know it is preorder so arr[0] will be root then we add this to
// stack...then we loop from 1 to n -1...we check the cur -> arr[i] is less than
// stack.peek().. if true.. we need to create a Node with arr[i] and assign it
// to stack.peek().left... if the arr[i] is greater than stack.peek() so we need
// to pop the elems out untill we get smaller then the last poped() will be
// parent Node then add parent.right = arr[i];

// we can also use the normal way that is using preorder and inorder then
// creating BST out of it..since only preorder is given.. in BST the sorted form
// is always in inorder traversal...so sort the entire preorder to get inorder
// .. so with this we create the BST