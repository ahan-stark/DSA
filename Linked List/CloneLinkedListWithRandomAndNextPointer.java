import java.util.HashMap;

public class CloneLinkedListWithRandomAndNextPointer {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = null;
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;
        head.random = node4;
        head.next.random = node1;
        head.next.next.random = null;
        head.next.next.next.random = node2;
        Node betterApproachNode = solution.betterApproach(head);
        System.out.println("Better Approach : ");
        while (betterApproachNode != null) {
            System.out.println("Data : " + betterApproachNode.data);
            System.out.println("Next Node : " + betterApproachNode.next);
            System.out.println("Random Node " + betterApproachNode.random);
            System.out.println();
            betterApproachNode = betterApproachNode.next;
        }
        System.out.println("Optimal Solution : ");
        Node optimalSolNode = solution.optimalApproach(head);
        while (optimalSolNode != null) {
            System.out.println("Data : " + optimalSolNode.data);
            System.out.println("Next Node : " + optimalSolNode.next);
            System.out.println("Random Node " + optimalSolNode.random);
            System.out.println();
            optimalSolNode = optimalSolNode.next;
        }
    }

    private static class Solution {
        private Node betterApproach(Node head) {
            HashMap<Node, Node> map = new HashMap<>();
            Node cur = head;
            // create a deep copies for the nodes individualy and put it with original node
            while (cur != null) {
                Node node = new Node(cur.data);
                map.put(cur, node);
                cur = cur.next;
            }
            cur = head;
            // for every node stored with deepcopy as values, get the deepcopy and assign
            // the next and random individually
            while (cur != null) {
                Node node = map.get(cur);
                node.next = map.get(cur.next) != null ? map.get(cur.next) : null;
                node.random = map.get(cur.random) != null ? map.get(cur.random) : null;
                cur = cur.next;
            }
            return map.get(head);
        }

        private Node optimalApproach(Node head) {
            Node cur = head;
            Node addNode = null;
            Node nextNode = null;
            // create the deep copies in between of the nodes
            while (cur != null) {
                addNode = new Node(cur.data);
                nextNode = cur.next;
                cur.next = addNode;
                addNode.next = nextNode;
                cur = cur.next.next;
            }
            cur = head;
            // For each original node, we have a corresponding copy node in the next
            // pointer. To establish the random pointer connections, we connect the copy
            // node's random pointer to the next node of the original node's random pointer.
            while (cur != null) {
                Node randomPointer = cur.random;
                if (cur.random != null)
                    cur.next.random = randomPointer.next;
                cur = cur.next.next;
            }
            Node newNode = new Node(-1);
            Node newNodecur = newNode;
            cur = head;
            // segregate the copy node seperately as newNode
            while (cur != null) {
                newNodecur.next = cur.next;
                newNodecur = newNodecur.next;
                cur.next = cur.next.next;
                cur = cur.next;
            }
            return newNode.next;
        }
    }

    private static class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
            next = null;
            random = null;
        }
    }
}
