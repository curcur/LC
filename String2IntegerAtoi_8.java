/**
 *  1. The follow solution do not allow first number to be 0, need 2 controls sign & start(first number)
 *  If the first number can be 0, then much easir, only needs one control sign.
 */

/*public class Solution {
    public int atoi(String str) {
        int MAXDIV10 = Integer.MAX_VALUE / 10;
        int number = 0;
        int sign = 0;           // after decide the sign of the number
        boolean start = false;  // after the first number
        
        for (int i=0; i<str.length(); i++) {
            
            // having other charaters after first number is decided
            if (start && (str.charAt(i) <'0' || str.charAt(i) > '9')) break;
            else if (start) { // check overflow
                if ((number > MAXDIV10)  || 
                    (number == MAXDIV10 && str.charAt(i) - '0' >= Integer.MAX_VALUE % 10)) return sign * Integer.MAX_VALUE;
                else { number = number * 10 + str.charAt(i) - '0'; continue; }
                
            }
            
            // before first number
            else if (sign != 0) {   // sign has already decided, but no first number, first number can not be 0
                if (str.charAt(i) > '0' && str.charAt(i) <= '9') { number = str.charAt(i) - '0'; start = true; continue; }
                else return 0;
            }
            
            // before sign been decided
            else {
                if (str.charAt(i) == '-')   { sign = -1; continue; }
                if (str.charAt(i) == '+')   { sign = 1;  continue; }
                if (str.charAt(i) == ' ')   { continue; }
                if (str.charAt(i) > '0' && str.charAt(i) <= '9') {      // $$$$$  can not start with 0  $$$$$$
                    number = str.charAt(i) - '0'; sign = 1; start = true; continue;
                }
                else return 0;
            }
        }
        
        return sign * number;
    }
    
}*/


/**
 * Allow the first number to be 0,
 * The +MAX_VALUE is 1 smaller than -MAX_VALUE; 
 */

public class Solution {
    public int atoi(String str) {
        int MAXDIV10 = Integer.MAX_VALUE / 10;
        int number = 0;
        int sign = 0;           // after decide the sign of the number
        
        for (int i=0; i<str.length(); i++) {
            
            // having other charaters after sign is decided
            if (sign != 0 && (str.charAt(i) <'0' || str.charAt(i) > '9')) break;
            else if (sign != 0) { // check overflow
                
                if ((number > MAXDIV10)  ||       // XXXXXXXXXXXX -max_value is 1 bigger than +max_value so here need to "+1"
                    (number == MAXDIV10 && str.charAt(i) - '0' >= Integer.MAX_VALUE % 10 + 1)) 
                    return (sign > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                else { number = number * 10 + str.charAt(i) - '0'; continue; }
                
            }
            
            // sign == 0, before sign been decided
            else {
                if (str.charAt(i) == '-')   { sign = -1; continue; }
                if (str.charAt(i) == '+')   { sign = 1;  continue; }
                if (str.charAt(i) == ' ')   { continue; }
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {      // $$$$$  can not start with 0  $$$$$$
                    number = str.charAt(i) - '0'; sign = 1; continue;
                }
                else return 0;
            }
        }
        
        return sign * number;
    }
}
