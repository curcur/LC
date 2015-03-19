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

/**
 * Related: 167 Two Sum II - Input array is sorted 
 *          170 Two Sum III - Data structure design 
 *          15  3Sum
 *          16  3Sum Closest
 *          18  4Sum
 */

/**
 * 1. HashMap 
 * - value -> index
 * - two passes: Establish the hashmap
                 For each value v in the array, search for target-v in hashmap
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
	    Integer previndex = hmap.get(Integer.valueOf(numbers[i]));
            if (previndex != null) {
                // XXXX duplicates
                if (numbers[i] * 2 == target) {
                    res[0] = previndex.intValue()+1;
                    res[1] = i+1;
                } 
            }
            hmap.put(Integer.valueOf(numbers[i]), Integer.valueOf(i));
            
        }
        
	// find target-numbers[i] in the hashmap
        for (int i=0; i<numbers.length; i++) {
            int remain = target - numbers[i];
            Integer index = hmap.get(Integer.valueOf(remain));
            if (remain != numbers[i] && index != null) {
                res[0] = i+1;
                res[1] = index.intValue()+1;
                break;
            }
        }
        return res;
        
    }
}
