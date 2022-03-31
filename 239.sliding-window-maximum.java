import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxElements = new ArrayDeque<>();
        int[] results = new int[nums.length - k + 1];
        int ri = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!maxElements.isEmpty() && maxElements.peek() < i - k + 1) {
                maxElements.poll();
            }
            while (!maxElements.isEmpty() && nums[maxElements.peekLast()] < nums[i]) {
                maxElements.pollLast();
            }
            maxElements.offer(i);
            if(i-k+1>=0){
                results[ri++]=nums[maxElements.peek()];
            }
        }
        return results;
    }
}
// @lc code=end
