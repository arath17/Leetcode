import java.util.Arrays;

/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for ( i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1])
                break;
        }
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int j = nums.length - 1; j >= i + 1; j--) {
            if (nums[i] < nums[j]) {
                swap(nums, i, j);
                break;              
            }
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
// @lc code=end
