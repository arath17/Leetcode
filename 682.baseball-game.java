import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=682 lang=java
 *
 * [682] Baseball Game
 */

// @lc code=start
class Solution {
    public int calPoints(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        for(String op:ops){
            if(op.equals("C")){
                scores.remove(scores.size()-1);

            }
            else if(op.equals("D")){
                int previousScore = scores.get(scores.size()-1);
                scores.add(previousScore*2);

            }
            else if(op.equals("+")){
                int lastScore = scores.get(scores.size()-1);
                int secondLastScore = scores.get(scores.size()-2);
                scores.add(lastScore+secondLastScore);
            }
            else{
                scores.add(Integer.parseInt(op));
            }
        }
        
        int sum = 0;
        for(int score: scores){
            sum = sum+score;
        }

        return sum;
    }
}
// @lc code=end

