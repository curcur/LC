/**
 * - Use a stack to go over the BST needs O(logn) stack space
 * - The question is asking for constant spaces
 * 
 * - Morris Method
 * - for each root, find rightmost of the left subtree
 * - 1). set the rightmost's right = root if right == null;
 * - 2). set the rightmost's right back to null if right == root
 * 
 * - 1, 2, 3, 4, 5     
 *   => 1, 5, 3, 4, 2   (2<->5)
 *   => 1, 3, 2, 4, 5   (2<->3)
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
public class Solution {
    TreeNode prev = null, first = null, second = null;
    public void recoverTree(TreeNode root) {
        TreeNode curr = root, rightmost = null;
        
        // XXXX this will not change as input parameters
        //TreeNode prev = null, first = null, second = null;
        
        while(curr != null) {
	    // XXXX have to test whether curr == null
            //while (curr.left == null) {   
            if(curr.left == null) {
                // XXXX detect(prev, curr, first, second);
                detect(curr);
                curr = curr.right;
                continue;
            }
            
            // left is not null, find right most
            rightmost = curr.left;
            while(rightmost.right != null && rightmost.right != curr) 
                rightmost = rightmost.right;
            if (rightmost.right == null)    { 
                rightmost.right = curr;
                curr = curr.left;
            } else {
                // XXXX detect(prev, curr, first, second);
                detect(curr);
                rightmost.right = null;
                curr = curr.right;
            }
        }
        
        swap(first, second);
    }

    private void detect(TreeNode curr) {
        if (prev!=null && curr.val < prev.val) {
            if (first == null) 
                first = prev;
            second = curr;
        }
        prev = curr;                // XXXX set prev
    }
    
    private void swap(TreeNode first, TreeNode second) {
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
}
