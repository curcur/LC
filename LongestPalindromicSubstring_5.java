/**
 * ----------------------------------------------------------------------------
   Longest Palindromic Substring
    - Given a string S, find the longest palindromic substring in S. 
    - You may assume that the maximum length of S is 1000, and there exists 
      one unique longest palindromic substring.
 * ----------------------------------------------------------------------------
 *

/**
 * Related: 53 Maximum Subarray
 * Tags: Palindrome, Substring, Dynamic Programming
 */

/**
 * Keywords: Palindromic Substring
 * - Normal way doing this: O(n^3), two loops + check for palindrome
 * - There are a lot of redudant work to check whether a substring is palindrome
 *
 * 1. Maintain a boolean array
 * - Palin[i][j] = palin[i+1][j-1] && s(i) == s(j)
 *   - whether a substring s(i,j+1) is a palindrome.
 * - We know that if a smaller substring is not palindrome, then it can not be 
 *   expanded to larger palindrome.
 * - O(n^2) time and space complexity
 */

public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length == 0) return "";
        int start = 0, end = 0;
        boolean[][] palin = new boolean[length][length];
        
        for(int i=length-1; i>=0; i--)
            for(int j=i; j<length; j++) {
                if(i==j)    
		    palin[i][j] = true;
                else if(j==i+1) 
                    palin[i][j] = s.charAt(i) == s.charAt(j);
                else
                    palin[i][j] = palin[i+1][j-1] && s.charAt(i) == s.charAt(j);
                
                if (palin[i][j] && j-i > end-start)  {
                    end = j; start = i;
                }  
            }
        return s.substring(start, end+1);
    }
}


//------------------------------------------------------------------------------

/**
 * 2. Expand from the mid: O(1) space
 * - Longer palindrome can be expanded from smaller palindromic substring
 * - n centers, and each center has two ways to expand: odd & even
 * - O(n^2) time and O(1) space 
 */ 
 
public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0)    return "";
        int start = 0, end = 0, j = 0;
        
        for(int i=0; i<length; i++) {
            // odd
            for(j=1; i-j>=0 && i+j<length; j++)
                if (s.charAt(i-j) != s.charAt(i+j)) break;
            if (2*--j > end-start) {
                end = i+j; start = i-j;
            }

            // even
            for(j=0; i-j>=0 && i+j+1<length; j++)
                if (s.charAt(i-j) != s.charAt(i+j+1)) break;
            if (2*--j+1 > end-start) {
                end = i+j+1; start = i-j;
            }
        }
        return s.substring(start, end+1);
    }
}

/**
 * Some other thoughts:
 * - 1. Two pointers does not work here because of palindrome.
 *   - Two pointers needs some way to shift the left pointer, 
 *   - However, in palindrome, small windows has no direct linear relationship 
 *     to larger window. You may need to back shift.
 */
