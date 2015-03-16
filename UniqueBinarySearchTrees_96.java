/**
 * 1. DP -- 
 * 
 * F(4) = 2 * F(3) + F(2) * F(4-2-1) + F(1) * F(4-1-1)
 * See related attachment
 * 
 */
/*public class Solution {
    public int numTrees(int n) {
        int[] F = new int[n+1];       // number of different trees
        F[1] = 1;
        
        for(int i=2; i<=n; i++) {
            F[i] = 2 * F[i-1];
            
            for(int j= i-2; j>0; j--) {
                F[i] += F[j]*F[i-j-1];
            }
        }
        return F[n];
    }
}*/

/**
 * 2. DP -- More Clear
 * Construction Unique
 * 1...i...n
 * (1...i-1) --> left
 * (i+1...n) --> right
 * 
 * unique
 */
public class Solution {
    public int numTrees(int n) {
        int[] F = new int[n+1];
        F[0] = 1;
        
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                F[i] += F[j] * F[i-j-1];
            }
        }
        return F[n];
    }
}
