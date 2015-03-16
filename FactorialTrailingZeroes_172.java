/**
 * 0 comes from 5*2, 2 is much more than 5, so we need to worry about 5
 * 25 has one more 5, 125...
 */
public class Solution {
    public int trailingZeroes(int n) {
        int factor = 5, count = 0;
        
        while(factor <= n) {
            count += n/factor; 
            if (factor <= Integer.MAX_VALUE/5)  // XXXXX n is very large!
                factor *= 5;
            else break;
        }
        return count;
    }
}
