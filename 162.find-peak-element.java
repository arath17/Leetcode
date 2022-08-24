/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        return binarySearch(nums, 0, nums.length-1);
    }

    public int binarySearch(int[] nums, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        String result = checkPeak(nums, mid);
        if(result.equals("PEAK")){
            return mid;
        }
        if(result.equals("LEFT")){
            return binarySearch(nums, start, mid-1);
        }
        return binarySearch(nums, mid+1, end);
    }

    public String checkPeak(int[] nums, int index){
        if(index == 0){
            if(nums[index]>nums[index+1]){
                return "PEAK";
            }
            return "RIGHT";
            
        }
        if(index == nums.length-1){
            if(nums[index]>nums[index-1]){
                return "PEAK";
            }
            return "RIGHT";
        }
        if(nums[index]>nums[index-1]&& nums[index]>nums[index+1]){
            return "PEAK";
        }
        if(nums[index]<nums[index+1]){
            return "RIGHT";
        }
        return "LEFT";
    }
}
// @lc code=end

