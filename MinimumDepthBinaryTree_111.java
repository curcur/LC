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
 * recursive
 */
/*public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)   return 0;
        
        if (root.left == null)  return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        
    }
}*/

/**
 * postorder
 */
/*public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root, lastvisit = null;
        
        int minlength = Integer.MAX_VALUE;
        
        while(curr != null || !stack.isEmpty()) {
            if (curr!= null) {
                stack.push(curr); lastvisit = curr;
                if (curr.left != null) { curr = curr.left; continue; }
                else { curr = curr.right; continue; }
            }
            
            curr = stack.pop();
            //XXXXXXXXXX must also need curr.left == null (single left tree)
            if (curr.right == null && curr.left == null) { minlength = Math.min(minlength, stack.size() + 1); }
            if (curr.right == null || curr.right == lastvisit) { lastvisit = curr; curr = null; } 
            else { 
                stack.push(curr); // push it back
                lastvisit = curr;
                curr = curr.right;
            }
            
        }
        return minlength; 
        
    }
}*/

/**
 * The more efficient way is using breadfirst search!!!!, 
 * you can break early instead of traversing every node.
 * 
 * How to know which floor it is,
 * XXXXXXX Use a rightmost!!!!
 */
public class Solution{
    public int minDepth(TreeNode root) {
        if (root == null)   return 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode rightmost = root, curr = root;
        int minlength = 1;
        
        while(!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.left == null && curr.right == null)    break;
            if (curr == rightmost)  {
                rightmost = (curr.right == null) ? curr.left : curr.right;
                minlength++;
            }
            if (curr.left != null) queue.offer(curr.left); 
            if (curr.right!= null) queue.offer(curr.right);
        }
        return minlength;
    }
} 

