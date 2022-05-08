/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    public String tree2str(TreeNode root) {
        if(root == null){
            return "";
        }
        String rootString = ""+root.val;
        String left = "("+tree2str(root.left)+")";
        String right = "("+tree2str(root.right)+")";
        if(left.equals("()") && right.equals("()")){
            left = "";
            right = "";
        }
        else if(right.equals("()")){
            right = "";
        }
        return rootString+left+right;
    }
}
// @lc code=end

