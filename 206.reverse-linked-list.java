/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pointer = head;
        ListNode prev = null;
        while(pointer!=null){
            ListNode nextPointer = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = nextPointer;
        }
        return prev;      
    }
}
// @lc code=end

