/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        StringBuilder input = new StringBuilder(s);
        StringBuilder reverseInput = input.reverse();
        int length = input.length();
        
        int lcs[][] = new int[length+1][length+1];

        for(int i=0;i<=length;i++){
            for(int j=0;j<=length;j++){
                if(i==0 || j==0){
                    lcs[i][j]=0;
                }
            }
        }

        for(int i = 1;i<=length;i++){
            for(int j = 1;j<=length; j++){
                if(input.charAt(i) == reverseInput.charAt(j)){
                    lcs[i][j]=lcs[i-1][j-1];
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

