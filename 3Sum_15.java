/**
 * ----------------------------------------------------------------------------
   3Sum
    - Given an array S of n integers, are there elements a, b, c in S such that
      a + b + c = 0? 
    - Find all unique triplets in the array which gives the sum of zero.

    Note:
    - Elements in a triplet (a,b,c) must be in non-descending order. 
      (ie, a ≤ b ≤ c)
    - The solution set must not contain duplicate triplets. 
      
    For example, given array S = {-1 0 1 2 -1 -4},
    A solution set is: (-1, 0, 1)  (-1, -1, 2)
    
    Follow ups:
     - what if we wanna all pairs (including duplicates)?
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 1   Two Sum
 *          167 Two Sum II - Input array is sorted 
 */

/**
 * - Sort the array O(nlogn)
 * - Use two pointers (start->, <-end) as in two Sum  O(n^2)
 * - Time O(n^2), no extra space
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
	List<List<Integer>> lists = new ArrayList<>();
        int length = num.length;

	for(int i=0; i<length;) {
            int l = i+1, r = length-1;
            int target = 0 - num[i];
            
            while(l < r) {
                if (num[l] + num[r] == target) {
		    // XXXX asList
		    lists.add(Arrays.asList(num[i], num[l], num[r]));
		    l++; r--;
		    // $$$$ for unique
		    while(l<r && num[l] == num[l-1]) l++;  
                    while(l<r && num[r] == num[r+1]) r--;
                } else if (num[l] + num[r] > target) { r--; 
                } else { l++; }
            }
            i++;
	    // $$$$ for unique
            while(i<length && num[i]==num[i-1])  i++;
        }
        return lists;
    }
}


//------------------------------------------------------------------------------

/**
 * Follow ups: duplicates are allows, all tripplets
 *  - in the inner loop (two pointer), we will remeber a prev l pointer, 
 *  - for each element num[l] == num[l-1], and match the target sum,
 *  - we will loop throught these same elements,
 *  - reset it to prev after finishing
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
	int length = num.length;
	List<List<Integer>> res = new ArrayList<>();
	if (num == null || length == 0)
	    return res;

	Arrays.sort(num);
	for(int i=0; i<length; i++) {
	    int target = 0 - num[i];
	    int l = i+1, r = length-1;
	    while(l<r) {   // XXXX forget this first time
		if(num[l] + num[r] > target) r--;
		else if(num[l] + num[r] < target) l++;
		else {  // == target
		    int prevl = l;
		    while(l<r && num[l]+num[r] == target) {
			res.add(Arrays.asList(num[i], num[l], num[r]));
			l++;
		    }
		    r--; l = prevl;
		}
	    }
	}
	
	return res;
    }
}
