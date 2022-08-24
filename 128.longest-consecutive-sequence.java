import java.util.HashSet;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int best = 0;
        for(int num: nums){
            if(!set.contains(num-1)){
                int y = num;
                while(set.contains(y)){
                    y++;
                }
                best = Math.max(best,y-num);
            }
        }
        return best;
        
    }
}
// @lc code=end

