/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1 || nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        return findMin(nums,0,nums.length-1);
    }

    int findMin(int[] nums,int start,int end){
        int mid = (start + end)/2;
        if(nums[mid] >= nums[0]){
            return findMin(nums,mid+1,end);
        }
        if(nums[mid-1]> nums[mid]){
            return nums[mid];
        }
        return findMin(nums,start,mid-1);
    }
}
// @lc code=end

