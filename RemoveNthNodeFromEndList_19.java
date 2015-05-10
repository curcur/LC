/**
 * ----------------------------------------------------------------------------
   Remove Nth Node From End of List
    - Given a linked list, remove the nth node from the end of list and 
      return its head.

   For example,
    - Given linked list: 1->2->3->4->5, and n = 2.
    - After removing the second node from the end, the linked list becomes 
      1->2->3->5
   
   Note:
    - Given n will always be valid.
    - Try to do this in one pass.
 * ----------------------------------------------------------------------------
 */

/**
 * Tags: Linked List
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Two pointers
 * - We should identify the prev pointer of the node to be identified 
 *   in singled linked list
 * - n is counted from 1 not 0
 * - p1 = p2 = head or dhead, does not matter, 
 *   as long as p1 and p2 keep k-step distance
 * - use the condition while(p2.next != null)
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dhead = new ListNode(0); dhead.next = head;
        ListNode p1 = dhead, p2 = dhead;
        
	// $$$$ use p1!=null to check whether n is valid
        for(int i=0; i<n && p1!=null; i++)  p1 = p1.next;
	if (p1 == null)  return dhead.next;  // n is not valid

        while(p1.next != null) {
            p1 = p1.next; p2 = p2.next;
        }
        
        // p2 is the prev node of the node to be deleted
        p2.next = p2.next.next;
        return dhead.next;   
    }
}
