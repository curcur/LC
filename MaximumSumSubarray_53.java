/**
 * ----------------------------------------------------------------------------
   Maximum Subarray
    - Find the contiguous subarray within an array (containing at least one 
      number) which has the largest sum.

   For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
    - the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 152	Maximum Product Subarray
 * Tags: Dynamic Programming, Two Pointers
 */

/**
 * Keywords: Contiguous
 * - Normal way to do this is O(n^2), two loops
 * - F[i] : the maximum subarray sum ending with i (must inlucde A[i])
 * - sum: the maximal sum till A[i] (not necessary include A[i])
 * - Time Compleixty: O(n) and Space O(1) 
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

/**
 * Some other thoughts:
 * - 1. The hint asks for divide & conquer
 *   - divide the array half each time
 *   - the maximum sum comes from three ways:
 *     1). the left; 
 *     2). the right;
 *     3). sum across the mid O(n): 
 *         prefix in the left, and suffix in the right
 *     T(n) = T(n/2)*2 + O(n) => O(nlogn)
 *
 * - 2. Return Window Rather than the Sum
 *   - The ``contiguous'' suggests a two pointer solution
 *   - shift the current left pointer to i if (isum == A[i])
 */
