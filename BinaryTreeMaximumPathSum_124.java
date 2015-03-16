/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/**
 * The following method is time exceeded
 */
/* class Solution {
    int maxsum = 0;
    
    public int maxPathSum(TreeNode root) {
        if (root == null)   return 0;
        maxsum = Math.max(maxPathCross(root), maxsum);
        maxsum = Math.max(maxPathSum(root.left), maxsum);
        maxsum = Math.max(maxPathSum(root.right), maxsum);
        
        return maxsum;
    }
    
    public int maxPathCross(TreeNode root) {
        if (root == null)   return 0;
        return Math.max(maxPath(root.left), 0) + Math.max(maxPath(root.right), 0) + root.val;
    }
    
    public int maxPath(TreeNode root) {
        if (root == null)   return 0;
        return Math.max(Math.max(maxPath(root.left), maxPath(root.right)), 0) + root.val;
        
    }
}*/

/**
 */
 
/**
 * Bottom up - leaf first, then root
 */
public class Solution{
    Integer maxlength = Integer.MIN_VALUE; // the maxlength until now, bottom up
    
    public int maxPathSum(TreeNode root) {
        maxHalfPath(root);
        return maxlength;
    }
    
    // the longest path rooted from root;
    public int maxHalfPath(TreeNode root) {
        if (root == null)   return 0;
        int leftlength = Math.max(maxHalfPath(root.left), 0);
        int rightlength = Math.max(maxHalfPath(root.right), 0);
        maxlength = Math.max(leftlength + rightlength + root.val, maxlength);
        return Math.max(leftlength, rightlength) + root.val;
    }
    
}
