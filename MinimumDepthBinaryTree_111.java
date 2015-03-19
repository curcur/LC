Minimum Depth of Binary Tree
    - Given a binary tree, find its minimum depth.
    - The minimum depth is the number of nodes along the shortest path 
      from the root node down to the nearest leaf node.

/**
 * Related: 104 Maximum Depth of Binary Tree
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
 * - Min length is different from Max length because we should make sure
 *   the path is ended with a $$leaf$$
 *
 *       0
 *     1   2
 *           3
 *
 * - In the above example, we should not stop at node2 since it has right child
 */

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)   return 0;
        
        if (root.left == null)  return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        
    }
}


//------------------------------------------------------------------------------

/**
 * 2. Postorder
 * - Preorder & Inorder only push the left tree into stack
 * - the depth of the stack is the length of the path
 * - only count path that are from root to each leaf node
 */

public class Solution {
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
            //XXXX must also need curr.left == null (single left tree)
            if (curr.right == null && curr.left == null) { 
		minlength = Math.min(minlength, stack.size() + 1); }
            if (curr.right == null || curr.right == lastvisit) { 
		lastvisit = curr; curr = null; } 
            else { 
                stack.push(curr); // push it back
                lastvisit = curr;
                curr = curr.right;
            }
            
        }
        return minlength; 
        
    }
}


//------------------------------------------------------------------------------

/**
 * 3. BFS
 * - The more efficient way is using bread first search
 * - Break early when reaching a leaf instead of traversing the entire tree
 * - How to know which floor it is,
 *   XXXX Use a rightmost
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

