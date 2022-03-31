import java.util.HashSet;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
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
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode walker=head;
        ListNode runner=head;
        while(runner.next!=null && runner.next.next!=null){
            walker=walker.next;
            runner=runner.next.next;
            if(walker==runner)
                return true;
        }
        return false;
        
    }
}
// @lc code=end

