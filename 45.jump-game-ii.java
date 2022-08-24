/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp=new int[nums.length];
        for(int i = 0; i<dp.length;i++){
            dp[i] = -1;
        }
        return minJumps(nums,0);
    }
    int minJumps(int[] nums,int position){
        if(dp[position]!=-1){
            return dp[position];
        }
        int MAX_STEPS = nums.length;
        if(position == nums.length-1){
            dp[position] = 0;
            return dp[position];
        }
        if(nums[position] == 0){
            dp[position] = MAX_STEPS;
            return dp[position];
        }
        int min = MAX_STEPS;
        int maxSteps = Math.min(nums[position],nums.length - position -1);
        for(int i = 1;i<=maxSteps;i++){
            min = Math.min(min, 1+minJumps(nums, position+i));
        }
        dp[position] = min;
        return dp[position];
    }
}
// @lc code=end

