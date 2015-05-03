/**
 * - DFS/BFS the grid for each cell marked as '1'
 * - Mark visited '1's as 'X's
 * - BFS may save spaces
 * 
 * - Make More Clean Code
 */

public class Solution {
    // XXXX more clean code
    private static final int[][] dict = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;    if (m == 0) return 0;
        int n = grid[0].length; if (n == 0) return 0;
        int count = 0;
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    //bfsMark(grid, i, j);
                    //dfsMark(grid, i, j);
                    dfsMarkShort(grid, i, j);
                    count++;
                }
            }
        return count;
    }
    
    // dfs clean & short version
    private void dfsMarkShort(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >=n || grid[i][j] != '1') 
            return;
        grid[i][j] = 'x';
        for(int k=0; k<dict.length; k++)
            dfsMarkShort(grid, i+dict[k][0], j+dict[k][1]);
    }
    
    // bfs clean & short version? not seems clean at all
    
    // dfs 
    private void dfsMark(char[][] grid, int i, int j) {
        grid[i][j] = 'x';
        int m = grid.length, n = grid[0].length;
        if (i > 0 && grid[i-1][j] == '1') 
            dfsMark(grid, i-1, j);
        if (i < m-1 && grid[i+1][j] == '1') 
            dfsMark(grid, i+1, j);
        if (j > 0 && grid[i][j-1] == '1') 
            dfsMark(grid, i, j-1);
        if (j < n-1 && grid[i][j+1] == '1') 
            dfsMark(grid, i, j+1);
    }
    
    // bfs
    private void bfsMark(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(i, j));
        grid[i][j] = 'x';
        
        // XXXX x -> m; y -> n
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0; k<size; k++) {
                Pair p = q.poll();
                if (p.x > 0 && grid[p.x-1][p.y] == '1') {
                    grid[p.x-1][p.y] = 'x';
                    q.offer(new Pair(p.x-1, p.y));
                }
                if (p.x < m-1 && grid[p.x+1][p.y] == '1') {
                    grid[p.x+1][p.y] = 'x';
                    q.offer(new Pair(p.x+1, p.y));
                }
                if (p.y > 0 && grid[p.x][p.y-1] == '1') {
                    grid[p.x][p.y-1] = 'x';
                    q.offer(new Pair(p.x, p.y-1));
                }
                if (p.y < n-1 && grid[p.x][p.y+1] == '1') {
                    grid[p.x][p.y+1] = 'x';
                    q.offer(new Pair(p.x, p.y+1));
                }
            }
        }
        
    }
    
    class Pair {
        int x, y;
        Pair(int x, int y) { this.x = x; this.y = y; }
    }
}
