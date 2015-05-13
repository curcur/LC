/**
 * ----------------------------------------------------------------------------
   Reverse Linked List II
    - Reverse a linked list from position m to n. 
    - Do it in-place and in one-pass.

   For example:
    - Given 1->2->3->4->5->NULL, m = 2 and n = 4,
    - Return 1->4->3->2->5->NULL.

   Note:
    - Given m, n satisfy the following condition:
    - 1 ≤ m ≤ n ≤ length of list.
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 206 Reverse Linked List
 * Tag: Linked List
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
 * - Reverse a link you should have prev, curr, next
 * - Reverse m ... n 
 * - Remeber the node before m, and the one after n
 */ 
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dhead = new ListNode(0);  dhead.next = head;
        ListNode prevstart = dhead, curr = head, prev, next;
        
	for(int i=1; i<m; i++) { prevstart = prevstart.next; }
	prev = prevstart; curr = prev.next; next = null; 
        
        // reverse the link
        for(int i=m; i<=n; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

	// prev: Node_n; curr: Node_{n+1}
	prevstart.next.next = curr;
        prevstart.next = prev;
	
	return dhead.next;
    }
}
