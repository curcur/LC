/**
 * DP
 * - sum(i,j) = min(sum[i-1][j], sum[i][j-1]) + grid[i][j]
 * - Of course, this can be reduced to one dimensional array sumi[j]
 * - Min still holds the optimal substructure feature
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;    if (m == 0) return 0;
        int n = grid[0].length; if (n == 0) return 0;
        
        int[] sum = new int[n];
        // initiate
        sum[0] = grid[0][0];
        for(int j=1; j<n; j++)
            sum[j] = sum[j-1] + grid[0][j];   // move right, only way
        
        for(int i=1; i<m; i++) {
            sum[0] += grid[i][0];            // move down, only way
            for(int j=1; j<n; j++) 
                sum[j] = Math.min(sum[j], sum[j-1]) + grid[i][j];
        }
        return sum[n-1];
    }
}
