/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       ListNode prev = null;
       while(fast!=null && fast.next!=null){
           prev = slow;
           slow = slow.next;
           fast = fast.next.next;
       }
       if(slow == fast){
           return true;
       }

       prev.next = null;
       if(fast!=null){
           slow = slow.next;
       }

      ListNode reverseHead = reverse(head);

      while(reverseHead!=null && slow!=null){
          if(reverseHead.val!=slow.val)
            return false;
        reverseHead = reverseHead.next;
        slow = slow.next;
      }
      return true;

    }

    ListNode reverse(ListNode head){
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

