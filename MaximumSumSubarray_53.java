/**
 * This problem is very tricky
 * F[i] : the maximum subarray that includes i
 * sum is the maximal one
 */
public class Solution {
    public int maxSubArray(int[] A) {
        int sum = A[0], isum = A[0]; // F[i]
        for(int i=1; i<A.length; i++) {
            isum = Math.max(A[i], isum + A[i]);
            sum = Math.max(sum, isum);
        }
        return sum;    
    }
}
