public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = (m == 0) ? 0 : obstacleGrid[0].length;
        if (m == 0 || n == 0)   return 0;
        
        int[][] F = new int[m+1][n+1];
        F[0][1] = 1;
        
        for(int i=1; i<=m; i++)
            for(int j=1; j<=n; j++) {
                F[i][j] = (obstacleGrid[i-1][j-1] > 0) ? 0 : F[i-1][j] + F[i][j-1];
            }
        return F[m][n];
    }
    
}
