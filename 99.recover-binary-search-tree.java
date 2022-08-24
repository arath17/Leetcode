import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    TreeNode pre = null, value1 = null, value2 = null;

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = value1.val;
        value1.val = value2.val;
        value2.val = temp;
    }

    void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (pre != null && pre.val > root.val) {
            if (value1 != null) {
                value2 = root;
                return;
            }
            value1 = pre;
            value2 = root;
        }
        pre = root;
        inorderTraversal(root.right);
    }
}
// @lc code=end
