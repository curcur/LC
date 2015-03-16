/**
 * 1. test from 1....x
 * 
 * 2. Binary Search
 *  - Problem of overflow?
 */ 
/*public class Solution {
    public int sqrt(int x) {
        if (x == 0) return x;
        
        int l = 1, r = x, mid;
        
        while(l < r) {
            mid = (l+r)/2;
            int res = sqrt(x, mid);
            if (res == 0)   return mid;
            else if (res > 0)   l = mid + 1;
            else r = mid - 1;
        }
        
        return l;
    }
    
    /**
     * sq * sq may overflow!
     * 
     * - x >= sq * sq           => x / sq >= sq  &&
     * - x < (sq+1) * (sq+1)    => x < sq^2 + 2sq + 1   => x <= sq^2 + 2sq 
     * => x <= sq * (sq+2)      => x /sq <= sq+2
     * 
     *    sq+2 >= x / sq >= sq 
     *
    private int sqrt(int x, int sq) {
        double res = x * 1.0 / sq;
        if (res < sq)   return -1;
        else if (res > sq+2)    return 1;
        else return 0;
    }
}*/

/**
 * 3. More Consice Solution
 */
/*public class Solution {
    public int sqrt(int x) {
        if (x == 0) return x;
        
        int l = 1, r = x, mid = (l+r)/2, ans = mid; 
        
        while(l <= r) {             // $$$$$$$$ <=
            mid = (l+r)/2;
            
            if (x / mid >= mid)  {
                l = mid + 1;
                ans = mid;
            } else r = mid - 1;
        }
        
        return ans;
    }
}*/

/**
 * Newton's Method
 */
public class Solution {
    public int sqrt(int x) {
        //if (x == 0) return 0;
        double ans = Math.random();
    
        while (true) {
            double temp = (ans + x/ans) / 2;
            if (Math.abs(temp-ans) < 0.01)  return (int)temp;
            else ans = temp;
        }
    }
}
