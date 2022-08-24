/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        if(target>=nums[0]){
            index = binarySearch(nums,target,1,0,nums.length-1);
        }
        else if(target<=nums[nums.length-1]){
            index  = binarySearch(nums,target,2,0,nums.length-1);
        }
        return index;
    }

    int binarySearch(int[] nums,int target,int pivot,int start,int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(nums[mid] == target)
            return mid;
        if(pivot == 1){
            if(nums[mid]<nums[0] || nums[mid]>target){
                return binarySearch(nums, target, pivot, start, mid-1);
            }
            if(nums[mid]<target){
                return binarySearch(nums, target, pivot, mid+1, end);
            }
        }
        if(pivot == 2){
            if(nums[mid]>nums[nums.length-1] || nums[mid]<target){
                return binarySearch(nums, target, pivot, mid+1, end);
            }
            if(nums[mid]>target){
                return binarySearch(nums, target, pivot, start, mid-1);
            }
        }
        return -1;
    }
}
// @lc code=end

