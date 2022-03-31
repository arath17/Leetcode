/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int multiplier = nums[n-1];
        nums[n-1] = 1;
        res[n-1] = res[n-1]*nums[n-1];
        int temp = 0; 
        for (int i = n - 2; i >= 0; i--) {
            temp  = nums[i];
            nums[i] = nums[i+1]*multiplier;
            res[i] = res[i]*nums[i];
            multiplier = temp;
        }
        return res;
    }
}
// @lc code=end
