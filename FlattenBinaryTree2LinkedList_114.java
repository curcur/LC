/**
 * ----------------------------------------------------------------------------
   Flatten Binary Tree to Linked List
    - Given a binary tree, flatten it to a linked list in-place.
     
   For example:
    - Given

         1
        / \
       2   5
      / \   \
     3   4   6

    - The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 189	Rotate Array
 * Tags: Rotation, LinkedList
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
public class Solution {
    public void flatten(TreeNode root) {
        flat(root);
    }
    
    // input the start, return end of the link
    public TreeNode flat(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        
        // TreeNode right = flat(root.right);
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        
        if (left == null) { return right; }
        if (right == null) { root.right = root.left; root.left = null; return left; }
        
        // neither is null
        left.right = root.right;
        root.right = root.left; 
        root.left = null;
        return right;
    }
}

/**
 * Iterative Method? ---- In order Traversal?
 */

