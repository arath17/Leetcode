import java.util.ArrayList;

/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        ArrayList<Integer> maxElements = new ArrayList<>(3);
        maxElements.add(nums[0]);
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            for(j = 0;j < maxElements.size();j++ ){
                if(maxElements.get(j)<nums[i]){
                    maxElements.add(j,nums[i]);
                    break;
                }
                if(maxElements.get(j)==nums[i]){
                    break;
                }
            }
            if(maxElements.size()>3){
                maxElements.remove(3);
            }
            else if(maxElements.size()<3 && j == maxElements.size()){
                maxElements.add(nums[i]);
            }
        }
        return maxElements.size()<3?maxElements.get(0):maxElements.get(2);
    }
}
// @lc code=end
