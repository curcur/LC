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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)   return lists;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); q.offer(null);  // the marker of the end of a level
        List<Integer> list = new ArrayList<>();
        
        while (!q.isEmpty()) {
            TreeNode tn = q.poll();
            if (tn == null) {
                lists.add(list);
                if (q.isEmpty())    break;
                
                list = new ArrayList<>();
                q.offer(null);
            }else{
                list.add(tn.val);
                if(tn.left != null) q.offer(tn.left);
                if(tn.right != null) q.offer(tn.right);
            }
        }
        return lists;
    }
}
