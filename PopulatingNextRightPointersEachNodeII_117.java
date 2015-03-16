/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
/**
 * XXXXXXXXX Some Corner Cases!!!
 * Constant Space means no recursion!
 */
/*public class Solution {
    public void connect(TreeLinkNode root) {
        
        // if root is null or leaf
        if (root == null || (root.left == null && root.right == null))  return;
        
        if (root.left != null)  root.left.next = findNext(root, true);
        if (root.right!= null)  root.right.next = findNext(root, false);
        
        connect(root.right);                // XXXXXXX right should come first
        connect(root.left);                 // XXXXXXX then left!                      ----------
        
    }
    
    private TreeLinkNode findNext(TreeLinkNode root, boolean isleft) {
        if (root.right != null && isleft)   return root.right;
        TreeLinkNode curr = root.next;
        while (curr!=null) {                // XXXXXXX loop till the right end of the tree  -----
            if (curr.left != null)    return curr.left;
            if (curr.right!= null)    return curr.right;
            curr = curr.next;
        }
        return null;
    }
}*/

/**
 * constant space
 */
/*public class Solution {
    
    public void connect(TreeLinkNode root) {
        //if (root == null)   return;
        TreeLinkNode curr = root, levelstart = null;
        
        // while(curr.left != null || curr.right != null || curr.next != null) {
        while(curr != null) {   // XXXXXXX I previously use the while loop up, which is not right 
            if (curr.left != null)  { curr.left.next = findNext(curr, true); }
            if (curr.right!= null)  { curr.right.next = findNext(curr, false); }
            
            TreeLinkNode nextstart = (curr.left == null) ? curr.right : curr.left;
            levelstart = (levelstart == null) ? nextstart : levelstart;
            
            if (curr.next != null)  { curr = curr.next; continue; }
            curr = levelstart; levelstart = null;
        }
    }
        
    private TreeLinkNode findNext(TreeLinkNode root, boolean isleft) {
        if(root.right != null && isleft)    return root.right;
            
        TreeLinkNode curr = root.next;
        while(curr!=null) {
            if (curr.left != null)  return curr.left;
            if (curr.right != null) return curr.right;
            curr = curr.next;
        }
            
        return null;
    }
}*/

/**
 * More Clean....
 */
public class Solution {
    
    public void connect(TreeLinkNode root) {
        TreeLinkNode curr = root, nextprev = null, nextstart = null;
        while(curr != null) {
            if (curr.left != null) { 
                if (nextprev != null)   { nextprev.next = curr.left; }
                else nextstart = curr.left;
                nextprev = curr.left;
                //nextstart = nextstart == null ? curr.left : nextstart;
            }
            if (curr.right != null) {
                if (nextprev != null)  { nextprev.next = curr.right; }
                else nextstart = curr.right;
                nextprev = curr.right;
                //nextstart = nextstart == null ? curr.right : nextstart;
            }
            if (curr.next != null)  curr = curr.next;
            else { curr = nextstart; nextstart = null; nextprev = null; }   // new level
        
        }
    }
}
