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
 * Recursion:
 * The root in the postorder is at the end, using in-order, can decide the left & right tree
 */
public class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        
        for(int i=0; i<length; i++) {  map.put(inorder[i], i); }
        return buildTree(inorder, 0, length-1, postorder, 0, length-1);
    }
    
    private TreeNode buildTree(int[] inorder, int lI, int rI, int[] postorder, int lP, int rP) {
        if (lI > rI)   return null;
        TreeNode root = new TreeNode(postorder[rP]);
        int rootidx = map.get(root.val);
        TreeNode left = buildTree(inorder, lI, rootidx-1, postorder, lP, lP+rootidx-1-lI);
        TreeNode right = buildTree(inorder, rootidx+1, rI, postorder, lP+rootidx-lI, rP-1);
        
        root.left = left;
        root.right = right;
        return root;                
    }
}

/**
 * without recursion?
 */
