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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dhead = new ListNode(0);  dhead.next = head;
        ListNode pstart = dhead, curr = dhead;
        
        while(curr.next != null) {
            int i = 0;
            for(; i<k && curr.next!=null; i++)  curr = curr.next;
            if (i==k) { pstart = reverse(pstart, k); curr = pstart; }
        }
        return dhead.next;
    }
    
    // pstart: the start position - 1, return the tail of the list
    private ListNode reverse(ListNode pstart, int k) {
        if (k == 1) return pstart.next;
        ListNode prev = pstart.next, curr = prev.next;
        
        for(int i=1; i<k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode tail = pstart.next;
        tail.next = curr;
        pstart.next = prev;
        return tail;
    }
}
