/**
 * ----------------------------------------------------------------------------
   Binary Tree Postorder Traversal
    - Given a binary tree, return the postorder traversal of its nodes' values.

   For example:
    - Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
    - return [3,2,1].

   Note: Recursive solution is trivial, could you do it iteratively?
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
  * - all trees are pushed into the stack instead of just the left tree
  * - need to check whether coming back from the left tree or right tree
  * - to solve this, we maintain a lastvisit node to check whether
  *   the right tree has already visited
  */
  
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root, lastvisit = null;
        
        
        while (curr !=null || !stack.isEmpty()) {
            
            while (curr != null) {
		stack.push(curr);
                if (curr.left != null)   // left tree
                    curr = curr.left;
		
                else                     // right tree
                    curr = curr.right;
            }
            
            curr = stack.pop();

            // two possibility here: 
	    // 1) back from left tree; 2) back from right tree;

	    // 2) back from right tree
	    if (curr.right == null || curr.right == lastvisit) {
		postorder.add(new Integer(curr.val));
                lastvisit = curr;
                curr = null;   // $$$$ back from the entire tree, go on pop;
            }
            else {  // 1) back from left tree
                stack.push(curr);       // push back second time
		curr = curr.right;      // work on the right subtree
            }
        }
        
        return postorder;
    }
}
