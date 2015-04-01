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
 * Do not pop out the queue when adding a new level
 * Print from the queue end when reaching the tail of the tree
 * this works when do not return anything, but printing
 * if return the list, you just need to add to the res list
 * in the front instead of at the beginning
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)   return res;
        
        List<TreeNode> q = new ArrayList<>();
        q.add(root); q.add(null);
        
        int index = 0;
        while(true) {
            TreeNode node = q.get(index++);
            if (node == null) 
                if(q.size() == index)    break;  // reach the end
                else { q.add(null); continue; }
            
            if (node.right != null) q.add(node.right);
            if (node.left != null)  q.add(node.left);
        }
        
        // from leaf to root
        List<Integer> list = null;
        for(int i=q.size()-1; i>=0; i--) {
            if (q.get(i) == null) {
                if (list != null)   res.add(list);
                list = new ArrayList<>();
            }else {
                list.add(q.get(i).val);
            }
        }
        res.add(list);   // the root;
        return res;
        
    }
}
