/**
 * root.right = root.left &&
 * root.left.right Symmetric root.right.left
 * root.right.left Symmetric root.left.right
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
    public boolean isSymmetric(TreeNode root) {
        return root == null ||
	    isSymmetric(root.left, root.right);
        
    }
    
    private boolean isSymmetric(TreeNode leftr, TreeNode rightr) {
        if (leftr == null && rightr == null)    return true;
        if (leftr == null || rightr == null)    return false;
        
        return leftr.val == rightr.val && 
            isSymmetric(leftr.right, rightr.left) &&
            isSymmetric(leftr.left, rightr.right);
    }
}


/**
 * 2. It can also be solved as non-recursion.
 * - Traversal the tree level by level
 * - Check whether it is symmetric in each level
 */
