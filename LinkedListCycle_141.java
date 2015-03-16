/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
/**
 * 1. Simplest: Use a hashMap
 * 2. Without using extra space -- quick / slow pointer
 *                                 they will finally meet with each other if having cycle
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)  return false;
        ListNode p1 = head, p2 = head;
        
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) return true;
        }
        
        return false;
    }
}
