import java.util.List;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BSTIterator {
    List<Integer> result;
    int index;

    public BSTIterator(TreeNode root) {
        result = new ArrayList<>();
        index = 0;
        result.add(-1);
        inorderTraversal(root);
        result.set(0, result.get(0) - 1);
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
    }

    public int next() {
        return result.get(++index);
    }

    public boolean hasNext() {
        return index + 1 < result.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end
