/**
 * DP
 * My original thought - Similar to the longest-shortest latency
 * - suppose starting with 0 hp
 * - M(i,j): Among all paths, the maximal minimal hp along the path
 *   - each path has a minimal hp point 
 *   - we chose the path with maximal such point
 * - two ways to get to position (i,j), right & down
 * - M(i, j) = right: Min { M(i, j-1), F(i, j-1) + dungeon(i,j) }, 
 *   - where F(i, j) is the current hp when reaching position (i, j) 
 *     using the chosen path
 *   - if F(i, j-1) + dungeon(i,j) < M(i, j-1); 
 *   - F(i, j-1) + dungeon(i,j) is not guaranteed to be 
 *     the maximal minimal hp over all paths
 * 
 * How to Solve it? "table-filling"
 * - HP(i, j) = the minimal hp needed to enter position (i, j) 
 *   to suvive in the final posistion
 *   - HP(i, j) = Min { HP(i+1, j), HP(i, j+1) } - dungeon(i, j)
 *   - HP(i, j) = Max {1, HP(i, j)}        
 */

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] hp = new int[n+1];    // adding dummy column
        
        // initiate
        hp[n] = 1;
        for(int j=n-1; j>=0; j--) 
            // hp[j] can not be less than 1
           hp[j] = Math.max(1, hp[j+1] - dungeon[m-1][j]);
                
        for(int i=m-2; i>=0; i--) {
            hp[n-1] = Math.max(1, hp[n-1]- dungeon[i][n-1]);
            for(int j=n-2; j>=0; j--) {
                hp[j] = Math.min(hp[j], hp[j+1]) - dungeon[i][j];
                hp[j] = Math.max(1, hp[j]);
            }
        }
        return hp[0];
    }
}
