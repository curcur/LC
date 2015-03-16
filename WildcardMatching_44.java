/**
 * Time Limit Exceeded
 * -- First Thought
 * -- Naive Recursion 
 */
/*public class Solution {
    public boolean isMatch(String s, String p) { return isMatch(s, 0, p, 0); }
    
    public boolean isMatch(String s, int si, String p, int pi) {
        if (si == s.length() && pi == p.length())   return true;
        if (si == s.length() || pi == p.length())   return false;
        
        if (p.charAt(pi) == '*') {
            // XXXXX optimization, one start and several star are the same
            while(pi+1 < p.length() && p.charAt(pi+1) == '*') pi++;
            
            for(int i=si; i<=s.length(); i++) {
                if (isMatch(s, i, p, pi+1))     return true;
            }
            return false;
        } else if (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si)) {
            return isMatch(s, si+1, p, pi+1);
        } else return false;
    }
}*/

/**
 * Iterative Method. Every Smart Method
 * Example:
 *  s: abcdjabcdjabcdj
 *  p: a*dj*dj
 * 
 * if p[i] == s[j] or p[i] == '?' i++; j++
 * if p[i] == * i++, try to match i ... p.length to s[j]... s[j+1]... 
 * in the example, dj will match with the first dj, then * again, the second dj in p will match with the last dj in s.
 * 
 * There are several things need to be highlighted here:
 * 1). multiple * in the pattern: only the right most works
 * 2). if * is the last char in the pattern, then s matches p
 * 3). if j reaches the end of s, but i does not reach the end of p; 
 *      set j to the new start will not match either (not enough character)
 * 4). if having multiple stars like(*dj*) in the example, 
 *      the second * can reset the previous star loops on j
 */
/*public class Solution {
    public boolean isMatch(String s, String p) {
        // i points to p, j points to s
        // pstart: char after * in pattern; snext: the loop start when found a * in the pattern
        
        int i = 0, j = 0, pstart = -1, snext = -1;   
        
        while(j<s.length()) {
            if (i == p.length() && snext >=0 && snext < s.length()) {
                i = pstart; j = snext; snext++; }
            else if (i == p.length())    return false;
            
            if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) { i++; j++; }
            else if (p.charAt(i) == '*') {
                //while (i+1 < p.length() && p.charAt(i+1) == '*') i++;  // the rightmost *
                if (i+1 == p.length())  return true;
                pstart = ++i; snext = j; } 
            else if (snext >= 0 && snext < s.length()) {
                i = pstart; j = snext; snext++; }
            else    return false;
        }
        
        while (i < p.length() && p.charAt(i) == '*') i++;  // the rightmost *
        return i == p.length();
        
    }
}*/

/**
 * More Concise Logic
 */ 
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, pstart = -1, snext = -1;
        while(j<s.length()) {
            if (i<p.length() && (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?')) { i++; j++; }
            else if (i<p.length() && p.charAt(i) == '*') {
                pstart = ++i; snext = j; }
            else if (snext >= 0) {
                j = snext++; i = pstart;
            }
            else return false;
        }
        
        // pattern has strings left
        while(i<p.length() && p.charAt(i) == '*') i++;
        return i == p.length() ;
    }
}
