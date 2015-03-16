/**
 * 1) Sorting
 * 2) does not require sequential, hence no sliding window
 * 3) arbituary numbers, no hash or left-right pointers
 * 
 * -- It's like subsets 78, having constraints
 * list[i] = combinations ended with candidates[i] that smaller than target
 * 
 * -- can have arbitrary repeated numbers
 * -- can not be duplicated
 * ==>so repeat from beginning of intermediate list if not a repeated number
 *       repeat from previous of intermediate list if it is a repeated number
 * 
 * XXXXXXXXXXXXXXX   Time Limit Exceeded  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * This is actually not equal to the subset problem since a number can be repeatedly used.
 */
 
/*public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> reslists = new ArrayList<>();
        if (candidates.length == 0) return reslists;
        
        Arrays.sort(candidates);
        List<Comb> interlists = new ArrayList<>();
        Comb comb = new Comb(0);   interlists.add(comb);
        comb = new Comb(candidates[0]); comb.comblist.add(candidates[0]); interlists.add(comb);
        int prev = 1;
        
        for(int i=1; i<candidates.length; i++) {
            if (candidates[i] > target || candidates[i] + candidates[0] > target) break;
            int j = (candidates[i] == candidates[i-1]) ? prev : 0;
            int length = interlists.size(); prev = length;
            for(; j<length; j++) {
                comb = new Comb(interlists.get(j));
                if (comb.sum + candidates[i] <= target) comb.append(candidates[i]);
                if (comb.sum == target) reslists.add(comb.comblist);
                else if (comb.sum < target) interlists.add(comb);
            }
        }
        return reslists;
    }
    
    private class Comb {
        List<Integer> comblist;
        int sum;
        
        Comb(Comb comb) {
            this.comblist = new ArrayList<>(comb.comblist);
            this.sum = comb.sum;
        }
        
        Comb(int sum) {
            this.comblist = new ArrayList<>();
            this.sum = sum;
        }
        
        void append(int n) {
            this.comblist.add(n);
            sum += n;
        }
    }
}*/

/**
 * The above is kind of a level first traversal
 * this may work when getting all subsets, but needs to store everything,
 * in the case where n is large, but do not need to find all subsets, DFS might be better
 */
 
/**
 * two ways of DFS
 * 1st way DFS: the first number has candidates 2,3,6,7, second 3,6,7...
 * 2nd way DFS: -- 2 can be chosen or not, -- 3 can be chosen or not.... (XXXXX not possible because a number can be chosen unlimited times)
 */
public class Solution {
    List<List<Integer>> reslists = new ArrayList<>();
    int[] cand;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)  return reslists;
        cand = candidates;   Arrays.sort(cand);
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
                return;
            } else if (target > cand[i]) {
                path.push(cand[i]);
                //combinationSum(i+1, path, target - cand[i]);
                combinationSum(i, path, target - cand[i]);
                path.pop(); i++;
                // I thought they have duplicates in input
                // while(i<cand.length && cand[i] == cand[i-1]) i++;    
                //  XXXXXXX use this in follow up
            } else return;
        }
    }
}
