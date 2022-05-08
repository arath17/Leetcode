/*
 * @lc app=leetcode id=517 lang=java
 *
 * [517] Super Washing Machines
 */

// @lc code=start
class Solution {
    public int findMinMoves(int[] machines) {
        int totalDresses = 0;
        for(int dresses: machines){
            totalDresses = totalDresses + dresses;
        }
        if(totalDresses%machines.length != 0){
            return -1;
        }
        int requiredDresses = totalDresses / machines.length;
        int[] leftSum = new int[machines.length];
        int[] rightSum = new int[machines.length];
        int sum = 0;
        for(int i = 0;i<machines.length;i++){
            leftSum[i] = sum;
            sum = sum+machines[i];
        }
        sum = 0;
        for(int i = machines.length-1;i>=0;i--){
            rightSum[i] = sum;
            sum = sum+machines[i];
        }
        int max = 0;
        for(int i = 0;i<machines.length;i++){
            int expectedLeft = i*requiredDresses;
            int rightToLeft= leftSum[i] < expectedLeft ? (expectedLeft - leftSum[i]) : 0;
            int expectedRight = (machines.length - (i+1))*requiredDresses;
            int leftToRight = rightSum[i] < expectedRight ? (expectedRight - rightSum[i]) : 0;
            int totalMoves = rightToLeft + leftToRight;
            if(totalMoves > max){
                max = totalMoves;
            }
        }
        return max;
    }
}
// @lc code=end

