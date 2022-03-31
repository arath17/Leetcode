import java.util.HashMap;

/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    class Node{
        int index;
        Node next;
        Node(int index){
            this.index = index;
        }
    }
    Node head ;
    Node tail ;
    HashMap<Character, Node> charsMap;
    public int firstUniqChar(String s) {
        charsMap = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            Node newNode = new Node(i);
            Node toBeDeleted = charsMap.putIfAbsent(c, tail);
            if(toBeDeleted == null){
                insertNode(newNode);
            }
            else if(toBeDeleted.index!=-1){
                deleteNode(toBeDeleted, s);
            }
        }
        return head.next.index;
    }
    void insertNode(Node node){
        tail.next = node;
        tail.index = node.index;
        node.index = -1;
        tail = node;
    }
    void deleteNode(Node node, String s){
        int deleteIndex = node.index;
        node.index = node.next.index;
        node.next = node.next.next;
        if(node.index == -1){
            tail = node;
        }
        else{
            charsMap.put(s.charAt(node.index), node);
        }
        charsMap.put(s.charAt(deleteIndex),new Node(-1));
    }
}
// @lc code=end

