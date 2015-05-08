/**
 * ----------------------------------------------------------------------------
   Maximum Product Subarray
    - Find the contiguous subarray within an array (containing at least one 
     number) which has the largest product.

   For example, given the array [2,3,-2,4],
    - the contiguous subarray [2,3] has the largest product = 6.
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 53 Maximum Subarray
 * Tags: Dynamic Programming, Two Pointers
 */

/**
 * Keywords: Product
 * - Similar to the Maximum SUM Subarray
 * - However, the min product can also come back to maximum in multiplication
 * - So we need to maintain two states: imax & imin
 *   imax -- the maximum value till i (must include A[i])
 *   imin -- the minimum value till i (must include A[i])
 * - the imax and imin will be reset to 0 if (A[i] == 0) 
 */

public class Solution {
    public int maxProduct(int[] A) {
        int product = A[0], imin = A[0], imax = A[0];
        for(int i=1; i<A.length; i++) {
            int tempmin = imin * A[i], tempmax =  imax * A[i];
            // XXXXXXX Should also include A[i] itself 
	    // in case (previous imin or imax == 0)
            imin = Math.min(tempmin, tempmax); imin = Math.min(imin, A[i]); 
            imax = Math.max(tempmin, tempmax); imax = Math.max(imax, A[i]);
            
            product = Math.max(imax, product);
        }
        return product;
    }
}
