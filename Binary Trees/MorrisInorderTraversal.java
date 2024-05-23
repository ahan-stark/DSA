public class MorrisInorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        MorrisTraversal traversal = new MorrisTraversal();
        traversal.morrisInorder(root);
    }

    private static class MorrisTraversal {
        private void morrisInorder(Node root) {
            Node cur = root;
            while (cur != null) {
                if (cur.left == null) {
                    System.out.println(cur.data);
                    cur = cur.right;
                } else {
                    Node prev = cur.left;
                    while (prev.right != null && prev.right != cur) {
                        prev = prev.right;
                    }
                    if (prev.right == null) {
                        prev.right = cur;
                        cur = cur.left;
                    }
                    // this is for already present thread prev.right == cur
                    // thread already created and traversed
                    else {
                        System.out.println(cur.data);
                        prev.right = null;
                        cur = cur.right;
                    }
                }
            }
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
// in the morris traversal we dont use any stack or recursion... what we do is
// threading... in the root node before going to left make sure u create a
// thread of left of go to extreme right end and create a thread to cur
// root...this is how we can create a thread so that we can go left and also
// come back to root again... there will be two imp possibilities... one is if
// the left part is not there so for the inorder we have to print the root and
// go right.. if in case we have left side of root.. so we have to make left ->
// right extreme end to connect root.... and then go left then if we see in left
// it doesnt have left again..so we print that root..then we go right if in case
// when we go right that is through thread.. that cur if we check if it has left
// but already traversed we shouldnt go left again so that is why we check for
// that cur in left->right extreme end is connect to that cur only.. if that is
// the case then it is already traversed..so in while(prev.right != null
// &&prev.right != cur) will terminate and we check if it was teminated cz of
// prev.right == cur ... so we print that root and go left..print the elements
// if left is null then root is printed.. and if the left part is already
// threaded(traversed) then print the cur root and go right