Wildcard Matching
    - Implement wildcard pattern matching with support for '?' and '*'
    - '?' Matches any single character.
    - '*' Matches any sequence of characters (including the empty sequence).
    - The matching should cover the entire input string (not partial).

/**
 * 1. Time Limit Exceeded
 * - Naive Recursion 
 */

public class Solution {
    public boolean isMatch(String s, String p) { return isMatch(s, 0, p, 0); }
    
    // si & pi are start position of s and p respectively
    public boolean isMatch(String s, int si, String p, int pi) {
        if (si == s.length() && pi == p.length())   return true;
        if (si == s.length() || pi == p.length())   return false;
        
        if (p.charAt(pi) == '*') {
            
	    // XXXX optimization, one star = several successive stars
            while(pi+1 < p.length() && p.charAt(pi+1) == '*') pi++;
            
            for(int i=si; i<=s.length(); i++) {
                if (isMatch(s, i, p, pi+1))     return true;
            }
            return false;
        } else if (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si)) {
            return isMatch(s, si+1, p, pi+1);
        } else return false;
    }
}


//------------------------------------------------------------------------------

/**
 * 2. Iterative Method (Smart)
 * - When meeting * in p, remember the position snext in s
 * - Try to match the substring after * in p with substring after s[snext] in s
 * - If not matchable, snext++ & try again until snext reaches the end of s
 * - If during the matching phase, we meet another * in p
 *   we should try to match after the new * in p with s[snext]

 * - Example:
 *   s: abcdjabcdjabcdj
 *   p: a*dj*dj
 * 
 * - if p[i] == s[j] or p[i] == '?' i++; j++
 * - if p[i] == * i++, try to match p[i]... p[p.length-1] 
     to s[j]..., s[j+1]..., ... 
 * 
 * - In the example, 'dj' in s will match with the first dj in p, then * again,
 *   the second dj in p will match with the last dj in s.
 * 
 * There are several things need to be highlighted here:
 * - 1). multiple * in the pattern: only the right most works
 * - 2). if * is the last char in the pattern, then s matches p
 * - 3). if j reaches the end of s, but i does not reach the end of p; 
 *       set j to the new start will not match either (not enough character)
 * - 4). if having multiple stars like(*dj*) in the example, 
 *       we will loop snext on the new * instead of old ones.
 */

public class Solution {
    public boolean isMatch(String s, String p) {
	// i points to p, j points to s
        // pstart: char after * in pattern; 
	// snext: the loop start when found a * in the pattern
	int i = 0, j = 0, pstart = -1, snext = -1;

        while(j<s.length()) {
	    // single character matches
            if (i<p.length() && (p.charAt(i) == s.charAt(j) 
				 || p.charAt(i) == '?')) { i++; j++; }
	    // * character matches
            else if (i<p.length() && p.charAt(i) == '*') {
                pstart = ++i; snext = j; }

	    // in the case i >= p.length() & loop through s from snext
            else if (snext >= 0) {
                j = snext++; i = pstart;
            }
            else return false;
        }
        
        // pattern has strings left
        while(i<p.length() && p.charAt(i) == '*') i++; // the rightmost *
        return i == p.length() ;
    }
}
