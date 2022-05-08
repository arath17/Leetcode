/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
            return board;
        }
        revealBoard(board,row,col);
        return board;
    }
    void revealBoard(char[][] board,int row,int col){
        if(board[row][col]!='E'){
            return;
        }
        int mineCount = 0;
        int initialRow = row-1< 0 ? 0 : row-1;
        int lastRow = row+1 == board.length ? row : row+1;
        int initialCol = col-1< 0 ? 0 : col-1;
        int lastCol = col+1 == board[0].length ? col : col+1;
        for(int i = initialRow ; i<=lastRow;i++){
            for(int j = initialCol; j<=lastCol; j++){
                if(!(i==row && j==col) && board[i][j]=='M'){
                    mineCount++;
                }
            }
        }
        if(mineCount != 0){
            board[row][col] = (char)(mineCount + 48);
            return;
        }
        board[row][col] = 'B';
        for(int i = initialRow ; i<=lastRow;i++){
            for(int j = initialCol; j<=lastCol; j++){
                if(!(i==row && j==col)){
                    revealBoard(board, i, j);
                }
            }
        }
    }
}
// @lc code=end

