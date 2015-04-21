/**
 * Line 48: java.lang.StackOverflowError
 * - Originally use DFS, but Stack Overflow
 * - So, I use BFS instead

 * - How to define whether a regoin is captured by X: surronded by X
 * - So, if O is not flipped, then there should be a connected O on the border
 * - Mark thouse unflippable O as Y
 * - then Mark O as X, Y as O
 */
public class Solution {
    public void solve(char[][] board) {
        int m = board.length;       if (m == 0) return;
        int n = board[0].length;    if (n == 0) return;
        
        // two border rows
        // XXXX wrong, what if m = 1;
        //for(int i=0; i<m; i+=m-1)
        for(int i : Arrays.asList(0, m-1))
            for(int j=0; j<n; j++) 
                if (board[i][j] == 'O')
                    mark(board, m, n, i, j);
        
        // two border columns
        // XXXX wrong, what if n = 1;
        // for(int j=0; j<n; j+=n-1)
        for(int j : Arrays.asList(0, n-1))
            for(int i=0; i<m; i++)
                if (board[i][j] == 'O')
                    mark(board, m, n, i, j);
                    
        // mark Y -> O & O -> X
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'Y') 
                    board[i][j] = 'O';
            }
    }
    
    // BFS Mark
    private void mark(char[][] board, int m, int n, int x, int y) {
        board[x][y] = 'Y';
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x*n+y);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0; k<size; k++) {
                int index = q.poll();
                x=index/n; y=index%n;
                if (x-1>=0 && board[x-1][y] == 'O') {
                    board[x-1][y] = 'Y';
                    q.offer((x-1)*n+y);
                }
                if (x+1<m && board[x+1][y] == 'O') {
                    board[x+1][y] = 'Y';
                    q.offer((x+1)*n+y);
                }
                if (y-1>=0 && board[x][y-1] == 'O') {
                    board[x][y-1] = 'Y';
                    q.offer(x*n+y-1);
                }
                if (y+1<n && board[x][y+1] == 'O') {
                    board[x][y+1] = 'Y';
                    q.offer(x*n+y+1);
                }
            }
        }
    }
    
    // DFS Mark
    /*private void mark(char[][] board, int m, int n, int x, int y) {
        board[x][y] = 'Y';
        
        if (x-1>=0 && board[x-1][y] == 'O')
            mark(board, m, n, x-1, y);
        
        if (x+1<m && board[x+1][y] == 'O')
            mark(board, m, n, x+1, y);
        
        if (y-1>=0 && board[x][y-1] == 'O')
            mark(board, m, n, x, y-1);
        
        if (y+1<n && board[x][y+1] == 'O')
            mark(board, m, n, x, y+1);
    }*/
}
