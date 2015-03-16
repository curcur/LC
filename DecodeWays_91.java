/**
 * A typical DP
 * F[i] = the number of ways to decode string s(0..i)
 *      = F[i-1]  '1-9'?  + F[i-2] '10 - 26'?
 * This can not have overlaps, because the ending character can not be the same
 */ 
public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)    return 0;     // XXXXX   s is empty!
        char[] schar = s.toCharArray();
        if (valid(schar[0]) == 0)     return 0;
        
        int prev0 = 1, prev1 = 1;
        
        for(int i=1; i<schar.length; i++) {
            int temp = prev1 * valid(schar[i]) + prev0 * valid(schar[i-1], schar[i]);
            prev0 = prev1;
            prev1 = temp;
        }
        
        return prev1;
        
    }
    
    private int valid(char c) { return c >= '1' && c <= '9'? 1 : 0; }
    private int valid(char c1, char c2) {  
        return (c1 == '1' && c2 >= '0' && c2 <= '9') ||
               (c1 == '2' && c2 >= '0' && c2 <= '6') ? 1 : 0;
    }
        
}
