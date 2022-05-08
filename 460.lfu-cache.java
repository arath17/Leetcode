import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start
class LFUCache {
    int capacity;
    int count;
    HashMap<Integer, Node> cache;
    HashMap<Integer, Node> endpoints;
    Node head;
    Node tail;

    class Node {
        int key;
        int value;
        int frequency = 0;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    void poll() {
        Node top = head.next;
        if (top == endpoints.get(top.frequency)) {
            endpoints.remove(top.frequency);
        }
        deleteNode(top);
        cache.remove(top.key);
    }

    void moveNodeToAnotherendpoint(Node node) {
        if(node == endpoints.get(node.frequency-1)){
            if(node.prev.frequency == node.frequency-1){
                endpoints.put(node.frequency-1,node.prev);
            }else{
                endpoints.remove(node.frequency-1);
            }
        }
        deleteNode(node);
        Node endpoint = endpoints.get(node.frequency);
        insertNodeAfterendpoint(node, endpoint);
    }

    void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    void insertNodeAfterendpoint(Node node, Node endpoint) {
        if (endpoint == null) {
            pushNodeToLast(node);
        } else {
            node.next = endpoint.next;
            endpoint.next = node;
            node.prev = endpoint;
            node.next.prev = node;
        }
        endpoints.put(node.frequency, node);
    }

    void pushNodeToLast(Node node) {
        tail.prev.next = node;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;

        cache = new HashMap<>();
        head = new Node(-1, 0);
        tail = new Node(-1, 0);
        head.next = tail;
        tail.prev = head;
        head.frequency = 0;
        tail.frequency = 0;
        endpoints = new HashMap<>();

    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        node.frequency = node.frequency + 1;
        moveNodeToAnotherendpoint(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node == null) {
            if (count == capacity) {
                poll();
                count--;
            }
            node = new Node(key, value);
            Node endpoint = endpoints.getOrDefault(1, head);
            insertNodeAfterendpoint(node, endpoint);
            count++;
        } else {
            node.value = value;
            node.frequency = node.frequency + 1;
            moveNodeToAnotherendpoint(node);
        }
        cache.put(key, node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
