/**
 * ----------------------------------------------------------------------------
   Maximum Subarray
    - Find the contiguous subarray within an array (containing at least one 
      number) which has the largest sum.

   For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
    - the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * ----------------------------------------------------------------------------
 *

/**
 * Related: 152	Maximum Product Subarray
 */

/**
 * Keywords: Contiguous
 * - The contiguous may suggest a two pointer solution
 * - However it does not need to return the windows, only the sum
 * - F[i] : the maximum subarray sum ending with i (must inlucde A[i])
 * - sum: the maximal sum till A[i] (not necessary include A[i])
 * - Time Compleixty: O(n) & Space O(1)
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
