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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2, dhead = new ListNode(0), cur = dhead;
        int carry = 0;
        
        while(cur1!=null && cur2!=null) {
            int sum = cur1.val + cur2.val + carry;
            cur.next = new ListNode(sum%10); cur = cur.next;
            carry = sum / 10;
            cur1 = cur1.next; cur2 = cur2.next;
        }
        
        ListNode tcur = (cur1 == null) ? cur2 : cur1;  // tail
        while(tcur != null) {
            int sum = tcur.val + carry;
            cur.next = new ListNode(sum%10); cur = cur.next;
            carry = sum / 10;
            tcur = tcur.next;
        }
        
        // XXXXXXX  carry tail
        if (carry > 0) { cur.next = new ListNode(carry); cur = cur.next; }
        
        return dhead.next;
    }
}
