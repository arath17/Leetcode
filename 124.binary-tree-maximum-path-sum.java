/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    public int maxPathSum(TreeNode root) {
        return maxPathSum(root, 0);
    }

    int maxPathSum(TreeNode root, int currentSum) {
        if (root == null) {
            return currentSum;
        }
        return Math.max(Math.max(maxPathSum(root.left, currentSum + root.val), maxPathSum(root.left, 0)),
                Math.max(maxPathSum(root.right, root.val + currentSum), maxPathSum(root.right, 0)));

    }
}
// @lc code=end
