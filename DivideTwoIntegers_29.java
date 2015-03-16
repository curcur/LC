/**
 * This is my first way doing it: too slow, what if divisor is 1
 *
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor  == 0)  return Integer.MAX_VALUE;
        int D = (dividend < 0) ? 0 - dividend : dividend;
        int d = (divisor < 0) ? 0 - divisor : divisor;
        
        int q = 0;
        while(D >= d) { q++; D -= d; }
        
        return (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ?
            q : 0-q;
    }
}*/

/**
 * So what about Olog(n) instead of O(n) 
 * 
 * Java does not have unsigned types!!!
 */

public class Solution {
    public int divide(int dividend, int divisor) {
        // long D = (dividend < 0) ? 0 - dividend : dividend;   XXXXXXXXX this will overflow!!!
        // long d = (divisor < 0)  ? 0 - divisor  : divisor;
        long D = dividend, d = divisor;
        D = (D < 0) ? 0 - D : D;
        d = (d < 0) ? 0 - d : d;
        
        long p = 0, d1 = d, exp = 1;
        while(D >= d) {
            // increase d1
            while(D >= d1) {
//                D -= d1; p += exp; exp += d1; d1 <<= 1; 
                D -= d1; p += exp; exp <<= 1; d1 <<= 1;   // XXXXXXXX exp's increase !!!
            }
            // decrease d1
            if (d1 > d) {
                d1 >>= 1; exp >>= 1;
                if (D >= d1) { D -= d1; p += exp; }
            }
        }
        
        p = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? p : 0-p;
        
        // XXXXXXXXXXXX   Overflow Problem!!!!!
        if (p > Integer.MAX_VALUE || p < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        else return (int) p;
    }
}
