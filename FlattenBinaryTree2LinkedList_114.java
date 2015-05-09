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
 * Related: solutions 2 Convert BST to Sorted DoubleLinked List
 * Tags: Binary Tree, Linked List
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
 * - This is similar to Convert BST to Sorted DoubleLinked List
 * - Instead it is a pre-order traversal convert
 * - Notice that this is a single linked list, use right pointer only,
 *   and the left pointer is set to null
 * - pair (head, tail), head = root, we only need to return the tail
 * - O(n) time, and O(logn) space
 */

public class Solution {
    public void flatten(TreeNode root) {
        flat(root);
    }
    
    // input the start (root), return end of the link
    public TreeNode flat(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        
        // TreeNode right = flat(root.right);
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        TreeNode tail = null;
	
        if (left == null) { 
	    tail = right; 
	} else if (right == null) { 
	    root.right = root.left; 
	    root.left = null; 
	    tail = left;
	} else {
	    // neither is null
	    left.right = root.right;
	    root.right = root.left; 
	    root.left = null;
	    tail = right;
	}
	return tail;
    }
}


//------------------------------------------------------------------------------

/**
 * Iterative Method - use a stack
 * - It is not a typical Preorder Traversal, because we need to set 
 *   root.right = root.left, so we need some way to store the right node info
 * - So we use the most original pre-order iterative
 */

public class Solution {
    public void flatten(TreeNode root) {
	// XXXX do not forget
	if (root == null)  return;

        Stack<TreeNode> stack = new Stack<>();
	stack.push(root);

	while(!stack.isEmpty()) {
	    TreeNode curr = stack.pop();
	    if (curr.right != null) 
		stack.push(curr.right);
	    if (curr.left != null) 
		stack.push(curr.left);
	    if (!stack.isEmpty()) {
		curr.right = stack.peek();
	    }
	    curr.left = null;
	}
    }
}
