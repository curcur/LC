/**
 * - Four Borders:  left, right, top, botom
 * - ENUM usage
 * - ENUM in switch, should not contain the name of ENUM
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n-1, top = 0, bottom = n-1;
        int[][] matrix = new int[n][n];
        
        int i=0, j=0, value = 1;
        Turn turn = Turn.RIGHT;
        
        while(value<=n*n) { 
        //while(left<=right && top<=bottom){  // this also works
            switch(turn) {
            	case RIGHT: matrix[i][j++] = value++;
                            if(j>right) { turn = Turn.DOWN; top++; j--; i++; }
                            break;
            	case DOWN:  matrix[i++][j] = value++;
                            if(i>bottom) { turn = Turn.LEFT; right--; i--; j--;}
                            break;
            	case LEFT:  matrix[i][j--] = value++;
                            if(j<left) { turn = Turn.UP; bottom--; j++; i--; }
                            break;
            	case UP:    matrix[i--][j] = value++;
                            if(i<top) { turn = Turn.RIGHT; left++; i++; j++; }
                            break;
                default:    break;
            }
        }
        
        return matrix;
    }
    
    private enum Turn {RIGHT, LEFT, UP, DOWN}
}
