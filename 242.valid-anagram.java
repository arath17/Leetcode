import java.util.HashMap;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sChars = new HashMap<>();
        HashMap<Character, Integer> tChars = new HashMap<>();
        int len = s.length();
        if(len != t.length())
            return false;
        for(int i = 0;i< len;i++){
            char c = s.charAt(i);
            sChars.put(c,sChars.getOrDefault(c, 0)+1);
        }
        for(int i = 0;i< len;i++){
            char c = t.charAt(i);
            tChars.put(c,tChars.getOrDefault(c, 0)+1);
        }
        return sChars.equals(tChars);
    }
}
// @lc code=end

