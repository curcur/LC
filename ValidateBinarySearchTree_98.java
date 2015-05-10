/**
 * ----------------------------------------------------------------------------
   Validate Binary Search Tree
    - Given a binary tree, determine if it is a valid binary search tree (BST).

    - Assume a BST is defined as follows:
      - The left subtree of a node contains only nodes with keys less than 
        the node's key.
      - The right subtree of a node contains only nodes with keys greater than 
        the node's key.
      - Both the left and right subtrees must also be binary search trees.
 * ----------------------------------------------------------------------------
 */

/**
 * Tags: Binary Search Tree, Recursion
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
 * - How to define a valid BST. This is the question we should ask or state
 *   at the beginning of the question. Be very careful about it.
 * - XXXX checking only root.left or root.right is not enough, should check 
 *   the entire left and right subtree
 * - meaning root should greater than the max of left subtree, and
 *   smaller than the min of the right subtree.
 *
 * - what if the input root is null? shoud return valid
 */


//------------------------------------------------------------------------------

/**
 * 1. Brute Force -- Checking every subtree of the root
 * - have not used brute force for a while, so I just keep this method here
 * - O(n^2) time
 */

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)   return true;
        
        // left tree smaller than; right tree greater 
        // XXXX and subBSTree also should be valid
        return isValidBST(root.left) && isValidBST(root.right) &&
            subtreeLess(root.left, root.val) && 
	    subtreeGreater(root.right, root.val);
    }
    
    boolean subtreeLess(TreeNode root, int val) {
        return (root == null) ? true : 
	    root.val < val && subtreeLess(root.right, val); 
    }
    
    boolean subtreeGreater(TreeNode root, int val) {
        return (root == null) ? true : 
	    root.val > val && subtreeGreater(root.left, val);
    }
}


//------------------------------------------------------------------------------

/**
 * 2. Min & Max value check
 * - as said, root.val should > the max of the left subtree, and < the min of 
 *   the right tree
 * - we can keep tracking of min & max value of each subtree, by either
 * - push min/max into the substree or generate min/max of each subtree
 * - O(n)
 */


// Method 2.1: Push the min/max bound of each subtree into each subtree 

public class Solution{
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null)   return true;
        if ((max != null && root.val >= max) 
	    || (min != null && root.val <= min)) return false;
        
        // all the subtree also needs to follow (min, max)
        return isValidBST(root.left, min, root.val) && 
	    isValidBST(root.right, root.val, max);
    }
}


// Method 2.2: Generate min/max of each subtree

class Pair {
    int min;
    int max;
    
    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)   return true;
        return isValid(root) != null;
    }
    
    public Pair isValid(TreeNode root) {
        Pair pair = new Pair(root.val, root.val);
        if (root.left != null) {
            Pair p = isValid(root.left);
            if (p == null || root.val <= p.max)  return null;
            pair.min = p.min;
        }
        if (root.right != null) {
            Pair p = isValid(root.right);
            if (p == null || root.val >= p.min)  return null;
            pair.max = p.max;
        }
        return pair;
    }
}


//------------------------------------------------------------------------------

/** 
 * 3. Inorder Traversal of a BST is in sorted order
 */

// Method 3.1: Iterative

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode prev = null, curr = root; 

        while(!stack.isEmpty() || curr!=null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            if (prev != null && curr.val <= prev.val) return false;
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}

// Method 3.2: Recursive

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
