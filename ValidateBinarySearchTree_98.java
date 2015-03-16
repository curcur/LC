/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// XXXXXXXXXXXXXXXXXXXXXXXX This solution does not work at all!!!! XXXXXXXXXXXX
// checking only root.left or root.right is not enough, the entire subtree
/*public class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if (root == null)   return true;
        if (root.left != null && root.val <= root.left.val)  return false;
        if (root.right != null && root.val >= root.right.val)    return false;
        
        return isValidBST(root.left) && isValidBST(root.right);
    }
}*/

/** 1. Correct One -- Brute Force -- Checking every subtree of the root
 */
// O(n^2) in total
/*public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)   return true;
        
        // left tree smaller than; right tree greater 
        // XXX and subBSTree also should be valid
        return leftSubtreeLess(root.left, root.val) && rightSubtreeGreater(root.right, root.val) && 
            isValidBST(root.left) && isValidBST(root.right);      
             
    }
    
    boolean leftSubtreeLess(TreeNode root, int val) {
        return (root == null) ? true : root.val < val && leftSubtreeLess(root.left, val) && leftSubtreeLess(root.right, val); 
    }
    
    boolean rightSubtreeGreater(TreeNode root, int val) {
        return (root == null) ? true : root.val > val && rightSubtreeGreater(root.left, val) && rightSubtreeGreater(root.right, val);
    }
}*/

/** 2. in-order traversal -- should print out the correct order small -> big
 */
/*public class Solution {
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        Integer prev = null; 
        //boolean firstmin = true;  XXXXXXXX using prev = null can solve this problem.
        TreeNode curr = root;
    
        while(!stack.isEmpty() || curr!=null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            if (prev != null && curr.val <= prev) return false;
            prev = curr.val;
            curr = curr.right;
        }
        
        return true;
    }
}*/

/**
 * 3. Min - Max value check
 */
/*public class Solution{
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null)   return true;
        if ((max != null && root.val >= max) || (min != null && root.val <= min)) return false;
        
        // all the subtree also needs to follow (min, max)
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}*/

/**
 * 4. In-Order, recursive
 */
 
public class Solution{
    Integer prev = null;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null)   return true;
        if (!isValidBST(root.left))     return false;
        if (prev != null && root.val <= prev) return false;
        prev = root.val;
        if (!isValidBST(root.right))    return false;
        return true;
    }
    
}