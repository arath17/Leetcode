import java.util.List;

/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curr = head, first, chain, prev, next;
        first = chain = prev = next = null;

        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        curr = head;
        int traverseLength = length - (length % k);
        int i = 0;
        while (i < traverseLength) {
            next = curr.next;
            if (i % k == 0) {
                first = curr;
            } else if (i % k == k - 1) {
                curr.next = prev;
                first.next = next;
                if (chain != null) {
                    chain.next = curr;
                }
                if (i == k - 1) {
                    head = curr;
                }
                curr = first;
                chain = first;
            } else {
                curr.next = prev;
            }
            prev = curr;
            curr = next;
            i++;
        }
        return head;
    }
}
// @lc code=end
