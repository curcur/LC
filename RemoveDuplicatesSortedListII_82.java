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
/*public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dhead = new ListNode(0), prev = dhead, curr = head;
        dhead.next = head;
        boolean dup = false; // need to remove curr itself;
        
        if (curr == null || curr.next == null)  return dhead.next;
        
        while(curr.next != null) { 
            if (curr.val == curr.next.val)  { 
                curr.next = curr.next.next; // remove next
                dup = true;                 // should remove curr later
                continue;
            } 
            if (dup) { prev.next = curr.next; }
            else { prev = curr;}
            curr = curr.next;
            dup = false;
        }
        
        if (dup) prev.next = null;
        return dhead.next;
    }
}*/

/**
 * More Clean Solution
 */
public class Solution{
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dhead = new ListNode(0); dhead.next = head;
        ListNode prev = dhead, curr = head;
        
        while (curr != null) {
            while(curr.next != null && curr.val == curr.next.val) 
                curr = curr.next;
            
            if (prev.next != curr)  prev.next = curr.next;
            else prev = curr;
            
            curr = curr.next;
        }
        
        return dhead.next;
    }
}
