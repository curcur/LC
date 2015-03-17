/**
 * The problem statement is very vague. I think what the questions means is try to 
 * find subsequences in S, such that the subsequence is same as T.
 * 
 * I always did badly in strings!
 * 
 * 1. Sliding Window -- not work, the target string also needs to maintain order
 *                   -- substring matching, not true, because it can cut any strings
 * 
 * 2. DP -- Similar to the edit distance problem
 * F[i, j] the number of ways from S(0...i) to T(0...j)
 * F[i,j] = 0 if j>i
 *          F[i-1,j] { remove S[i]  } + F[i-1, j-1] * (S[i] == S[j])
 *      
 */
/*public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length(), n = T.length();
        int[][] F = new int[m+1][n+1];
        
        //F[0][0] = 1;    // S, T both empty. 
        for(int i=0; i<=m; i++)     // XXXXXXXXXXX very S to empty T is 1
            F[i][0] = 1;
        
        for(int i=0; i<m; i++)
            for(int j=0; j<=i && j<n; j++) {
                F[i+1][j+1] = F[i][j+1];
                if (S.charAt(i) == T.charAt(j)) 
                    F[i+1][j+1] += F[i][j];
            }
        return F[m][n];
    }
}*/

/**
 * As usual, this can be optimized to just use O(n) array
 */
public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length(), n = T.length();
        if (n == 0)     return 1;
        
        int[] F = new int[n];
        
        for(int i=0; i<m; i++) {
            int previj = 1;
            for(int j=0; j<=i && j<n; j++) {
                int temp = F[j];
                F[j] += S.charAt(i) == T.charAt(j) ? previj : 0;
                previj = temp;
            }
        }
        return F[n-1];
    }
}
