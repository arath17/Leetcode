/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        treeToList(root);
    }
    TreeNode treeToList(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode flattenedLeftChild = treeToList(root.left);
        TreeNode flattenedRightChild = treeToList(root.right);
        root.right = flattenedLeftChild;
        root.left = null;
        while(flattenedLeftChild!=null && flattenedLeftChild.right!=null){
            flattenedLeftChild = flattenedLeftChild.right;
        }
        if(flattenedLeftChild!=null){
            flattenedLeftChild.right = flattenedRightChild;
            return root;
        }
        root.right = flattenedRightChild;
        return root;
    }
}
// @lc code=end

