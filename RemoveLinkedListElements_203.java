/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * - Need to maintain prev pointer, so consider using dumyhead
 */

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dhead = new ListNode(0);
        dhead.next = head;
        
        ListNode curr = head, prev = dhead;
        while(curr!=null) {
            if (curr.val == val) 
                prev.next = curr.next;
            else 
                prev = curr;
            curr = curr.next;
        }
        return dhead.next;
    }
}
