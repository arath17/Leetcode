/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length == 0){
            return result;
        }
        result[0] = findFirstTargetElement(nums, target, 0, nums.length-1);
        if(result[0] == -1){
            return result;
        }
        if((result[0] == nums.length - 1) || nums[result[0] + 1]!=target ){
            result[1] = result[0];
            return result;
        }
        result[1] = findLastTargetElement(nums, target, result[0]+1, nums.length-1);
        return result;
    }

    public int findFirstTargetElement(int[] nums,int target,int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if((nums[mid] == target) && (mid == 0 || nums[mid-1]!=target) ){
            return mid;
        }
        if(nums[mid] >= target){
            return findFirstTargetElement(nums, target, start, mid-1);
        }
        return findFirstTargetElement(nums, target, mid+1, end);
    }

    public int findLastTargetElement(int[] nums,int target,int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if((nums[mid] == target) && (mid == nums.length - 1 || nums[mid+1]!=target) ){
            return mid;
        }
        if(nums[mid] <= target){
            return findLastTargetElement(nums, target, mid+1, end);
        }
        return findLastTargetElement(nums, target, start, mid-1);
    }
}
// @lc code=end
