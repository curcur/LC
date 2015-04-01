/**
 * Questions to ask
 * - should ask what is a valid number
 * - space, negative, scientific number (E notation) 
 *   with many heading zeros, sign be allowed or not
 * 
 * - AeB represents A * 10 ^ B
 * - A can be decimal (.35, 00. are all valid, but . is not)
 * - B must be integers, but can with signs
 * - there must be both A & B if e exists
 * 
 * Steps
 * - skip heading & trailing white spaces
 * - When having point, at least with one digit after it
 * - Work like a DFA (Deterministic Finite automaton)
 * - status - 0, empty status
 *          - 1, signed +/-
 *          - 2, started number
 *          - 3, have point
 *          - 4, have e
 *          - 6, signed +/- after e
 *          - 5, number after e
 */

public class Solution {
    public boolean isNumber(String s) {
        int r = s.length()-1, l = 0;
        int status = 0;
        
        // heading & tailing white spaces
        for(;l<=r && s.charAt(l) == ' '; l++)  ;
        for(;l<=r && s.charAt(r) == ' '; r--)  ;     // XXXX must have ';'
    
        for(int i=l; i<=r; i++) {
            char c = s.charAt(i);
            // start of the number
            if (status == 0 && (c == '+' || c == '-'))
                status = 1; 
            
            // only number
            else if ((status == 0 || status == 1) && (c >= '0' && c <= '9'))
                status = 2;
            
            // have point, do not allow single '.'
            else if ((status == 0 || status == 1 || status == 2) && c == '.') {
                // no number start, then should followed with number
                if ((status == 0 || status == 1) && 
                    (i+1 > r || s.charAt(i+1) < '0' || s.charAt(i+1) > '9'))
                    return false;
                status = 3;
            }
            
            // have e
            else if ((status == 2 || status == 3) && c == 'e') {
                if (i+1 > r)     // AeB A&B can not be empty
                    return false;
                status = 4;
            }
            
            else if (status == 4 && (c == '+' || c == '-'))
                status = 6;
                
            else if ((status == 4 || status == 6) && (c >= '0' && c <= '9'))
                status = 5;
                
            else if (c < '0' || c > '9')
                return false;
        }
        
        return status > 1 && status < 6;
    }
}
