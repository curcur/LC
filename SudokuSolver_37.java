public class Solution {
    public void solveSudoku(char[][] board) {
        Pair nextp = next(board, new Pair(0, 0));
        solveSudoku(board, nextp);
    }
    
    private boolean solveSudoku(char[][] board, Pair p) {
        if (p == null)  return true;

	//use set to prone early.
        HashSet<Character> set = new HashSet<>();
        for(int i=1; i<=9; i++) set.add((char)('0' + i));
        
        for(int i=0; i<board[0].length; i++) set.remove(board[p.x][i]);
        for(int i=0; i<board.length; i++) set.remove(board[i][p.y]);
        //for(int i=p.x%3; i<p.x%3+3; i++)         
        //    for(int j=p.y%3; j<p.y%3+3; j++)
        for(int i=p.x/3*3; i<p.x/3*3+3; i++)         // XXXXXXXX wrong at first time
            for(int j=p.y/3*3; j<p.y/3*3+3; j++)
                set.remove(board[i][j]);
                
        // now set contains all possible value p can choose
        if (set.isEmpty())  return false;
        for(Character c: set) {
            board[p.x][p.y] = c;
            boolean cansolve = solveSudoku(board, next(board, p));
            if(cansolve)   return true;
        }
        
        // can not solve even if all possible values tried
        board[p.x][p.y] = '.';
        return false;
    }
    
    private Pair next(char[][] board, Pair p) {
        for(int i=p.x; i<board.length; i++) {
            int j = (i == p.x) ? p.y : 0;    /// XXXXXXXXXXX if i!=p.x, j should start from 0
            for(; j<board[0].length; j++) 
                if (board[i][j] == '.') return new Pair(i, j);
        }
        
        return null;
    }
    
    public class Pair {
        int x, y;
        Pair(int x, int y) { this.x = x; this.y = y; }
    }
}
