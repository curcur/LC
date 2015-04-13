/**
 * Increasing order 
 * -> .... ->
 * -> .... ->
 * This is a binary search in two dimensional matrix
 */
 
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;      if (m == 0) return false;
        int n = matrix[0].length;   if(n == 0) return false;
        
        int l = 0, r = m*n-1;
        while(l<=r) {
            int mid = (l+r)/2;
	    // $$$$ how to convert from one dimensional index to two
            int v = matrix[mid/n][mid%n];      
            if (v == target)    return true;
            else if (v > target) r = mid-1;
            else l = mid+1;
        }
        return false;
    }
}
