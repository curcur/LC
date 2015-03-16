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
 * 1. This is the same as in-order traversal of the BST
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


/**
 * XXXXXXX 2. Better Solution? This is not right. hasNext() suppose can be run many times before next();
 */
/*public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    TreeNode root, curr, copy;
    
    public BSTIterator(TreeNode root) { 
        this.root =root; this.curr = root; this.copy = null;
    }

    // /** @return whether we have a next smallest number 
    public boolean hasNext() {
        while (curr!=null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr); curr = curr.left;
                continue;
            }
            curr = stack.pop();
            return true;
        }
        return false;
    }

    // /** @return the next smallest number 
    public int next() {
        copy = curr; curr = curr.right;
        return copy.val;
    }
}*/

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
