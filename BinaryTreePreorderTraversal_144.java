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
 * 1. Stack sloution O(n) time & memory complexity
 * */
/*public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        // we can use a stack to solve the pre-order traversal
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        
        TreeNode curr = null;
        
        stack.push(root);
        
        while(!stack.isEmpty()) {
            curr = stack.pop();
            
            if (curr != null) { // XXX check
                preorder.add(new Integer(curr.val));
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        
        return preorder;
    }
}*/

/**
 * 2. Morris Solution, O(n) time & O(1) memory
 * */
/*public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        TreeNode curr=root, rightmost=null;  // prev is the previous node of curr
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        
        while(curr != null) {
            // preorder.add(new Integer(curr.val));    // XXX would be duplicated
            
            if (curr.left == null) {    // the left tree is empty, do not need to worry about prev
                preorder.add(new Integer(curr.val));
                curr = curr.right;
                continue;
            }
            
            // the left tree is not empty
            
            // find the previous node in-order (right most of the left tree)
            rightmost = curr.left;
            while (rightmost.right != null && rightmost.right != curr) rightmost = rightmost.right;
            
            if (rightmost.right == null) {   // the first time countering curr
                preorder.add(new Integer(curr.val));
                rightmost.right = curr;  curr = curr.left;
            }else {                     // the second time countering curr
                rightmost.right = null;  curr = curr.right;
            }
        }
        return preorder;
    }
}*/

/**
 * More Neat Pre-Order
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                preorder.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }
        return preorder;
    }
}
        
