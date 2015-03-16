/**
 * 1. My first solution is using O(n) space to record whether a column should be 0
 *    Row can filled while going through the matrix
 * 
 * 2. Constant Space Solution?
 *   -- Fill in other numbers to represent 0, for example 1 (all other elements increase 1)
 *   -- Find a way to store the O(n): the first row to store the column state
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0)     return;
        
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow0 = false, firstCol0 = false;
        for(int j=0; j<n; j++)  if (matrix[0][j] == 0)  { firstRow0 = true; break; }
        for(int i=0; i<m; i++)  if (matrix[i][0] == 0)  { firstCol0 = true; break; }
        
        for(int i=1; i<m; i++)
            for(int j=1; j<n; j++) 
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
        
        // this also works
        /*for(int j=1; j<n; j++) 
            if (matrix[0][j] == 0) 
                for(int i=1; i<m; i++) matrix[i][j] = 0;
        
        for(int i=1; i<m; i++)
            if(matrix[i][0] == 0)
                for(int j=1; j<n; j++) matrix[i][j] = 0;*/
        
        for (int i=1; i<m; i++)
            for(int j=1; j<n; j++) 
                matrix[i][j] = (matrix[i][0] == 0 || matrix[0][j] == 0) ? 0 : matrix[i][j];
            
                
        if (firstRow0) for(int j=0; j<n; j++) matrix[0][j] = 0;
        if (firstCol0) for(int i=0; i<m; i++) matrix[i][0] = 0;
        
    }
}
