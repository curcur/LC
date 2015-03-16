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
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        int tval = 0;
        while(cur!=null && cur.next !=null) {
            tval = cur.val; cur.val = cur.next.val; cur.next.val = tval;
            cur = cur.next.next;
        }
        return head;
    }
}