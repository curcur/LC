/**
 * ----------------------------------------------------------------------------
   Path Sum II
    - Given a binary tree and a sum, find all root-to-leaf paths where 
      each path's sum equals the given sum.

   For example:
    - Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
    
    - Return
      [
        [5,4,11,2],
        [5,8,4,5]
      ]
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 112 Path Sum
 * Tags: Tree Path, DFS
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
 
/**
 * - Record the path from the root to the current node, and remaining sum
 * - If reaching a leaf node and the total sum == target
 *   add the path to the result lists
 * - This kind of eturn all list problem, typically use a dfs (recursively)
 * - recover the path stack to the original after finishing
 *   one push & one pop
 *   
 * - all lists problem - return type is List<List<Somthing>>
 */

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<Integer> path = new Stack<>();
        pathSum(root, sum, path);
        return res;
    }
    
    private void pathSum(TreeNode root, int sum, Stack<Integer> path) {
        if (root == null)   return;
        if (root.left == null && root.right == null)
            if (root.val == sum) {
                path.push(root.val);
                res.add(new ArrayList<>(path));
                path.pop();
                return;
            }
        
        path.push(root.val);
        pathSum(root.left, sum-root.val, path);
        pathSum(root.right, sum-root.val, path);
        path.pop();
    }
}
