/**
 * ----------------------------------------------------------------------------
   Count and Say 
    - The count-and-say sequence is the sequence of integers beginning 
      as follows:  
      1, 11, 21, 1211, 111221, ...

      - 1 is read off as "one 1" or 11.
      - 11 is read off as "two 1s" or 21.
      - 21 is read off as "one 2, then one 1" or 1211.
    - Given an integer n, generate the nth sequence starting from 1.

    - Note: The sequence of integers will be represented as a string.
 * ----------------------------------------------------------------------------
 */

/**
 * Recursion
 */

public class Solution {
    public String countAndSay(int n) {
        if (n == 1)     return "1";
        String prev = countAndSay(n-1);
        
        int count = 1; char cc = prev.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<prev.length(); i++) {
            if (prev.charAt(i) != cc) {
                sb.append(Integer.toString(count));
                sb.append(cc);
                count = 1;
                cc = prev.charAt(i);
            } else {
                count++;
            }
        }
        sb.append(Integer.toString(count));
        sb.append(cc);
        return sb.toString();
        
    }
}

/**
 * Follow up: Does it have a count greater than 9?
 * - The count actally can not equal or greater than 4
 * 
 * - 4 comes from either 1111, 2222 or 3333
 * - 1111 comes from 11 11 (1 11 1 is not possible) 
 *                   comes from 1 1  which should be 21 instead of 11 11
 * - 2222 comes from 22 22 (2 22 2 is not possible) 
 *                   comes from 22 22 which is the same
 * - 3333 comes from 33 33 
 *                   comes from 333 333 
 *                   comes from ... longer length.
 * - Hence, there is no way to generate a first 4.
 */ 
