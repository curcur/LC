/**
 * ----------------------------------------------------------------------------
   Two Sum III - Data structure design
    - Design and implement a TwoSum class. 
    - It should support the following operations: add and find.
      
      add - Add the number to an internal data structure.
      find - Find if there exists any pair of numbers which sum is equal 
	     to the value.

   For example:
    add(1); add(3); add(5);
    find(4) -> true
    find(7) -> false
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 1   Two Sum
 *          167 Two Sum II - Input array is sorted 
 */

/**
 * - There are several different ways of designing, depending on 
 *   the requirement of operations, and also the space requirements.
 *
 * - 1. If we wanna the $find$ operation fast, 
 *      - the fastest way is using a hash table to store all pairs of sum
 *      - the space is O(n^2), find time is O(1), and add time is O(n), 
 *        because for each input element, we need to
 *        calculate the sum for each element already exists. 
 * 
 * - 2. If we wanna $add$ to be quick, 
 *      - we can use unsorted array, linkedlist, or hashmap
 *      - space is O(n), add time is O(1), find time is O(n)
 *      - for unsorted array/linkedlist, we need an additional hashmap for 
 *        find
 *
 * - 3. Or we can use a sorted array
 *      - no additional space is needed except for storing the array/linkedlist
 *      - add is O(logn), find is O(n)
 *      - space is O(n), no other extra space
 *      - However, add into sorted array may cause moving elements in the array
 *      - No binary search possible for linkedlist
 * 
 * - 4. Other things we may consider can be Extensiblity & Scalability 
 *      - Other common operations like delete, search for a value
 *      - what if the size of numbers becomes very large
 */

public class TwoSum {
    
    // input integer -> the count of the integer
    HashMap<Integer, Integer> hmap = new HashMap<>();
    
    public void add(int number) {
	if (!hmap.containsKey(number)) 
	    hmap.put(number, 0);
	hmap.put(number, hmap.get(number)+1);
    }
    
    public boolean find(int value) {
	for (Integer itg : hmap.keySet()) {
	    int remain = value - itg;
	    if (hmap.containsKey(remain)) {
		int remainCount = hmap.get(remain);
		if (remain!=itg || remainCount>=2)   
		    return true;
	    } 
	}
	return false;
    }
}
