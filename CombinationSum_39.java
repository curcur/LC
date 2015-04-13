/**
 * ----------------------------------------------------------------------------
   Combination Sum
    - Given a set of candidate numbers (C) and a target number (T), 
      find all unique combinations in C where the candidate numbers sums to T.

    - The same number may be repeatedly chosen from C unlimited number of times.

   Note:
    - All numbers (including target) will be positive integers.
    - Elements in a combination (a1, a2, … , ak) must be in 
      non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    - The solution set must not contain duplicate combinations.
    
    - For example, given candidate set 2,3,6,7 and target 7, 
      A solution set is: [7] [2, 2, 3] 
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 40 Combination Sum II
 *          78 Subsets
 */

/**
 * Any number of combinations sum up to a target:
 * - Requirements: a number can be chosen any times & no duplication
 * - BFS (like 78 subsets) needs to store many intermediate results
 * - Use DFS with pruning instead
 * - Steps: sorting - easy for pruning
 *          the first number has candidates, 2, 3, 6, 7
 *          the second number has candidates >= the first number... 2, 3, 6, 7
 */

public class Solution {
    List<List<Integer>> reslists = new ArrayList<>();  // the results
    int[] cand;  // the sorted input number
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)  return reslists;
        cand = candidates;   
	Arrays.sort(cand);
        
	Stack<Integer> path = new Stack<>();
        combinationSum(0, path, target);
        return reslists;
    }
    
    private void combinationSum(int start, Stack<Integer> path, int target) {
        for(int i=start; i<cand.length; i++) {
            if (target == cand[i]) {
                List list = (List)(path.clone()); 
                list.add(target);
                reslists.add(list);
                return;   // cand[i] > target will be pruned
            } else if (target > cand[i]) {
                path.push(cand[i]);
                //combinationSum(i+1, path, target - cand[i]);
                combinationSum(i, path, target - cand[i]);
                path.pop(); 
                // I thought input has duplicates, use this in II
                // while(i<cand.length && cand[i] == cand[i-1]) i++;    
	    } else return; // cand[i] > target will be pruned
        }
    }
}
