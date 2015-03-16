/**
 * Similar to the Maximum Sum Subarray
 * However, the min product can also come back to maximum if multiply 
 */
public class Solution {
    public int maxProduct(int[] A) {
        int product = A[0], imin = A[0], imax = A[0];
        for(int i=1; i<A.length; i++) {
            int tempmin = imin * A[i], tempmax =  imax * A[i];
            // XXXXXXX Should also include itself in case imin/imax = 0
            imin = Math.min(tempmin, tempmax); imin = Math.min(imin, A[i]); 
            imax = Math.max(tempmin, tempmax); imax = Math.max(imax, A[i]);
            
            product = Math.max(imax, product);
        }
        return product;
    }
}
