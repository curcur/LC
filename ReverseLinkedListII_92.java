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
 * Reverse a link you should have prev, curr, next;
 */ 
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dhead = new ListNode(-1);  dhead.next = head;
        ListNode prevstart = dhead, curr = head, prev, next;
        
        int i = 1;
        for(; i<m; i++) { prevstart = curr;  curr = curr.next; }
        
        prev = curr; curr = curr.next; i++;
        
        // reverse the link
        for(; i<=n; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        prevstart.next.next = curr;
        prevstart.next = prev;
        
        return dhead.next;
    }
}
