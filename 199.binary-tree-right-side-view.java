import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        insertRightSideValues(1,root,result);
        return result;
    }
    void insertRightSideValues(int level,TreeNode node,List<Integer> result){
        if(node==null)
            return;
        if(result.size()<level)
            result.add(node.val);
        insertRightSideValues(level+1, node.right, result);
        insertRightSideValues(level+1, node.left, result);
    }
}
// @lc code=end

