/**
 * -- rows, cloumes & 9 squares check
 * -- or we can store hashmaps for each row, cloume & 9 squares, then one pass
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 || board[0].length == 0)  return false;
        
        int row = board.length, colume = board[0].length;
        
        // rows
        for(int i=0; i<row; i++)
            if (!isValidSudoku(board, i, 0, i, colume-1))    return false;
        
        // colume
        for(int j=0; j<colume; j++) 
            if (!isValidSudoku(board, 0, j, row-1, j))  return false;
        
        // 9 squares
        for(int i=0; i<=6; i+=3) 
            for(int j=0; j<=6; j+=3) {
                if (!isValidSudoku(board, i, j, i+2, j+2))  return false;
            }
            
        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int topr, int leftc, int botr, int rightc) {
        HashSet<Character> set = new HashSet<>();
        
        for(int i=topr; i<=botr; i++)
            for(int j=leftc; j<=rightc; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c))    return false;
                    else set.add(c);
                }
            }
        return true;
    }
}
