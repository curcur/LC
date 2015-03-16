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
 * Two pointers 1 step; 2 step
 * x + y = k        -- x: start to cycle start
 *                  -- y: cycle start to first meet
 *                  -- k: the k steps of the first pointer
 * x + y + nt = 2k  -- t: length of the cycle
 *                  -- n: n cycles
 *                  -- 2k:2k steps of the second pointer
 * => nt = k => nt - y = k - y = x
 * one pointer k steps ahead, and the other from the start
 * each one step each time
 * the first time they meet
 */
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)   return null;
        
        ListNode p1 = head, p2 = head;
        
        while(p2 != null && p2.next != null) {
            p1 = p1.next; 
            p2 = p2.next.next;
            if (p1 == p2)   break;
        }
        
        if (p2 == null || p2.next == null)  return null;
        
        // p1's position is k step
        p2 = head;
        while(p2 != p1) {
            p2 = p2.next; p1 = p1.next;
        }
        
        return p1;
        
    }
}
