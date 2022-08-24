import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {        
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        result = new ArrayList<>();
        findLists(candidates, 0, target, list);
        return result;
    }

    public void findLists(int[] candidates, int index, int target, List<Integer> list) {
        if (target == 0) {
           result.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if( (i > index && candidates[i] == candidates[i-1] ) || (candidates[i]>target) ){
                continue;
            }
            list.add(candidates[i]);
            findLists(candidates, i+1, target-candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}
// @lc code=end
