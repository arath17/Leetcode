import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    HashMap<Character,Integer> charsMap;
    public String frequencySort(String s) {
        charsMap = new HashMap<>();
        List<Character> charsList = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int count = charsMap.getOrDefault(c, 0);
            if(count == 0){
                charsList.add(c);
            }
            charsMap.put(c,count+1);
        }
        charsList.sort((a,b)->charsMap.get(b)-charsMap.get(a));
        String result = "";
        for(char c:charsList){
            int frequency = charsMap.get(c);
            for(int i = 0;i<frequency;i++){
                result = result + c;
            }
        }
        return result;
    }
}
// @lc code=end

