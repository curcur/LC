
/**
 * normally dyanamic programming needs a initial state, the empty one
 */

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] MinDist = new int[m+1][n+1];
        int min = 0;
        
        // M[i][j] length=i; length=j
        // initialization
        for(int i=1; i<=m; i++) MinDist[i][0] = i;
        for(int j=1; j<=n; j++) MinDist[0][j] = j;
        
        for(int i=1; i<=m; i++) 
            for(int j=1; j<=n; j++) {
                min = (word1.charAt(i-1) == word2.charAt(j-1)) ? MinDist[i-1][j-1] : MinDist[i-1][j-1]+1;   // replace
                min = Math.min(MinDist[i-1][j]+1, min);     // delete
                min = Math.min(MinDist[i][j-1]+1, min);     // insert
                MinDist[i][j] = min;
            }
            
        return MinDist[m][n];
    }
}
