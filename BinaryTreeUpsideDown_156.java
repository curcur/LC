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
 * It only has left-only tree
 */ 
/*public class Solution {
    TreeNode newroot = null;
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if (root == null)   return null;
        if (root.left == null)  return root;
        
        TreeNode left = root.left;
        newroot = UpsideDownBinaryTree(root.left);
        left.left = root.right; left.right = root;
        root.left = null; root.right = null;    // XXXXXX you should reset the original 
        
        return newroot;
    }
}*/

/**
 * Without Recursion, top-down
 */ 
 
public class Solution{
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if (root == null)   return null;
        TreeNode left = root.left, curr = root, oleft = curr.left, oright = curr.right;
        
        while(left != null) {
            oleft = left.left; left.left = oright;
            oright = left.right; left.right = curr;
            curr = left; left = oleft;
        }
        
        root.left = null; root.right = null;
        return curr;
    }
}

