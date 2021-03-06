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
 * - Inorder + Preorder/Postorder/Level order can recover a binary tree
 * - Other combinations can not
 * - Inorder must be included to decide left/right subtrees
 * - The other order is used to determine the root
 */

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1,
                            inorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder, int prestart, int preend,
                                int[] inorder, int instart, int inend) {
        if (preend < prestart)  return null;
        
        TreeNode root = new TreeNode(preorder[prestart]);
        int rootindex = instart;    // find root index in inorder
        for(; rootindex<=inend; rootindex++) 
            if(inorder[rootindex] == preorder[prestart])
                break;
        
        int leftlength = rootindex - instart;
        TreeNode left = buildTree(preorder, prestart+1, prestart+leftlength,
                                    inorder, instart, rootindex-1);
        TreeNode right = buildTree(preorder, prestart+leftlength+1, preend,
                                    inorder, rootindex+1, inend);
        root.left = left;
        root.right = right;
        return root;
                                    
    }
}


/**
 * Iteratively?
 */
