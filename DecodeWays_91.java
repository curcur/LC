Decode Ways
    - A message containing letters from A-Z is being encoded to numbers 
      using the following mapping:
    - 'A' -> 1
      'B' -> 2
      ...
      'Z' -> 26
    - Given an encoded message containing digits, 
      determine the total number of ways to decode it.

For example,
- Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
- The number of ways decoding "12" is 2.

/**
 * DP
 * - F[i] = the number of ways to decode string s(0..i)
 *        = F[i-1] * '1'-'9'?  + F[i-2] * '10' - '26'?
 * - Do have overlaps, since the ending characters are not the same
 * - Only need to store F[i-2] & F[i-1]
 */ 

public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)    return 0;     // XXXXX   s is empty!
        char[] schar = s.toCharArray();
        if (valid(schar[0]) == 0)     return 0;
        
        int prev0 = 1, prev1 = 1;
        
        for(int i=1; i<schar.length; i++) {
            int temp = prev1 * valid(schar[i]) 
		+ prev0 * valid(schar[i-1], schar[i]);
            prev0 = prev1;
            prev1 = temp;
        }
	return prev1;
    }
    
    // '1' -- '9'
    private int valid(char c) { return c >= '1' && c <= '9'? 1 : 0; }
    private int valid(char c1, char c2) {  // '10' - '26'
        return (c1 == '1' && c2 >= '0' && c2 <= '9') ||
               (c1 == '2' && c2 >= '0' && c2 <= '6') ? 1 : 0;
    }
        
}
