/**
 * can n be negative? yes!
 */
/*public class Solution {
    public double pow(double x, int n) {
        if (n == 0)     return 1;
        if (n == 1)     return x;
        
        // XXXXXXXX overflow problem
        if (n<0)    return n == Integer.MIN_VALUE ? 1/(pow(x, -1*(n+1)) * x) : 1/pow(x, -1*n); 

        double t = pow(x, n/2);
        if (n%2 == 0) return t*t;
        else return t*t*x;
    }
}*/

/**
 * More Concise Writen
 * -1 % 2 = -1
 * 1 % 2 = 1
 * 0 % 2 = 0
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
