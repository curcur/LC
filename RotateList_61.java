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
 * - Find the prev position where the linked list is rotated
 * - Assume k is smaller than the length of the linkedlist
 * - k is not guarenteed to be smaller than length!
 * 
 *  XXX Several Corner Cases! 
 *  - k >= length               
 *  - k % length == 0           
                XXX in this case curr is dhead, it will make dhead.next = null
 *  - length == 0     XXX k can not % length
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)   return head;    // XXX  length == 0
       
        ListNode dhead = new ListNode(0);
        dhead.next = head;
     
        ListNode kp = dhead, curr = dhead;
        
        int length = 0;
        while(curr.next != null) { length++; curr = curr.next; }
        
        k = k % length;
    
        if (k == 0) return head;    // XXX  k == 0, curr = kp = dhead; 
                                    // XXX  this will make dhead.next = null;
        curr = dhead;
        // move k steps ahead;
        while(kp.next != null && k != 0 )  { kp = kp.next; k--; }
        
        // kp is reaching the end of the list
        while(kp.next != null) {
            curr = curr.next; kp = kp.next;
        }
        
        kp.next = dhead.next;
        dhead.next = curr.next;
        curr.next = null;
        
        return dhead.next;
    }
}
