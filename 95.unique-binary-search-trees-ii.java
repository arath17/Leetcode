import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }

    List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }
        for (int currentRootValue = start; currentRootValue <= end; currentRootValue++) {
            List<TreeNode> leftSubTrees = generateTrees(start,currentRootValue-1);
            List<TreeNode> rightSubTrees = generateTrees(currentRootValue+1,end);
            for(TreeNode leftSubTree : leftSubTrees){
                for(TreeNode rightSubTree: rightSubTrees){
                    TreeNode root = new TreeNode(currentRootValue,leftSubTree,rightSubTree);
                    result.add(root);                    
                }
            }
        }
        return result;
    }
}
// @lc code=end
