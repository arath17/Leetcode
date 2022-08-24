/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildBinaryTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildBinaryTree(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend) {
        if (pstart > pend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int i = 0;
        for ( i = istart; i <= iend; i++) {
            if (preorder[pstart] == inorder[i]) {
                break;
            }
        }
        int elementsOnLeft = i - istart;
        root.left = buildBinaryTree(preorder, inorder, pstart + 1, pstart + elementsOnLeft, istart, i - 1);
        root.right = buildBinaryTree(preorder, inorder, pstart + elementsOnLeft + 1, pend, i + 1, iend);
        return root;
    }

}
// @lc code=end
