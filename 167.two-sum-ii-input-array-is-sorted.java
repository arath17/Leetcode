/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length-1;
        while(numbers[hi]+numbers[lo]!=target){
            if(numbers[hi]+numbers[lo]>target){
                hi--;
            }else{
                lo++;
            }
        }
        int result[]=new int[2];
        result[0] =lo+1;
        result[1]=hi+1;

        return result;
        
    }
}
// @lc code=end

