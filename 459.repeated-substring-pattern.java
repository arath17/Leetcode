/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = length / 2; i >= 1; i--) {
          if(length%i==0){
              String sequence = s.substring(0, i);
              String repeatSequence = new String(sequence);
              for(int j = 1 ; j<length/i ; j++){
                  repeatSequence = repeatSequence + sequence; 
              }
              if(repeatSequence.equals(s)){
                  return true;
              }
          }  
        }
        return false;
    }
}
// @lc code=end
