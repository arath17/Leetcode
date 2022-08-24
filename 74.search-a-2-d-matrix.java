/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = findRowToSearch(matrix,target,0,matrix.length-1);
        if(rowIndex == -1){
            return false;
        }
        if(matrix[rowIndex][0] == target){
            return true;
        }
        return isElementPresentInRow(matrix[rowIndex], target, 1, matrix[rowIndex].length -1 );
    }

    public int findRowToSearch(int[][] matrix,int target,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if(matrix[mid][0] <= target && (mid == matrix.length -1 || matrix[mid+1][0] > target )){
            return mid;
        }
        if(matrix[mid][0] < target ){
            return findRowToSearch(matrix, target, mid+1, end);
        }
        return findRowToSearch(matrix, target, start, mid-1);
    }

    public boolean isElementPresentInRow(int[] row,int target,int start,int end){
        if(start > end){
            return false;
        }
        int mid = (start + end)/2;
        if(row[mid] == target){
            return true;
        }
        if(row[mid]<target){
            return isElementPresentInRow(row, target, mid+1, end);
        }
        return isElementPresentInRow(row, target, start, mid-1);
    }
}
// @lc code=end

