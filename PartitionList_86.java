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
 * Less Than Head
 * Greater Than Head
 */ 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode LT_dHead = new ListNode(0), GT_dHead = new ListNode(0);
        ListNode LT_curr = LT_dHead, GT_curr = GT_dHead;
        ListNode curr = head;
        
        while(curr != null) {
            if (curr.val < x) { LT_curr.next = curr; LT_curr = curr; }
            else { GT_curr.next = curr; GT_curr = curr; }
            curr = curr.next;
        }
        
        LT_curr.next = GT_dHead.next;
        GT_curr.next = null;        // XXXXX forget this at first
        return LT_dHead.next;
        
    }
}
