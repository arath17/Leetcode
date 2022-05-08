import java.util.HashMap;
import java.util.HashSet;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
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
    HashMap<Integer, Integer> sumMap;
    HashMap<Integer, HashSet<Integer>> frequencyMap;
    int highestFrequency = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        sumMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        subtreeSum(root);
        HashSet<Integer> resultSet = frequencyMap.get(highestFrequency);
        int[] resultArray = new int[resultSet.size()];
        int j = 0;
        for(int element:resultSet){
            resultArray[j++] = element;
        }
        return resultArray;
    }
    
    int subtreeSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum = root.val + subtreeSum(root.left) + subtreeSum(root.right);
        int frequency = sumMap.getOrDefault(sum, 0);
        frequency++;
        sumMap.put(sum,frequency);
        if(frequency>highestFrequency){
            highestFrequency = frequency;
        }
        HashSet<Integer> frequencySet = frequencyMap.getOrDefault(frequency, new HashSet<>());
        frequencySet.add(sum);
        frequencyMap.put(frequency,frequencySet);
        return sum;
    }
}
// @lc code=end

