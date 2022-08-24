import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;

    }

    void backtrack(List<String> result, String output, int open,int close, int n){
        if(output.length()==2*n){
            result.add(output);
            return;
        }
        if(open<n){
            backtrack(result, output+"(", open+1, close, n);
        }
        if(close<open){
            backtrack(result, output+")", open, close+1, n);
        }
    }
}
// @lc code=end

