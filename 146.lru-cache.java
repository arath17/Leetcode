import java.util.HashMap;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    class Node{
        int key;
        int val;
        Node post;
        Node pre;
    }

    public void deleteNode(Node node){
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    public void addNode(Node node){
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    public void moveToHead(Node node){
        deleteNode(node);
        addNode(node);
    }

    public Node popTail(){
        Node node = tail.pre;
        deleteNode(node);
        return node;
    }

    private HashMap<Integer, Node> cache=new HashMap<>();
    private Node head,tail;
    private int capacity,count;
    public LRUCache(int capacity){
        this.count = 0;
        this.capacity=capacity;
        head=new Node();
        tail=new Node();
        
        head.pre=null;
        head.post=tail;
        
        tail.pre=head;
        tail.post=null;
    }

    public int get(int key){
        Node resultNode=cache.get(key);
        if(resultNode==null){
            return -1;
        }
        moveToHead(resultNode);
        return resultNode.val;
    }

    public void put(int key,int val){
        
        Node cacheHit = cache.get(key);
        if(cacheHit == null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = val;
            addNode(newNode);
            cache.put(key, newNode);
            ++count;

            if(count>capacity){
               Node leastRecentNode = popTail();
               cache.remove(leastRecentNode.key);
               --count;
            }

        }else{
            cacheHit.val = val;
            moveToHead(cacheHit);
        } 
    }
   }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

