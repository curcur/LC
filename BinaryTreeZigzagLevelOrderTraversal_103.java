/**
 * - The same as normal level order traversal
 * - Reverse output in even level
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
 
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        
        // XXXX empty root
        if (root != null) {
            queue.offer(root);
        }
        
        while(!queue.isEmpty()) {
            int size = queue.size();    // use size for level traversal
            List<Integer> zigzaglevel = new LinkedList<>();
            zigzag.add(zigzaglevel);
            
            for(int i=0; i<size; i++) {
                TreeNode tn = queue.poll();
                if (tn.left != null)    queue.offer(tn.left);
                if (tn.right != null)   queue.offer(tn.right);
                if(level%2 == 0)    zigzaglevel.add(tn.val);
                else zigzaglevel.add(0, tn.val);
            }
            level++;
        }
        
        return zigzag;
    }
}
