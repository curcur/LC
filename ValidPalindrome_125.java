/**
 * ----------------------------------------------------------------------------
   Valid Palindrome
    - Given a string, determine if it is a palindrome, 
      considering only alphanumeric characters and ignoring cases.

   For example,
    - "A man, a plan, a canal: Panama" is a palindrome.
    - "race a car" is not a palindrome.

   Note:
    - Have you consider that the string might be empty? 
      This is a good question to ask during an interview.
      We define empty string as valid palindrome.
 * ----------------------------------------------------------------------------
 *

/**
 * - Always ask corner cases, like whether an empty string is valid?
 */

public class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();     // $$$$ s.toCharArray()
        int l = 0, r = s.length()-1;
        
        while(l < r) {
            while (l < r && !Character.isLetterOrDigit(chars[l]))   l++;        
	    // $$$$ Character.isLetterOrDigit(c)
            while (l < r && !Character.isLetterOrDigit(chars[r]))   r--;

            if(l < r) {
                if (!match(chars[l], chars[r])) return false;
                l++; r--;  // XXXX Forget this first time write!
            }
        }
        
        return true;
    }
    
    // Test alphanumeric
    /*private boolean valid(char c) {
        return  (c >= '0' && c <= '9') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z')
    }*/
    
    private boolean match(char c1, char c2) {
        if (c1 >= '0' && c1 <= '9')     return c1 == c2;
        if (c1 >= 'A' && c1 <= 'Z')     
	    return c1 == c2 || c1 == c2 + 'A' - 'a';
        else    
	    return c1 == c2 || c1 == c2 + 'a' - 'A';
    }
}
