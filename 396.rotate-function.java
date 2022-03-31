/*
 * @lc app=leetcode id=396 lang=java
 *
 * [396] Rotate Function
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int sum = 0;
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            f[0] = f[0] + (i * nums[i]);
            sum = sum + nums[i];
        }
        int max = f[0];
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + (sum - (n * nums[n - i]));
            if(f[i]>max){
                max=f[i];
            }
        }
        return max;
    }
}
// @lc code=end
