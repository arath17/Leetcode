/*
 * @lc app=leetcode id=553 lang=java
 *
 * [553] Optimal Division
 */

// @lc code=start
class Solution {
    public String optimalDivision(int[] nums) {
        String result = "";
        if(nums.length == 1){
            return result+nums[0];
        }
        if(nums.length == 2){
            return result+nums[0]+"/"+nums[1];
        }
        for(int i = 0;i<nums.length;i++){
            if(i==1){
              result = result + "(";
            }
            result = result+nums[i];
            if(i==nums.length-1){
                result = result+")";
            }else{
                result = result+"/";
            }
        }
        return result;
    }
}
// @lc code=end
