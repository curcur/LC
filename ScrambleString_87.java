/**
 * Scramble String
 * - Same length
 * - s1[0...i] is scramble of s2[0...i] & s1[i+1...length-1] 
 *   is scramble of s2[i+1...length-1]
 *   or s1[0...i] is scramble of s2[length-1-i...length-1] & s1[i+1...length-1]
 *   is scramble of s2[0...length-1-i-1]
 *   exists one i
 * - This of course is not efficient -- Time Limit Exceeded
 * - pruning, must contain the same set of chars
 * - Time Complexity: 
 *   T(n) = 2(T(1) + T(n - 1) + T(2) + T(n - 2) + ... + T(n - 1) + T(1)) 
 *        = 4(T(1) + T(2) + ... + T(n - 1))
 *   =>  Exponential
 */

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) 
            return false;
        
        if (!anagrams(s1, s2))
            return false;
            
        int length = s1.length();
        if (length == 0 || length == 1)    
            return true;        // empty string or single letter string

        for(int i=1; i<length; i++) {
	    if ((isScramble(s1.substring(0, i), s2.substring(0, i)) &&
		 isScramble(s1.substring(i, length), s2.substring(i, length))) 
		||
                (isScramble(s1.substring(0, i), s2.substring(length-i, length)) &&
		 isScramble(s1.substring(i, length), s2.substring(0, length-i))))
                return true;
        }
        return false;
    }
    
    private boolean anagrams(String s1, String s2) {
        HashMap<Character, Integer> hp = new HashMap<>();
        int length = s1.length();
        for(int i=0; i<length; i++) {
            char c = s1.charAt(i);
            if (!hp.containsKey(c))
                hp.put(c, 0);
            hp.put(c, hp.get(c)+1);
        }
        
        for(int i=0; i<length; i++) {
            char c = s2.charAt(i);
            if (!hp.containsKey(c) || hp.get(c)<=0)
                return false;
            else 
                hp.put(c, hp.get(c)-1);
        }
        return true;
    }
}

/**
 * The Recursive version has a lot of redudant work
 * so we can remember intermediate states & use DP
 * - F[k][i][j]
 *  s1 starting with index i & s2 starting with index j
 *  with length k scramble?
 * 
 * Time Complexity O(n^4)
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) 
            return false;
        
        int length = s1.length();
        if (length == 0)
            return true;
            
        boolean[][][] F = new boolean[length+1][length][length];
        
        // initialization, length = 1
        for(int i=0; i<length; i++)
            for(int j=0; j<length; j++) 
                F[1][i][j] = s1.charAt(i) == s2.charAt(j);
            
        for(int k=2; k<=length; k++)                // length
            for(int i=0; i<=length-k; i++)          // s1
                for(int j=0; j<=length-k; j++) {    // s2
                    for(int l=1; l<k; l++) {        // each split
                        if ((F[l][i][j] && F[k-l][i+l][j+l]) ||
                            (F[l][i][k-l+j] && F[k-l][i+l][j])) {
                                F[k][i][j] = true;
                                break;
                            }
                    }
                }
        return F[length][0][0];
    }
    
}
