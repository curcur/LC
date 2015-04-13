/**
 * ----------------------------------------------------------------------------
   Binary Tree Inorder Traversal 
    - Given a binary tree, return the inorder traversal of its nodes values 
 * ----------------------------------------------------------------------------
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
 * 1. stack  
 * - O(n) time & space
 * - the left side will not go into the stack
 */
 
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr); curr = curr.left;
            }
            curr = stack.pop();
            inorder.add(curr.val);
            curr = curr.right;
        }
        return inorder;
    }
}

//------------------------------------------------------------------------------

/**
 * 2. morris
 * O(n) time O(1) space
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        
        TreeNode curr = root, rightmost = null;
        
        while (curr != null) {
            if (curr.left == null) {    // do not have a left subtree
                inorder.add(new Integer(curr.val));
                curr = curr.right;
                continue;
            }
            
            // have a left subtree
            // find the left subtree's right most
            rightmost = curr.left;
            while (rightmost.right != null && rightmost.right != curr)
                rightmost = rightmost.right;
            
            
            if (rightmost.right == null)  { // first time
                rightmost.right = curr;
                curr = curr.left;
            }
            else {                          // second time
                inorder.add(new Integer(curr.val));
                rightmost.right = null;
                curr = curr.right;
            }
        }
        return inorder;
    }
    
}


