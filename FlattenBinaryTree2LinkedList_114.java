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
    public void flatten(TreeNode root) {
        flat(root);
    }
    
    // input the start, return end of the link
    public TreeNode flat(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        
        // TreeNode right = flat(root.right);
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        
        if (left == null) { return right; }
        if (right == null) { root.right = root.left; root.left = null; return left; }
        
        // neither is null
        left.right = root.right;
        root.right = root.left; 
        root.left = null;
        return right;
    }
}

/**
 * Iterative Method? ---- In order Traversal?
 */

