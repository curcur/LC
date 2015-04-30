/**
 * - Get the least significant integer every time, add to the new integer
 * - shift the original number right & shift the new number left;
 * - The following is the most straightforward way
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int newn = 0;
        // while(n!=0) { XXXX
        for(int i=0; i<32; i++) {
            newn = (newn << 1) + (n & 1);
            n >>>= 1;
        }
        return newn;
    }
}

/**
 * Follow up: If called many times
 * - We can use concepts like "cache"
 * - Also we remember "reverse a entire string" == 
 *      reverse partial strings + reverse each internal partial string
 * - 2^8 = 256
 */
public class Solution {
    // you need treat n as an unsigned value
    private static Map<Integer, Integer> cache = new HashMap<>();
    
    public int reverseBits(int n) {
        int newn = 0;
        for(int i=0; i<4; i++) {
            int tmp = n & 0xFF;
            if(!cache.containsKey(tmp))
                reverse8Bits(tmp);
            newn = (newn << 8) + cache.get(tmp);
            n >>>= 8;
        }
        return newn;
    }
    
    private void reverse8Bits(int n) {
        int tmp = n, newn = 0;
        for(int i=0; i<8; i++) {
            newn = (newn << 1) + (tmp & 1);
            tmp >>>= 1;
        }
        cache.put(n, newn);
    }
}
