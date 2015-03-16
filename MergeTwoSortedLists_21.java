/**
 * The solution said using dummy head
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * 
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        /// XXXXXXXXXXXXX  Empty Set
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode cur1 = l1, cur2 = l2, head = null, cur = null;
        
        if (cur1.val < cur2.val) { head = cur1; cur1 = cur1.next; }
        else { head = cur2; cur2 = cur2.next; }
        cur = head;
        
        while(cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) { cur.next = cur1; cur1 = cur1.next; }
            else { cur.next = cur2; cur2 = cur2.next; }
            cur = cur.next;
        }
        
        cur.next = (cur1 == null) ? cur2 : cur1;
        return head;    /// XXXXXX Return Statement
    }
}