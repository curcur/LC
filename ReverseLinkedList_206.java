/**
 * ----------------------------------------------------------------------------
   Reverse Linked List
    - Reverse a singly linked list
   
   Hint:
    - A linked list can be reversed either iteratively or recursively. 
    - Could you implement both?
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 92 Reverse Linked List II
 * Tag: Linked List
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Iteration is straightforward
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


//------------------------------------------------------------------------------

/**
 * Recursion is a little tricky
 * - PostOrder
 * - current.next.next = current
 * - current.next = null XXXX do not forget this
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;    // XXXX I forget this several times
        return newhead;
    }
}
