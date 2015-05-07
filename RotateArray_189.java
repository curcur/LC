/**
 * ----------------------------------------------------------------------------
   Rotate Array
    - Rotate an array of n elements to the right by k steps.

   For example
    - with n = 7 and k = 3, 
      the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

   Note:
    - Try to come up as many solutions as you can, 
    - there are at least 3 different ways to solve this problem.

   Hint:
    - Could you do it in-place with O(1) extra space?
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 186 Reverse Words in a String II
 *          61  Rotate List
 * Tags: Palindrome, Integer
 */

/**
 * - Method 1
 *   - Shift the array to right one position each time, 
 *   - O(nk) time, and O(1) space
 *
 * - Method 2
 *   - Initialize another array length = k
 *   - Copy the ori[length-k, length-1] to dest[0, k-1]; 
 *   - Copy ori[0, length-k-1] to ori[k, length-1]
 *   - Copy dest[0, k-1] back to ori[0, k-1]
 *   - O(n+k) time, and O(k) space
 *
 * - Method 3 Reverse twice
 * - what if k >= length ?
 */

public class Solution {
    public void rotate(int[] nums, int k) {
	int length = nums.length;
	k %= length;            // XXXX what if k>n?
        
        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);  // XXXXXX k-1
        reverse(nums, k, length-1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left]; 
	    nums[left] = nums[right]; 
	    nums[right] = temp;
            left++; right--;
        }
        
    }
}
