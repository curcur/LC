/**
 * Two dimensional matrices, the first is rows matrix.length, then columns, matrix[0].length; 
 */ 
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        // XXXXXXXXXXXXXX matrix is empty!!!
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) return result;
        
        int i = 0, j = 0, m = matrix.length, n = matrix[0].length, direction = 0; // 0 right, 1 down, 2 left, 3 up
        int left = 0, right = n-1, up = 0, down = m-1;  // four corners
        
        //while( i != m/2 || j !=(n-1)/2 ) {  XXXXXXXXX this is wrong!!!!!
        while( left <= right && up <= down ) {
            switch(direction) {
                case 0 :
                    for(;j<=right;j++)   result.add(matrix[i][j]);
                    j--; i++; direction = 1; up++; break;
                case 1 :
                    for(;i<=down; i++)   result.add(matrix[i][j]);
                    i--; j--; direction = 2; right--; break;
                case 2 :
                    for(;j>=left; j--)   result.add(matrix[i][j]);
                    j++; i--; direction = 3; down--; break;
                case 3 :
                    for(;i>=up; i--) result.add(matrix[i][j]);
                    i++; j++; direction = 0; left++; break;
                default: break;
            }
        }
        //result.add(matrix[i][j]);
        return result;
    }
}
