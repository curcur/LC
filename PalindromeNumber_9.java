/**
 * 1. We can reverse an integer to see whether they are equal, if reverse an integer cause it overflow, then it is not a palindrome
 * 2. Compare from start & end, but first you need to find the 
 */
public class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0)  return false;
        
        int div = 1;
        while (x / div >= 10) {  div *= 10; }   // XXXXXXXX Originally I wrote x/div !=0, this will cause div to overflow
        
        while (div >= 10) {     /// XXXXXXX div should >"=" 10  XXXXXXX
            if (x / div != x % 10)  return false;
            x = ( x % div ) / 10;
            div /= 100;
        }
        
        return true;
    }
}
