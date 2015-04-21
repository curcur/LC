/**
 * ----------------------------------------------------------------------------
   Palindrome Partitioning II
    - Given a string s, partition s such that every substring of the partition 
      is a palindrome.
    - Return the minimum cuts needed for a palindrome partitioning of s.

   For example, given s = "aab",
    - Return 1 since the palindrome partitioning ["aa","b"] 
      could be produced using 1 cut.
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 131	Palindrome Partitioning 
 */

/**
 * 1. Two States:
 *   - MinCut[i], the minimal cut till s[i-1]
 *   - palidrome[i][j], whether s(i...j) is a palindrome or not
 * - MinCut[i] = Min{ MinCut[j]+1 if s(j...i) is palindrome} for each j<i
 */

public class Solution {
    public int minCut(String s) {
        int length = s.length();
        int[] MinCut = new int[length+1];   // MinCut[i] -- s[i-1]
        MinCut[0] = -1;
        
        boolean[][] palindrome = new boolean[length][length];
        for(int i=0; i<length; i++) {
            MinCut[i+1] = MinCut[i] + 1;
            palindrome[i][i] = true;
            
            for(int j=i-1; j>=0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    if(j+1 > i-1) palindrome[j][i] = true;
                    else palindrome[j][i] = palindrome[j+1][i-1];
                }
                if (palindrome[j][i])  
                    MinCut[i+1] = Math.min(MinCut[i+1], MinCut[j]+1);
            }
        }
        
        return MinCut[length];
    }
}

//------------------------------------------------------------------------------

/**
 * 2. One more Clever Method
 * - MinCut[] is as before, but does not need palindrome[][]. 
 * - expand using i as the center
 */
public class Solution {
    public int minCut(String s) {
        int length = s.length();
        int[] MinCut = new int[length+1];
        
        for(int i=0; i<length+1; i++)  MinCut[i] = i-1;
        
        for(int i=0; i<length; i++) {
            for(int j=0; i-j >=0 && i+j < length 
		    && s.charAt(i-j) == s.charAt(i+j); j++) {   // odd
                MinCut[i+j+1] = Math.min(MinCut[i+j+1], MinCut[i-j] + 1);
            }
            
            for(int j=1; i-j+1>=0 && i+j<length 
		    && s.charAt(i-j+1) == s.charAt(i+j); j++) { // even
                MinCut[i+j+1] = Math.min(MinCut[i+j+1], MinCut[i-j+1] + 1);    
            }
        }
        
        return MinCut[length];
    }
}
