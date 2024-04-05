import java.util.HashMap;

public class ImplementLRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(cache.get(1)); // return 1
        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(cache.get(1)); // return -1 (not found)
        System.out.println(cache.get(3)); // return 3
        System.out.println(cache.get(4)); // return 4

    }

    private static class LRUCache {
        HashMap<Integer, Node> map = new HashMap<>();
        int capacity;
        Node head;
        Node tail;

        LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void put(int key, int val) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            if (map.size() == capacity) {
                remove(tail.prev);
            }
            insert(new Node(key, val));
        }

        private int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                insert(node);
                return node.val;
            } else {
                return -1;
            }
        }

        private void insert(Node node) {
            map.put(node.key, node);
            Node nextNode = head.next;
            head.next = node;
            node.next = nextNode;
            nextNode.prev = node;
            node.prev = head;
        }

        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    static class Node {
        int key, val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
}
// in the LRU - lease recently used cache, if we put element 'a' it should in
// first place and , the moment we put element 'b' ity should be in first place
// and now element 'a' will be in second place, the least recently used element
// will be in first place always, same happens in case of get(), so if the
// capacity of the LRU is exceded then we remove last one element, insertion
// always happens at head.next

// this is done using Doubly Linked List, we initialize two ndoe head and tail
// as dummy ones, the if we put any element it will added after the head, and in
// case if the capacity is full then remove from tail.prev

// we store the inserted elements in hashmap, so that we can retrive the nodes
// easily if in case we need to remove the node, we store the key and that
// particular Node