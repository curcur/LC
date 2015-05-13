/**
 * ----------------------------------------------------------------------------
   Regular Expression Matching
    - Implement regular expression matching with support for '.' and '*'.
    - '.' Matches any single character.
    - '*' Matches zero or more of the preceding element.
    - The matching should cover the entire input string (not partial).

   The function prototype should be:
    - bool isMatch(const char *s, const char *p)

   Some examples:
    - isMatch("aa","a") → false
    - isMatch("aa","aa") → true
    - isMatch("aaa","aa") → false
    - isMatch("aa", "a*") → true
    - isMatch("aa", ".*") → true
    - isMatch("ab", ".*") → true
    - isMatch("aab", "c*a*b") → true
 * ----------------------------------------------------------------------------
 */

/**
 * This kind of problem can always be solved by Recursion.
 * - Corner case: s is empty, p is X*
 * 
 * - We start by solving '*'
 * - X* can be think of as 0, 1, 2,..., as many X as possible
 *      - match(s, i, p, j+2)  "0 X"
 *      - match(s, i+1, p, j)   if s[i] matches p[j]
 * - if there is no * following X, then p[i] has to match with s[j] 
 * - DP method next time
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
    
    // s[j] vs p[i]
    private boolean isMatch(String s, int j, String p, int i) {
        
        // when pattern reaches the end, string should also reach the end
        if (i == p.length())   return j == s.length();
    
        if (i+1 < p.length() && p.charAt(i+1) == '*') {
            if (isMatch(s, j, p, i+2))  return true;  //  0 X
            
            if (j < s.length() && 
		(s.charAt(j) == p.charAt(i) || p.charAt(i) == '.'))
                return isMatch(s, j+1, p, i);
            
            // The above statement is equivalent to the following statement
            // while(j < s.length() && 
	    //	  (s.charAt(j) == p.charAt(i) || p.charAt(i) == '.'))
            //    if (isMatch(s, ++j, p, i+2))    return true;
        }
        else if (j < s.length() 
		 && (s.charAt(j) == p.charAt(i) || p.charAt(i) == '.'))
            return isMatch(s, j+1, p, i+1);
        
        return false;
    }
}
