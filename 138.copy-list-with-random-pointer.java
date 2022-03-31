import java.util.HashMap;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       HashMap<Node,Node> visited=new HashMap<>();
       Node deepCopy=deepCopy(head,visited);
       return deepCopy;
    }
    public Node deepCopy(Node node,HashMap<Node,Node> visited){
        if(node==null){
            return null;
        }
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node copy=new Node(node.val);
        visited.put(node,copy);
        copy.next=deepCopy(node.next,visited);
        copy.random=deepCopy(node.random, visited);
        return copy;
    }
}
// @lc code=end

