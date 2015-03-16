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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)  return false;
        
        // XXXXXXXXX must use this as a criteria, because null may not be a leaft (left || right)
        if (root.left == null && root.right == null)    return sum == root.val ;
        //if (hasPathSum(root.left, sum-root.val)) return true;
        //if (hasPathSum(root.right, sum-root.val)) return true;
        
        //return false;
        
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
