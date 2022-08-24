import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        List<String> wordLinkedList = new LinkedList<>(wordList);
        if(!wordList.contains(endWord)){
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1;
        int minLength = 0;
        List<String> subList = null;
        while(!queue.isEmpty() && !wordLinkedList.isEmpty()){
            int levelNum = queue.size();
            for(int i = 0;i < levelNum; i++){
                String word = queue.peek();
                for(int j = 0; i<wordLinkedList.size(); j++){
                    String comparedWord = wordLinkedList.get(j);
                    if((word.length() == comparedWord.length()) && compare(word, comparedWord) == 1 ){
                        wordLinkedList.remove(j);
                        j--;
                        queue.offer(comparedWord);
                    }
                }                
            }
        }
    }
    private int compare(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(c1!=c2){
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

