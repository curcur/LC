/**
 * F[i][j]: number of unique paths with cord (i,j) as end;
 * two ways: 
 *          down: from F[i-1][j]
 *          right: from F[i][j-1]
 */
/*public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)   return 0;
        
        int[][] F = new int[m+1][n+1];
        
        //for(int j=1; j<=n; j++)     F[1][j] = 1;  
        //for(int i=1; i<=m; i++)     F[i][1] = 1;
        
        F[0][1] = 1;    // more neat. equal to say F[1][1] = 1
        
        for(int i=1; i<=m; i++)
            for(int j=1; j<=n; j++) {
                F[i][j] = F[i-1][j] + F[i][j-1];
            }
        return F[m][n];
    }
}*/



/**
 * Now we want to save some space
 * for every for i, store i, and i-1 is enough
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)   return 0;
        
        int[][] F = new int[2][n+1];
        
        for(int j=1; j<=n; j++)     F[1][j] = 1;  
        //for(int i=1; i<=m; i++)     F[i][1] = 1;
        F[0][1] =1;
        
        for(int i=2; i<=m; i++)
            for(int j=2; j<=n; j++) {
                F[i%2][j] = F[(i-1)%2][j] + F[i%2][j-1];
            }
        return F[m%2][n];
    }
}
