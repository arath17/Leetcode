import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        int range=(1<<n); 
        List<Integer> graycodes=new ArrayList<>();
        for(int i=0;i<range;i++){
            graycodes.add(i^(i>>1));
        }
        return graycodes;
        
    }
}
// @lc code=end

