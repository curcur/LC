/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/************************************************************
 * $$$$$$$$$$$$$ This is a very good way to learn recursion,
 * Because, the way of the order is each to the in-order traversal of the tree
 */
public class Solution {
    ListNode head = null;
    
    public TreeNode sortedListToBST(ListNode head) {
        ListNode curr = head; int length = 0;
        while (curr != null) { length++; curr = curr.next; }
        this.head = head;
        return sortedListToBST(0, length);
    }
    
    public TreeNode sortedListToBST(int l, int r) {
        if (l >= r)  return null;
        TreeNode left = sortedListToBST(l, (l+r)/2);
        TreeNode parent = new TreeNode(head.val);
        parent.left= left;  head = head.next;           // head will not equal to null;
        parent.right = sortedListToBST((l+r)/2+1, r);
        
        return parent;
    }
}
