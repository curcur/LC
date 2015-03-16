public class Solution {
    List<List<Integer>> reslists = new ArrayList<>();
    int[] cand;
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if (num.length == 0)  return reslists;
        cand = num;   Arrays.sort(cand);
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
                combinationSum(i+1, path, target - cand[i]);
                //combinationSum(i, path, target - cand[i]);
                path.pop(); i++;
		while(i<cand.length && cand[i] == cand[i-1]) i++;    
            } else return;
        }
    }
}
