/**
 * ----------------------------------------------------------------------------
   Sort Colors
    - Given an array with n objects colored red, white or blue, 
      sort them so that objects of the same color are adjacent, 
      with the colors in the order red, white and blue.

    - Here, we will use the integers 0, 1, and 2 to represent the 
      color red, white, and blue respectively.

   Note:
    - You are not suppose to use the library's sort function for this problem.

   Follow up:
    - A rather straight forward solution is a two-pass algorithm using 
      counting sort.
    - First, iterate the array counting number of 0's, 1's, and 2's, 
      then overwrite array with total number of 0's, then 1's and followed 
      by 2's.

    - Could you come up with an one-pass algorithm using only constant space?
 * ----------------------------------------------------------------------------
 */

/**
 * - The most naive way is sorting O(nlogn) or counting O(n) but two passes
 * - this is just three thing sorting, so the key point is to find the 
 *   two boundaries, l & r: 
 *    - all 0s before l, all 2s aftre r, all 1s between l & r
 */

public class Solution {
    public void sortColors(int[] A) {
        int l = 0, r = A.length-1, index = l;
        
        while(index <= r) {
	    if (A[index] == 2) { 
		swap(A, index, r); 
		r--; 
	    } else if (A[index] == 1) { 
		index++; 
	    } else {
		swap(A, l, index); 
		l++; index++; 
	    }
	}
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i]; A[i] = A[j]; A[j] = temp;
    }
            
        
}
