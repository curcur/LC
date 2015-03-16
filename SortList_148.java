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
 * Use Quick-Slow link pointer
 * set the first harf tail = null
 */


public class Solution {
    public ListNode sortList(ListNode head) {
		
        return mergeSort(head);
      
    }
    
	private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode curr = head, tail0 = head, head2;
        
        while(curr.next != null && curr.next.next != null) {
            tail0 = tail0.next;
            curr = curr.next.next;
        }
        
        head2 = tail0.next; tail0.next = null;
        return merge(mergeSort(head), mergeSort(head2));
        
    }
    
    
    private ListNode merge(ListNode head11, ListNode head22) {
        ListNode dhead = new ListNode(-1), curr = dhead;
        ListNode head1 = head11, head2 = head22;
        
        while(head1!=null && head2!=null) {
            if (head1.val < head2.val) { 
                curr.next = head1; head1 = head1.next; 
            } else {
                curr.next = head2; head2 = head2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (head1 == null)? head2 : head1;
        return dhead.next;
    }
    
    

}
