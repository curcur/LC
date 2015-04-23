/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Insertion Sort: insert to the right position
 * Bubble Sort: swap between elements
 * Selection Sort: select the next element
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head, newhead = null, next = null;
        while(curr!=null) {
            next = curr.next;
            newhead = findPos(newhead, curr);
            curr = next;
        }
        return newhead;
    }
    
    private ListNode findPos(ListNode head, ListNode insert) {
        ListNode dhead = new ListNode(0);
        dhead.next = head;
        ListNode curr = head, prev = dhead;
        
        while(curr!=null) {
            if (curr.val >= insert.val) {
                prev.next = insert;
                insert.next = curr;
                return dhead.next;
            }
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = insert;
        insert.next = null;
        return dhead.next;
    }
}
