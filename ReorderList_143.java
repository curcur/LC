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

/**
 * Find the second half; Reverse the second half; Merge Together
 * How to accurately split the linkedlist
 */

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null)   return;
        // find the head of the second half
        ListNode p1 = head, p2 = head;
        while(p2!=null && p2.next!=null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        p2 = p1.next;       // head of the second half
        p1.next = null;
        
        // reverse the second half
        ListNode prev = null, curr = p2, next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // relink the linked list
        p1 = head; p2 = prev;
        ListNode nextp1 = null, nextp2 = null;
        while(p2!=null) { // p1 != null either
            nextp1 = p1.next;
            p1.next = p2;
            nextp2 = p2.next;
            p2.next = nextp1;
            
            p1 = nextp1; p2 = nextp2;
        }
    }
}
