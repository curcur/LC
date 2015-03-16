/**
 * 1. brute force, find each substring & search it, O(n^2) to form substring & O(n) to find number of char for each substring
 *  Hence O(n^3) in total
 * 
 * 2. But this is not what we wanna of course, we wanna try just in one pas search.
 *  The current pointer & The next pointer: where to start if next char failed the current substring
 * 
 * 3. Sliding window i,j;  next: the other symbol, other than (next start position if failing: next)
 *    The first way does not need the charset because s.charAt(next) is what you want.
 */
 

public class Solution {
    
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        //boolean[] charset = new boolean[256];
        //Arrays.fill(charset, false);
        
        if (s.length() <= 1) return s.length();
        //charset[s.charAt(0)] = true;
        
        // [i,j], next: the other symbol
        int i = 0, j = 1, next = -1, maxlength = 1;
        
        // initialization
        //while(j<s.length() && s.charAt(j) == s.charAt(0) ) { j++; }
        //if (j == s.length())  return s.length();
        //charset[s.charAt(j)] = true; next = j++;
        
        for (; j<s.length(); j++) {
            
            if (s.charAt(j) != s.charAt(j-1))  {
            
                // different from the previous one, or the other one
                if (next > -1  && s.charAt(j) != s.charAt(next))   { 
                    maxlength = Math.max(j-i, maxlength);
                    // reset the charset
                    //charset[s.charAt(next-1)] = false;   //////// $$$$$$ Do not need charset at all, using next-1 is enough
                    //charset[s.charAt(j)] = true;
                    
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


/***
 * Extented to at most K distint chars. 
 * i->
 * j->
 * 
 **/
 
/*public class Solution {
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
}*/
