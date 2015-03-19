Two Sum II - Input array is sorted
    - Given an array of integers that is already sorted in ascending order
    - Find two numbers such that they add up to a specific target number.

    - The function twoSum should return indices of the two numbers such that 
      they add up to the target, where index1 must be less than index2. 
    - Please note that your returned answers (both index1 and index2) are 
      not zero-based.
    - You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

/**
 * Related: 1 Two Sum
 */				  

/**
 * 1. Binary Search
 * - Binary search target-value for each value in the array
 * - O(nlogn) time
 * - O(1) space
 **/
 
public class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i=0; i<numbers.length; i++) {
            int remain = target - numbers[i];
            
            if (remain < numbers[i]) break;
            
            int index = binarySearch(numbers, remain, i+1);
            
            if (index != -1) {  // find the remain
                res[0] = i+1;
                res[1] = index+1;
                break;
            }
        }
        
        return res;             // XXXX missing this first time
    }
    
    public int binarySearch(int[] numbers, int target, int start) {
        int left = start, right = numbers.length-1;
	while(left <= right) {
            int mid = (left + right)/2;
	    if (numbers[mid] == target)     return mid;
	    if (numbers[mid] > target)      right = mid-1;
            else left = mid+1;
        }
	return -1;
    }
}


//------------------------------------------------------------------------------

/**  
 * 2. Begin & End pointers (for sorted array)
 * - Two pointers left -> ; right <-
 * - if numbers[left] + numbers[right] > target, right--
 *   else if numbers[left] + numbers[right] < target, left++
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        
        while (left < right) {
            
            int sum = numbers[left] + numbers[right];
	    if (sum == target) { return new int[] {left+1, right+1};  // XXXX
            }else if (sum > target) { right--; 
            }else { left++; }
        }
        
        throw new IllegalArgumentException("Not Found Valid Pairs!"); // XXXX
    }
}
