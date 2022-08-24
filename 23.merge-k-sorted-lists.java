/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0)
            return null;

        return mergeLists(lists, 0, lists.length - 1);
        
    }

    ListNode mergeLists(ListNode[] lists,int start,int end){
        if(start == end){
            return lists[start];
        }
        int mid = (start+end)/2;
        ListNode list1 = mergeLists(lists,start,mid);
        ListNode list2 = mergeLists(lists, mid+1, end);
        return mergeList(list1, list2);

    }

    ListNode mergeList(ListNode list1,ListNode list2){
        ListNode newList = null;
        ListNode prev = null;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                if(prev!=null){
                    prev.next = new ListNode(list1.val);
                    prev = prev.next;
                }
                else{
                    newList = new ListNode(list1.val);
                    prev = newList;
                }
                list1 = list1.next;
            }
            else{
                if(prev!=null){
                    prev.next = new ListNode(list2.val);
                    prev = prev.next;
                }
                else{
                    newList = new ListNode(list2.val);
                    prev = newList;
                }
                list2 = list2.next;
            }
        }
        if(list1!=null){
            if(prev!=null){
                prev.next = list1;
            }
            else{
                newList = list1;
            }
        }
        if(list2!=null){
            if(prev!=null){
                prev.next = list2;
            }
            else{
                newList = list2;
            }
        }
        return newList;
    }
}
// @lc code=end

