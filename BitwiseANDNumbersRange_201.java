/**
 * - Very Tricky
 * - The simplest way is AND one by one from m to n
 * - But this definitely not what is desired because
 * - a bit would be set to 0 if any number has 0 on that bit
 * 
 * - if m's most significant bit is ith
 * - if n >= 2^(i+1), then the result is 0,
 * - else ith bit of the result is 1
 * - remove that bit and we can continue this process until m = 0;
 * - we will at most do it O(32^2)
 */
xpublic class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0)     return 0;
        int s = m, l = n, i = -1;
        // find the most significant bit's position
        while(s > 0) {
            s >>= 1; l >>= 1; i++;
        }
        if (l > 0)  return 0;
        
        s = m & (1 << i) - 1;
        l = n & (1 << i) - 1;
        return (1 << i) + rangeBitwiseAnd(s, l);
    }
}

/**
 * More brilliant
 * - if n > m, two numbers, odd & even, so the last bit -> 0
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int zerobits = 1;
        while(n > m) {
            if (m == 0)
                return 0;
                
            n >>= 1;
            m >>= 1;
            zerobits <<= 1;
        }
        return m * zerobits;
    }
}
