/**
 * ----------------------------------------------------------------------------
   Two Sum
    - Given an array of integers, find two numbers such that they add up to 
      a specific target number.

    - The function twoSum should return indices of the two numbers such that 
      they add up to the target, where index1 must be less than index2. 
    - Please note that your returned answers (both index1 and index2) 
      are not zero-based.
    - You may assume that each input would have exactly one solution.

   Input: numbers={2, 7, 11, 15}, target=9
   Output: index1=1, index2=2
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 167 Two Sum II - Input array is sorted 
 *          170 Two Sum III - Data structure design 
 *          15  3Sum
 *          16  3Sum Closest
 *          18  4Sum
 * Tags: Array, Two Pointers, HashMap
 */

/**
 * 1. HashMap 
 * - value -> index
 * - two passes: Establish the hashmap
                 For each element v in the array, search for target-v in hashmap
 * - O(n) time
 * - O(n) space
 * 
 * - XXXX HashMap can hold only one value. What if they have duplicates?
 * - XXXX What if the input array has one/two [3], but the target is [6]?
 * 
 * - See Two Sum II for: sorting & no extra spaced needed
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
	int[] res = new int[2];
	HashMap<Integer, Integer> hmap = new HashMap<>();
        
	// build up the hashmap
	for (int i=0; i<numbers.length; i++) {
	    if (hmap.containsKey(numbers[i])) {
		// XXXX duplicates
		int prevIndex = hmap.get(numbers[i]);
		if (numbers[i] * 2 == target) {
                    res[0] = prevIndex+1;
                    res[1] = i+1;
		    return res;
                } 
	    }	    
            hmap.put(numbers[i], i);
	}
        
	// find target-numbers[i] in the hashmap
        for (int i=0; i<numbers.length; i++) {
            int remain = target - numbers[i];
	    // no single value used twice
            if (remain!=numbers[i] && hmap.containsKey(remain)) {
		res[0] = i+1;
                res[1] = hmap.get(remain)+1;
                break;
            }
        }
        return res;
    }
}
