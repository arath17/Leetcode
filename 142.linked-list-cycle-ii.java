/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        ListNode walker=head;
        ListNode runner=head;
        boolean cyclePresent=false;
        while(runner.next!=null && runner.next.next!=null){
            walker=walker.next;
            runner=runner.next.next;
            if(walker==runner){
                cyclePresent=true;
                break;
            }
        }
        if(cyclePresent){
            walker=head;
            while(walker!=runner){
                walker=walker.next;
                runner=runner.next;
            }
            return walker;
        }
        return null;

        
    }
}
// @lc code=end

