import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> uniqNums = new HashSet<>();
        HashSet<Integer> usedNums = new HashSet<>();

        if(k == 0){
            int count = 0;
            for(int num : nums){
                if(uniqNums.add(num)==false && !usedNums.contains(num)){
                    count++;
                    usedNums.add(num);
                }
            }
            return count; 
        }
        for(int num : nums){
            uniqNums.add(num);
        }

        int count = 0;
        for(int num : nums){
            if(!usedNums.contains(num)){
                if(uniqNums.contains(num+k)){
                    count++;
                }
                usedNums.add(num);
            }
        }

        return count;
        
    }
}
// @lc code=end

