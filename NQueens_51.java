/**
 * requirements:
 * - No two queens share the same row, column, or diagonal.
 * - DFS
 * - Queens[row] = column
 * - HashSet to record columns already been allocated
 */

public class Solution {
    List<String[]> res = new ArrayList<>();
    
    public List<String[]> solveNQueens(int n) {
        if (n == 0)     return res;
        
        int[] Queens = new int[n];      // Queens[row] = column
        HashSet<Integer> columns = new HashSet<>();   // columns already used
        solveQueens(Queens, 0, columns);
        return res;
    }
    
    private void solveQueens(int[] Queens, int row, HashSet<Integer> columns) {
        int n = Queens.length;
        if (row == n) {
            res.add(queens2String(Queens));
            return;
        }
        
        for(int j=0; j<n; j++) {
            if (columns.contains(j))    continue;
            
            // diagonal
            if (!diaValid(Queens, row, j))  continue;
            
            Queens[row] = j;    columns.add(j);
            solveQueens(Queens, row+1, columns);
            columns.remove(j);
        }
    }
    
    private boolean diaValid(int[] Queens, int row, int cloumn) {
        int n = Queens.length;
        
	// upper-left
        for(int r=row-1, c=cloumn-1; r>=0 && c>=0; r--, c--)
            if (Queens[r] == c)     return false;
	
	// upper-right
        for(int r=row-1, c=cloumn+1; r>=0 && c<n; r--, c++)
            if (Queens[r] == c)     return false;
        return true;
    }
    
    private String[] queens2String(int[] Queens) {
        int n = Queens.length;
        String[] strs = new String[n];
             
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++)
                if (Queens[i] == j) sb.append('Q');
                else sb.append('.');
            strs[i] = sb.toString();
        }
        return strs;
    }
}
