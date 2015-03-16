/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

/**
 * 1. Recursion, but it is not constant extra space, of course!
 */ 
/*public class Solution {
    public void connect(TreeLinkNode root) {
        // the root is a null or leaf
        if (root == null || root.left == null || root.right == null)    return;
        
        root.left.next = root.right;
        root.right.next = (root.next == null) ? null : root.next.left;
        
        connect(root.left);
        connect(root.right);
    }
}*/

/**
 * 2. Constant Space Method
 *      Level by Level
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)   return;
        
        TreeLinkNode curr = root, left = root.left;
        while (curr.left != null) {
            curr.left.next = curr.right;
            curr.right.next = curr.next == null ? null : curr.next.left;
            
            // XXXXXXX it should be most left's left
            if (curr.next == null)  { curr = left; left = curr.left; }  
            else curr = curr.next;
        }
    }
}
