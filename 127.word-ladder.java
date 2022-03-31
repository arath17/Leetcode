import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        int n = beginWord.length();
        if (!wordSet.contains(endWord))
            return 0;

        int level = 1;
        int length = 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        length++;
        while (!q.isEmpty()) {
            length=q.size();
            for(int k=0;k<length;k++){
                String searchWord = q.poll();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 26; j++) {
                        if (searchWord.charAt(i) != 97 + j) {
                            String matchWord = searchWord.substring(0, i)
                                    + (char) (97 + j)
                                    + searchWord.substring(i + 1, n);
                            if (wordSet.contains(matchWord)) {
                                if (matchWord.equals(endWord)) {
                                    return level + 1;
                                }
                                wordSet.remove(matchWord);
                                q.add(matchWord);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
// @lc code=end
