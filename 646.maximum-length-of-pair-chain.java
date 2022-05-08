import java.util.Arrays;

/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)->a[1]-b[1]);
        int length = 1;
        int cur = pairs[0][1];
        for(int i = 1;i<pairs.length; i++){
            if(cur<pairs[i][0]){
                length++;
                cur = pairs[i][1];
            }
        }
        return length;
    }
}
// @lc code=end

