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
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dhead = new ListNode(0); dhead.next = head;
        ListNode p1 = dhead, p2 = dhead;
        
        for(int i=0; i<n; i++)  p1 = p1.next;
        while(p1.next != null) {
            p1 = p1.next; p2 = p2.next;
        }
        
        // p2 is the prev node of the node to be deleted
        p2.next = p2.next.next;
        return dhead.next;
        
    }
}
