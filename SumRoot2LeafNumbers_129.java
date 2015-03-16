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
 * recursion, accumulate the sum until reach the leaf.
 * the intermediate result can be stored in path (path*1+root.val)
 */
 
public class Solution {
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if (root == null)   return 0;
        
        sumNumbers(root, 0);
        return sum;
    }
    
    private void sumNumbers(TreeNode root, int path) {
        if (isLeaf(root)) { sum += path*10 + root.val; return; }
        if (root.left != null) sumNumbers(root.left, path*10+root.val);
        if (root.right != null) sumNumbers(root.right, path*10+root.val);
    }
    
    private boolean isLeaf(TreeNode leaf) {
        return leaf.left == null && leaf.right == null;
    }
    
}
