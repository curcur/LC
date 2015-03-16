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
 * The longest stack depth
 * 1. If using recursion, it is very easy;
 * it not, using postorder, preorder & inorder only in stack the left tree
 */
/*public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)   return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}*/

/**
 * 2. Post-Order
 **/
public class Solution {
    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack  = new Stack<TreeNode>();
        TreeNode curr = root, lastvisit = null;
        int maxlength = 0;
        
        while (curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr); lastvisit = curr;
                if (curr.left != null)  { curr = curr.left; continue; }
                else { curr = curr.right; continue; }
            }
            maxlength = Math.max(maxlength, stack.size());
            
            curr = stack.pop();
            if(curr.right == null || curr.right == lastvisit) { // return from right
                lastvisit = curr; curr = null;
            }else{  //return from left
                stack.push(curr);  lastvisit = curr; curr = curr.right;
            }
        }
        return maxlength;
    }
}
