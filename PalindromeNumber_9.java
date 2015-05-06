/**
 * ----------------------------------------------------------------------------
   Palindrome Number
    - Determine whether an integer is a palindrome. 
    - Do this without extra space.
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 125 Valid Palindrome
 *          7   Reverse Integer
 * Tags: Palindrome, Integer
 */

/**
 * - Questions to ask: what if the number is negative?
 * - Compare from start & end each time 
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)  return false;
        
        int div = 1;
	// XXXX Originally I wrote x/div !=0, this will cause div to overflow
        while (x / div >= 10) {  div *= 10; }   
	
        // XXXX div should >"=" 10 
        while (div >= 10) {     
            if (x / div != x % 10)  return false;
            x = ( x % div ) / 10;
            div /= 100;
        }
        return true;
    }
}


/**
 * Other Thoughts:
 * - We can reverse an integer to see whether they are equal
 * - if reversing an integer causes overflow, then it is not a palindrome
 */
