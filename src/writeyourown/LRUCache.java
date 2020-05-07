package writeyourown;

import java.util.Map;

/**
 * LRU cache makes sure that the "Least Recently Used" items are evicted, when there is no more space in the cache left.
 * LRU is a cache with limited cacptity
 */
public class LRUCache {

    class Node {

        Node prev;
        Node next;

        int key;
        int value;

        Node() {
           this(0,0);
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + " - " + value;
        }

    }

    private final int CAPACITY;

    private int index;

    private Map<Integer, Node> map;

    private Node head;

    private Node tail;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        index = -1;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if(n == null) {
            return -1;
        }
        update(n);
        return n.value;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if(n == null) {
            n = new Node(key, value);
            add(n);
            map.put(key, n);
            index++;

            if(index == CAPACITY) {
                Node last = tail.prev;
                System.err.println("Capacity threshold reached, evicting key - " + last.key);
                delete(last);
                index--;
                map.remove(last.key);
            }
        } else {
            n.value = value;
        }
    }

    private void update(Node n) {
        delete(n);
        add(n);
    }

    private void add(Node n) {
        Node next = head.next;
        n.next = next;
        next.prev = n;
        head.next = n;
        n.prev = head;
    }

    private void delete(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
        n.next = null;
        n.prev = null;
    }

    public String toString() {
        return map.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4); //evicts 1
        System.out.println(cache);
        System.out.println(cache.get(1)); //should return -1
        System.out.println(cache.get(2)); //returns 2, makes sure 2 is recently used
        cache.put(5, 5); //evicts 3
        System.out.println(cache.get(3));
        System.out.println(cache);
    }
}
