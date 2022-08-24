/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head,prev=null,next=null,chain=null;
        int i = 0;
        while(curr!=null){
            next = curr.next;
            if(i%2!=0){
                prev.next = next;
                curr.next = prev;
                if(chain!=null){
                     chain.next = curr;
                }
                if(i==1){
                    head = curr;
                }
                ListNode temp = curr;
                curr = prev;
                prev = temp;
            }
            chain = prev;
            prev = curr;
            curr = next;
            i++;
        }
        return head;
    }
}
// @lc code=end

