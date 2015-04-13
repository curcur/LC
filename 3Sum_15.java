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
        List<Integer> list;
        
        for(int i=0; i<num.length;) {
            int l = i+1, r = num.length-1;
            int target = 0 - num[i];
            
            while(l < r) {
                if (num[l] + num[r] == target) {
		    list = new ArrayList<>
			(Arrays.asList(num[i], num[l], num[r]));  // XXXX asList
                    lists.add(list);
                    r--; l++;
                    while(l < r && num[l] == num[l-1]) l++;  // for unique
                    while(l < r && num[r] == num[r+1]) r--;
                } else if (num[l] + num[r] > target) { r--; 
                } else { l++; }
            }
            i++;
            while(i<num.length && num[i] ==  num[i-1])  i++;
        }
        return lists;
    }
}
