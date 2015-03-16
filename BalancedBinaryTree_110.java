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
 * My Understand OF Balanced Binary Tree is wrong 
 * the First is wrong!!!!! XXXXXXXXXXXXXXXXXXX
 * 1. Find the longest, & shortest, then test whether the longest-shortest<=1;
 *  write recursion method directly
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 */
 
/**
 * This is it's definition Time O(n^2), maxDepth is O(n), do it for each node => O(n^2)
 */
/*public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)   return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
            isBalanced(root.left) && isBalanced(root.right) ;
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null)   return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}*/


/**
 * maxDepth recalculated for every node, can be merged in the isBalanced
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepthBalanced(root) >= 0;
    }
    
    // -1, unbalanced, >=0 maxlength & balanced
    public int maxDepthBalanced(TreeNode root) {
        if (root == null)   return 0;
        int lb = maxDepthBalanced(root.left);
        int rb = maxDepthBalanced(root.right);
        if (lb < 0 || rb < 0 || Math.abs(lb-rb) > 1) return -1;
        return Math.max(lb, rb) + 1;
    }
} 
 
