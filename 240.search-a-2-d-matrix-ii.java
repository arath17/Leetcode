/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                end = mid - 1;
            }
            if (matrix[mid][0] < target) {
                start = mid + 1;
            }
        }
        int finalRow = matrix[mid][0] > target ? mid - 1 : mid;
        if(finalRow == -1){
            return false;
        }
        for(int i=0;i<=finalRow;i++){
           if(findTarget(matrix[i],target)){
               return true;
           } 
        }
        return false;
    }
    boolean findTarget(int[] searchArray,int target){
        int start = 0;
        int end = searchArray.length - 1;
        int mid = 0;
        while(start<=end){
            mid = (start+end)/2;
            if(searchArray[mid]==target)
                return true;
            if(searchArray[mid]>target)
                end = mid-1;
            if(searchArray[mid]<target)
                start =  mid+1;
        }
        return false;
    } 

}
// @lc code=end
