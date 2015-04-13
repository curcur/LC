/**
 * - use 1...j...n & recursion
 */
 
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> tnl = new ArrayList<>();
        if (start > end) 
            tnl.add(null);

        for(int i=start; i<=end; i++) {
            List<TreeNode> leftlist = generateTrees(start, i-1);
            List<TreeNode> rightlist = generateTrees(i+1, end);
            
            for(TreeNode left : leftlist)
                for(TreeNode right : rightlist) {
                    TreeNode tn = new TreeNode(i);
                    tn.left = left;
                    tn.right = right;
                    tnl.add(tn);
                }
        }
        return tnl;
    }
}
