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
 * This version uses up to much spaces!
 */
/*public class Solution {
    
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        
        pathSum(root, sum, path);
        return paths;
    }
    
    private void pathSum(TreeNode root, int sum, List<Integer> path) {
        if (root == null)   return;
        path.add(root.val);
        
        if (root.left == null && root.right == null) {
            if(sum == root.val) { paths.add(path); }
            return;
        }
        
        if (root.left != null) {
            List<Integer> pathleft = new ArrayList<>(path);
            pathSum(root.left, sum-root.val, pathleft);
        }
        if (root.right != null) {
            List<Integer> pathright = new ArrayList<>(path);
            pathSum(root.right, sum-root.val, pathright);
        }
        
    }
}*/


/**
 * Try to only use one path list
 * pop_up the node every time you return
 */
public class Solution {
    
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<Integer> path = new Stack<>();
        
        pathSum(root, sum, path);
        return paths;
    }
    
    private void pathSum(TreeNode root, int sum, Stack<Integer> path) {
        if (root == null)   return;
        path.push(root.val);
        
        if (root.left == null && root.right == null) {
            if(sum == root.val) { paths.add((List)path.clone()); }
            path.pop();
            return;
        }
        
        if (root.left != null) {
            pathSum(root.left, sum-root.val, path);
        }
        if (root.right != null) {
            pathSum(root.right, sum-root.val, path);
        }
        path.pop();
    }
}
