import java.util.ArrayList;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    public int widthOfBinaryTree(TreeNode root) {
        int maxNodes = 3000;
        long[][] levels = new long[maxNodes][2];
        findAllLevels(root, 1, 0, levels);
        long highestLevelWidth = 0;
        long highestWidth = 0;
        for(int i = 0;i<maxNodes;i++){
            if(levels[i][0] == 0){
                break;
            }
            highestLevelWidth = levels[i][1]-levels[i][0]+1;
            if(highestLevelWidth>highestWidth){
                highestWidth = highestLevelWidth;
            }
        }
        return (int)(highestWidth);
    }

    void findAllLevels(TreeNode node, long nodeValue, int level, long[][] levels) {
        if (node == null) {
            return;
        }
        if (levels[level][0] == 0 || nodeValue < levels[level][0]) {
            levels[level][0] = nodeValue;
        }
        if (levels[level][1] == 0 || nodeValue > levels[level][1]) {
            levels[level][1] = nodeValue;
        }
        findAllLevels(node.left, nodeValue*2, level+1, levels);
        findAllLevels(node.right, (nodeValue*2)+1, level+1, levels);
    }
}
// @lc code=end
