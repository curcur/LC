Sqrt(x) 
    - Implement int sqrt(int x).
    - Compute and return the square root of x.

/**
 * Related: 50 Pow(x, n)
 */

/**
 * 1. Binary Search
 * - mid*mid may overflow  => use x/mid instead
 * - The largest less or equal to 
 */ 

public class Solution {
    public int sqrt(int x) {
        if (x == 0) return x;
        
        int l = 1, r = x, ans = -1; 
        
        while(l <= r) {             // $$$$$$$$ <=
            int mid = (l+r)/2;
            
            if (mid <= x/mid)  {
                l = mid + 1;
                ans = mid;
            } else r = mid - 1;
        }
        
        return ans;
    }
}


//------------------------------------------------------------------------------

/**
 * Newton's Method
 * ans = (ans + x/ans)/2
 */
public class Solution {
    public int sqrt(int x) {
	
	double ans = Math.random();
    
        while (true) {
            double temp = (ans + x/ans) / 2;
            if (Math.abs(temp-ans) < 0.01)  return (int)temp;
            else ans = temp;
        }
    }
}
