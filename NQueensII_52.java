/**
 * 1. The first way is from the N-Queens I
 */
public class Solution {
    
    int totalSolution = 0;
    
    public int totalNQueens(int n) {
        if (n == 0)     return 0;
        
        int[] Queens = new int[n];                    // Queens[row] = column
        HashSet<Integer> columns = new HashSet<>();   // columns already used
        solveQueens(Queens, 0, columns);
        return totalSolution;
        
    }
    
    private void solveQueens(int[] Queens, int row, HashSet<Integer> columns) {
        int n = Queens.length;
        if (row == n)   { totalSolution++;  return; }
        
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
}


/**
 * 2. Three HashSets - Smart way to detect diagonal
 * - HashSet<Integer> columns
 * - HashSet<Integer> upperleftdiagonal     row-column
 * - HashSet<Integer> upperrightdiagonal    row+column
 */
public class Solution {
    private Set<Integer> columns = new HashSet<>();
    private Set<Integer> upperleft = new HashSet<>();
    private Set<Integer> upperright = new HashSet<>();
    
    public int totalNQueens(int n) {
        if (n == 0)     return 0;
        return totalNQueens(0, n);
    }
    
    private int totalNQueens(int row, int n) {
        if (row == n)   return 1;
        
        int total = 0;
        for(int j=0; j<n; j++) {
            if (columns.contains(j) 
		|| upperleft.contains(row-j) || upperright.contains(row+j))
                continue;
            columns.add(j); 
	    upperleft.add(row-j); upperright.add(row+j);
            
	    total += totalNQueens(row+1, n);
            
	    columns.remove(j); 
	    upperleft.remove(row-j); upperright.remove(row+j);
        }
        return total;
    }
}
