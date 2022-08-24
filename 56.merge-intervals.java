import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
       int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];
        int lastIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = result[lastIndex];
            if(intervals[i][0]<=lastInterval[1]){
                if(intervals[i][1]>lastInterval[1]){
                    lastInterval[1] = intervals[i][1];
                }
            }
            else{
                result[++lastIndex] = intervals[i];
            }
        }
        return Arrays.copyOf(result,lastIndex+1);
    }
}
// @lc code=end
