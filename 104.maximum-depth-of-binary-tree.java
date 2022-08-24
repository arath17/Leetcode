/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root,0);
    }

    int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(maxDepth(root.left, 1 + depth), maxDepth(root.right, 1 + depth));
    }
}
// @lc code=end
