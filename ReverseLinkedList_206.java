/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Iterative
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

/**
 * Recursive
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;    // $$$$
        return newhead;
    }
}
