/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder reverse = new StringBuilder(s).reverse();
        int length = s.length();
        
        int lcs[][] = new int[length+1][length+1];

        for(int i = 1;i<=length;i++){
            for(int j = 1;j<=length; j++){
                if(s.charAt(i-1) == reverse.charAt(j-1)){
                    lcs[i][j]=1+lcs[i-1][j-1];
                }
                else{
                    lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        return lcs[length][length];
        
    }
}
// @lc code=end

