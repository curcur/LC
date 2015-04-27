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
 * - Level Traversal
 * - From right to left
 * - Only output the first element in each level
 */
 
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)   return res;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(i==0)
                    res.add(node.val);
                if (node.right!=null)   q.offer(node.right);
                if (node.left!=null)    q.offer(node.left);
            }
        }
        return res;
    }
}
