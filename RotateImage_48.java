/**
 * Observations:
 *  -- (i,j)  => (j, n-1-i)
 * 
 * Further Observations:
 *  -- Four rotations will go back
 *  -- (i,j) => (j, n-1-i) => (n-1-i, n-1-j) => (n-1-j, i) => (i, j)
 *  -- we can exchange elements between these four positions and rotate in place
 *  -- Notice: the mid can not cross the mid line, 
 *           a b c              rotate a b
 *           d e f                  no d e
 *           g h i
 */
/*public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=0; i<=(n-1)/2; i++)
            for(int j=0; j<n/2; j++) {          // $$$$$$$$$ special attention to i & j
                int temp = matrix[i][j];
                
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
    }
}*/

/**
 * More General Method from others
 * The above method is too tricky
 * we can do it more generally
 * 
 * a b c
 * d e f
 * g h i
 * 
 * i row -> n-1-i column
 * i row -> n-1-i row -> n-1-i column  (top-down, adn then symmetric)
 */ 
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // upside - down
        for(int i=0; i<n/2; i++) 
            for(int j=0; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        
        // symmetric
        for(int i=0; i<n; i++)
            for(int j=0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        
    }
}
