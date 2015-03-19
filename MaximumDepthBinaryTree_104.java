Maximum Depth of Binary Tree
    - Given a binary tree, find its maximum depth.
    - The maximum depth is the number of nodes along the longest path 
      from the root node down to the farthest leaf node.

/**
 * Related: 111 Minimum Depth of Binary Tree
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
 
/**
 * 1. Recursion
 */

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)   return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}


//------------------------------------------------------------------------------

/**
 * 2. Postorder
 * - Preorder & Inorder only push the left tree into stack
 * - The maxlength is the longest stack depth
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
            if(curr.right == null || curr.right == lastvisit) { 
		// return from right
                lastvisit = curr; curr = null;
            }else{  //return from left
                stack.push(curr);  lastvisit = curr; curr = curr.right;
            }
        }
        return maxlength;
    }
}
