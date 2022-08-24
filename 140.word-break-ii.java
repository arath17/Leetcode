import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();
        HashSet<String> dictSet = new HashSet<>();
        for (String word : wordDict) {
            dictSet.add(word);
        }
        returnWords(s, dictSet, 0, 0, results, "");
        return results;
    }

    public void returnWords(String s, HashSet<String> dict, int prev, int current, List<String> results,
            String resultString) {
        if (current == s.length() - 1) {
            if (dict.contains(s.substring(prev, current + 1))) {
                results.add((resultString + s.substring(prev, current + 1)).trim());
            }
            return;
        }
        String word = s.substring(prev, current + 1);
        if (dict.contains(word)) {
            returnWords(s, dict, current + 1, current + 1, results, resultString + word + " ");
        }
        returnWords(s, dict, prev, current + 1, results, resultString);
    }
}
// @lc code=end
