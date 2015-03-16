/**
 * - the sequence is 1, 11... starting from 1
 * - At the beginning, I thought it was n, 1n.......
 * 
 * We can do it iteratively also.
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
 * The follow up question is whether there is a count greater than 9?
 * 
 * - the count actally can not equal or greater than 4
 * 4 comes from either 1111, 2222 or 3333
 * 1111 comes from 11 11 (1 11 1 is not possible) comes from 1 1  which should be 21 instead of 11 11
 * 2222 comes from 22 22 (2 22 2 is not possible) comes from 22 22 which is the same
 * 3333 comes from 33 33 comes from 333 333 comes from .... longer length, no way from shorter length
 */ 
