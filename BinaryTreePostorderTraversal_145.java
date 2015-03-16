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
  * similar to inorder, the parenet+right pushed into the stack
  * need to check whether the second time visit a node (the first time should visit the right)
  * lastvisit node
  */
  
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> postorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root, lastvisit = null;
        
        
        while (curr !=null || !stack.isEmpty()) {
            
            if (curr != null) {
                lastvisit = curr;
                stack.push(curr);
                if (curr.left != null) {    // left tree
                    curr = curr.left;
                    continue;
                }
                else {                      // right tree
                    curr = curr.right;
                    continue;
                }
            }
            
            curr = stack.pop();
            // two possibility here, 1) back from left tree; 2) back from right tree;
            
            
            if (curr.right == null || curr.right == lastvisit) {
                // 2) back from right tree
                postorder.add(new Integer(curr.val));
                lastvisit = curr;
                curr = null;
            }
            else {  // back from left tree
                stack.push(curr);       // push back second time
                lastvisit = curr;
                curr = curr.right;
            }
        }
        
        return postorder;
    }
}
