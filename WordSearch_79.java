/**
 * DFS
 *  - boolean[][] state
 *  - How to save additional boolean space
 *  - Brilliant thought: char[x][y] ^= 256 -> unvalid character
 *                                  ^= 256 -> recover the original character
 *                                  this only works for ASCII
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;       if (m == 0) return false;
        int n = board[0].length;    if (n == 0) return false;
        int length = word.length();
        
        boolean[][] state = new boolean[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                if (exist(board, word, state, m, n, length, i, j, 1))
                    return true;
                
            }
            return false;
    }
    
    private boolean exist(char[][] board, String word, boolean[][] state, 
			  int m, int n, int length, int i, int j, int clength) {
        
        // XXXX more clean code
        if (i<0 || i>m-1 || j<0 || j>n-1 || state[i][j] || 
	    word.charAt(clength-1) != board[i][j])
            return false;
            
        if (clength == length)  return true;
        
        state[i][j] = true;
        boolean exist = 
            exist(board, word, state, m, n, length, i-1, j, clength+1) ||
            exist(board, word, state, m, n, length, i+1, j, clength+1) ||
            exist(board, word, state, m, n, length, i, j-1, clength+1) ||
            exist(board, word, state, m, n, length, i, j+1, clength+1);
        state[i][j] = false;
        return exist;
    }
}
