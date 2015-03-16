/***
 * negative's divide and mod
 * -344 % 10 = -4
 * -344 / 10 = -34 
 **/
public class Solution {
    
    public int reverse(int x) {
        
        int reverse = 0;
        while (x!= 0) {
            int mod = x % 10;
            x = x / 10;
            
            // check overflow
            if (reverse > Integer.MAX_VALUE / 10 || 
            (reverse == Integer.MAX_VALUE / 10 && mod > Integer.MAX_VALUE % 10)) return 0;   // positive
            if (reverse < Integer.MIN_VALUE / 10 || 
            (reverse == Integer.MIN_VALUE / 10 && mod < Integer.MIN_VALUE % 10)) return 0;   // negative
            reverse = reverse * 10 + mod;
        }
        return reverse;
    }
}
