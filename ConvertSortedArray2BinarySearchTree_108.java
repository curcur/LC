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
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length);
    }
    
    public TreeNode sortedArrayToBST(int[] num, int l, int r) {
        if (l>=r)   return null;
        int mid = (l+r)/2;
        TreeNode tn = new TreeNode(num[mid]);
        tn.left = sortedArrayToBST(num, l, mid);
        tn.right = sortedArrayToBST(num, mid+1, r);
        return tn;
    }
}
