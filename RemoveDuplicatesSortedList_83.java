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
/*public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head, prev = head;
        
        while (curr != null) {
            if (curr.val != prev.val) {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        
        // the tail
        if (prev != null) prev.next = null;     // XXX prev = null when link is empty.
        return head;
    }
}*/

/**
 * More Logical?
 */
/*public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head, prev = head;
        
        while (curr != null) {
            if (curr.val == prev.val) {
                prev.next = curr.next;
            } else prev = curr;
            curr = curr.next;
        }
        
        // the tail
        if (prev != null) prev.next = null;     // XXX prev = null when link is empty.
        return head;
    }
}*/

/**
 * Better?
 */ 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dhead = new ListNode(0); dhead.next = head;
        ListNode prev = dhead, curr = head;
        
        while(curr != null) {
            while(curr.next != null && curr.val == curr.next.val)
                curr = curr.next;
            prev.next = curr;
            prev = curr;
            curr = curr.next;
        }
        
        return dhead.next;
    }
}
