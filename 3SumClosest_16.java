/**
 * ----------------------------------------------------------------------------
   3Sum Closest
    - Given an array S of n integers, find three integers in S such that 
      the sum is closest to a given number, target. 
    - Return the sum of the three integers. 
    - You may assume that each input would have exactly one solution.

   For example, given array S = {-1 2 1 -4}, and target = 1.

   The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * ----------------------------------------------------------------------------
 */

/**
 * This is exactly the same as 3Sum, except looking for closet instead
 */ 

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // assume num.length > 3
        Arrays.sort(num);
	int res = 0;

	// length <= 3
        for(int i=0; i<num.length && i<3; i++)
            res += num[i];
        
        for(int k=0; k<num.length; k++) {
            int i=k+1, j=num.length-1;
	    // the same number can not be used multiple times, so i<j
	    while(i<j) {    
		int distance = target - num[k] - num[i] - num[j];
                if (distance == 0)  return target;  
		// XXXX I originally return dist XXXX
                
                res = Math.abs(distance) < Math.abs(target-res) ? 
		    target-distance : res;
                
		if (distance > 0)   i++;
                else                j--;
            }
        }
        return res;
    }
}
