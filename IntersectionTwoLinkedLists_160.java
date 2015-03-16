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
 * 1. This is about quick-slow linkedList pointer problem
 * you can also cal each length of the linkedList, and then move from the longlen - shortlen poisition   *  from longer linkedlist
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA; ListNode p2 = headB;
        
        while (p1 != null && p2 != null) { p1 = p1.next; p2 = p2.next; }
        p1 = (p1 == null) ? headB : p1;
        p2 = (p2 == null) ? headA : p2;
        
        while (p1 != null && p2 != null) { p1 = p1.next; p2 = p2.next; }
        p1 = (p1 == null) ? headB : p1;
        p2 = (p2 == null) ? headA : p2;
        
        // p1 & p2 are now same length
        while (p1 != null && p1 != p2) { p1 = p1.next; p2 = p2.next; }
        
        return p1;
        
    }
}
