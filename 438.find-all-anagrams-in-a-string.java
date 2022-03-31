import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        List<Integer> result = new ArrayList<>();
        if (slen < plen)
            return result;
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < plen; i++) {
            char c = p.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
            if(i>=plen){
                char leftChar = s.charAt(i-plen);
                int count = sMap.get(leftChar);
                if(count == 1){
                    sMap.remove(leftChar);
                }
                else{
                    sMap.put(leftChar,count-1);
                }
            }
            if(i>=plen-1 && pMap.equals(sMap)){
                result.add(i-plen+1);
            }
        }
        return result;

    }
}
// @lc code=end
