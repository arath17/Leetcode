/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && findWord(board, i, j, word, 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean findWord(char[][] board, int i, int j, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        char charToFind = word.charAt(wordIndex);
        // move left
        if (j - 1 >= 0 && board[i][j - 1] == charToFind && findWord(board, i, j - 1, word, wordIndex + 1)) {
            return true;
        }

        // move right
        if (j + 1 < board[0].length && board[i][j + 1] == charToFind
                && findWord(board, i, j + 1, word, wordIndex + 1)) {
            return true;
        }

        // move top
        if (i - 1 >= 0 && board[i - 1][j] == charToFind && findWord(board, i - 1, j, word, wordIndex + 1)) {
            return true;
        }

        // move bottom
        if (i + 1 < board.length && board[i + 1][j] == charToFind && findWord(board, i + 1, j, word, wordIndex + 1)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}
// @lc code=end
