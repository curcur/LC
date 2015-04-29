/**
 * - It is equivalent to say 
 *   translate a decimal number to a number using 26 as base
 * - what if the input is 0
 * 
 * - 1 -> A
 * - 2 -> B
 * - ...
 * - 26-> Z
 * - 27-> AA
 * 
 * But the normal base start with 0
 */

public class Solution {
    public String convertToTitle(int n) {
                
        final int BASE = 26;
        StringBuilder sb = new StringBuilder();
        
        while(n>0) {
            n--;    // XXXX 1->26 A->Z
            sb.insert(0, (char)(n%BASE+'A'));
            n /= BASE;
        }
        return sb.toString();
    }
}
