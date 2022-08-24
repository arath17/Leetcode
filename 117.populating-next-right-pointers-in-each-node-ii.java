/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        Node crawler = root;
        q.offer(crawler);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            Node previousSibling = null;
            Node newSibling = null;
            for (int i = 0; i < levelNum; i++) {
                if(q.peek().left!=null)q.offer(q.peek().left);
                if(q.peek().right!=null)q.offer(q.peek().right);
                newSibling = q.poll();
                if(previousSibling!=null){
                    previousSibling.next = newSibling;
                }
                previousSibling = newSibling;
            }
        }
        return root; 
    }
}
// @lc code=end

