/**
 * 1. From the mid <-, ->
 * O(n), no space is needed 2n-1 centers
 */ 
 
/*public class Solution {
    public String longestPalindrome(String s) {
        int maxi = 0, maxj = 0, i = 0, j = 0;
        for (int k=0; k<s.length(); k++) {
            //  1. XkX
            i = k-1; j = k+1;
            while (i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) { i--; j++; }
            i++; j--;                           // XXXX the corner case
            if (maxj - maxi < j - i)  { maxj = j; maxi = i;}   
            
            // 2. Xk
            i = k-1; j = k;
            while (i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) { i--; j++; }
            i++; j--;
            if (maxj - maxi < j - i)  { maxj = j; maxi = i;}
        }
        
        return s.substring(maxi, maxj+1);
    }
}*/

/**
 * Dynamic Programming P(i,j): whether substring(i,j+1) is palindromic
 */
public class Solution {
    public String longestPalindrome(String s) { 
        
        boolean[][] P = new boolean[s.length()][s.length()];
        int maxi = 0, maxj = 0;
        
        // initialization
        for(int k=0; k<s.length(); k++) {
            P[k][k] = true;         // k
            
            if (k+1 < s.length() && s.charAt(k) == s.charAt(k+1) ) {
                P[k][k+1] = true;   // kk
                if (maxj - maxi < k+1 - k) { maxj = k+1; maxi = k; }
            }
        }
        
        for(int i=s.length()-3; i>=0; i--) 
            for (int j=i+2; j<s.length(); j++) {
                if (P[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    P[i][j] = true;
                    if (maxj - maxi < j - i) { maxj = j; maxi = i; }
                }
            }
        
        return s.substring(maxi, maxj+1);
    }
}
