Binary Search Tree Iterator 
    - Implement an iterator over a binary search tree (BST). 
    - Your iterator will be initialized with the root node of a BST.
    
    - Calling next() will return the next smallest number in the BST.
    - next() and hasNext() should run in average O(1) time and 
      uses O(h) memory, where h is the height of the tree.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

/**
 * This is the same non-recursive Inorder traversal of the BST
 * - I was also thinking to put inorder traversal logic in hashNext().
 * - hashNext() may be called many times before next() has been called.
 * - the overall run time is O(n), so the average run time is O(1)
 * - the extra space is the stack, which is O(h)
 */

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    TreeNode root, curr, copy;
    
    public BSTIterator(TreeNode root) { 
        this.root =root; this.curr = root; this.copy = null;
    }

    // /* @return whether we have a next smallest number 
    public boolean hasNext() {
        return curr!=null || !stack.isEmpty();
    }

    // /* @return the next smallest number 
    public int next() {
        while(curr!=null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr); curr = curr.left;
                continue;
            }
            curr = stack.pop();
            copy = curr;
            curr = curr.right;
            break;
        }
        return copy.val;
    }
}
