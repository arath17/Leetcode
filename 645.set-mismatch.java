import java.util.HashSet;

/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> uniq = new HashSet<>();
        int[] result = new int[2];
        int sum = 0;
        for(int num: nums){
            if(!uniq.add(num)){
                result[0]=num;
            }
            else{
                sum = sum+num;
            }
        }

        result[1] = (nums.length*(nums.length+1))/2 - sum;
        return result;
    }
}
// @lc code=end

