Longest Substring with At Most Two Distinct Characters
    - Given a string, find the length of the longest substring T,
      that contains at most 2 distinct characters.
    - For example, Given s = "eceba", T is "ece" which its length is 3.

/**
 * 1. Brute force
 * - Find each substring & check whether it has only two distinct characters
 * - O(n^2) to form substring & O(n) to find number of distinct characters
 * -  Hence O(n^3) in total
 * 
 * 2. Sliding Window
 * - Longest substring, consider sliding window
 * - One important thing in sliding window method: 
 *     How to slide lp (the left pointer)
 * - Define np (next pointer): 
 *     Where to start lp if a new character fails the current substring
 * - Do not need charset[] because s(np) & s(lp) represent all charsets
 */
 
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 1) return s.length();
                
        // [i,j], next: the other symbol
        int i = 0, j = 1, next = -1, maxlength = 1;
        
	for (; j<s.length(); j++) {
	    if (s.charAt(j) != s.charAt(j-1))  {
		// different from the previous one, or the other one
                if (next > -1  && s.charAt(j) != s.charAt(next))   { 
                    maxlength = Math.max(j-i, maxlength);
		    i = next+1; 
                }
                next = j-1;
            }
        }
        
        // the last one
        maxlength = Math.max(j-i, maxlength);
        return maxlength;
    }
}


//------------------------------------------------------------------------------

/***
 * 3. Extend to at most K distinct characters. 
 * - Use charset[] to determine how to slide the window
 * - int[] charset store the number of times a char appears
 **/
 
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        final int K = 2;
	int[] charset = new int[256];
        Arrays.fill(charset, 0);
        
        int keylength = 0, i = 0, j = 0, maxlength = 0;
	
	for (;j<s.length(); j++) {
            
            if(keylength < K || charset[s.charAt(j)] != 0) {
                if (charset[s.charAt(j)] == 0) keylength++;
                charset[s.charAt(j)]++; 
                continue;
            }
            
            // keylength == K && charset[s.charAt(j)] == 0 // new key
            maxlength = Math.max(j-i, maxlength);
            while (keylength >= K) { 
                charset[s.charAt(i)]--; 
                if (charset[s.charAt(i++)] == 0)  keylength--;
            }
            charset[s.charAt(j)]++; keylength++;    // for the new j
        }
        
        // the last one
        maxlength = Math.max(j-i, maxlength);
        return maxlength;
    }
}
