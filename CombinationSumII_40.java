/**
 * ----------------------------------------------------------------------------
   Combination Sum II
    - Given a collection of candidate numbers (C) and a target number (T), 
      find all unique combinations in C where the candidate numbers sums to T.

    - Each number in C may only be used once in the combination.

Note:
    - All numbers (including target) will be positive integers.
    - Elements in a combination (a1, a2, … , ak) must be in 
      non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    - The solution set must not contain duplicate combinations.

    - For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
      A solution set is: 
      [1, 7] 
      [1, 2, 5] 
      [2, 6] 
      [1, 1, 6] 
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 39 Combination Sum 
 */

/**
 * Any number of combinations sum up to a target:
 * - Requirements: a number can be chosen only once & no duplication
 * - Having duplicates in input
 * - Use DFS with pruning instead
 */
public class Solution {
    List<List<Integer>> reslists = new ArrayList<>();  // the results
    int[] cand;  // the sorted input number
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if (num.length == 0)  return reslists;
        cand = num;   
	Arrays.sort(cand);
        
	Stack<Integer> path = new Stack<>();
        combinationSum(0, path, target);
        return reslists;
    }
    
    private void combinationSum(int start, Stack<Integer> path, int target) {
	for(int i=start; i<cand.length;) {
            if (target == cand[i]) {
                List list = (List)(path.clone()); 
                list.add(target);
                reslists.add(list);
                return;  // cand[i] > target will be pruned
            } else if (target > cand[i]) {
                path.push(cand[i]);
                combinationSum(i+1, path, target - cand[i]);
                //combinationSum(i, path, target - cand[i]);
                path.pop(); i++;
		while(i<cand.length && cand[i] == cand[i-1]) i++;    
            } else return;  // cand[i] > target will be pruned
        }
    }
}
