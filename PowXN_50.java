/**
 * ----------------------------------------------------------------------------
   Pow(x, n) 
    - Implement pow(x, n)
 * ----------------------------------------------------------------------------
 */
/**
 * Related: 69 Sqrt(x)
 */

/**
 * 1. Treat n alwasy as positive
 * - Can n be negative? Yes!
 * - Careful of overflow if n = Integer.MIN_VALUE
 * - |Integer.MIN_VALUE| = |Integer.MAX_VALUE| + 1
 */

public class Solution {
    public double pow(double x, int n) {
        if (n == 0)     return 1;
        if (n == 1)     return x;
        
        // XXXXXXXX overflow problem
        if (n<0)    
	    return n == Integer.MIN_VALUE ? 
		1/(pow(x, -1*(n+1)) * x) : 1/pow(x, -1*n); 

        double t = pow(x, n/2);
        if (n%2 == 0) return t*t;
        else return t*t*x;
    }
}


//------------------------------------------------------------------------------

/**
 * Treat n positive/negative 
 * - -1 % 2 = -1
 * - 1 % 2 = 1
 * - 0 % 2 = 0
 */
public class Solution {
    public double pow(double x, int n) {
        if (n==0)   return 1;
        
        double t = pow(x, n/2);
        if (n%2 == 0)    return t*t;
        else if (n%2 == 1)  return t*t*x;
        else return t*t/x;
    }
}
