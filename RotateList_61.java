/**
 * ----------------------------------------------------------------------------
   Rotate List
    - Given a list, rotate the list to the right by k places,
      where k is non-negative.

   For example:
    - Given 1->2->3->4->5->NULL and k = 2,
    - return 4->5->1->2->3->NULL.
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 189	Rotate Array
 * Tags: Rotation, LinkedList
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
 * - For LinkedList, we should always think of two pointers
 * - For single LinkedList broken problem, always find the prev position
 *   where the linked list is rotated (broken)
 *
 * - Question to ask: k smaller than the length of linkedList?
 * 
 *  XXXX Several Corner Cases XXXX 
 *  - k >= length               
 *  - k % length == 0           
 *      XXXX in this case p1 is moving forward the same as p2
 *	p1.next = null
 *  - length == 0     
 *      XXXX k can not % length
 *
 * - No need to use dhead this problem
 */

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)   return head;    // XXXX  length == 0
	ListNode curr = head, p1 = head, p2 = head;
        
        int length = 0;
        while(curr != null) { length++; curr = curr.next; }
	k = k % length;
    
        if (k == 0) return head;    // XXXX  k == 0, p1 = p2 
                                    // XXXX  so new head = p1.next = null;
	// move k steps ahead;
        while(k != 0 )  { p2 = p2.next; k--; }
        
        // p2 is reaching the end of the list
        while(p2.next != null) {
            p1 = p1.next; p2 = p2.next;
        }
        
        curr = p1.next;
	p1.next = null;
	p2.next = head;
	return curr;
    }
}
