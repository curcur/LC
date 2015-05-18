/**
 * 1. Similar to 3Sum O(n^3)
 * -- the hard part is how to avoid duplicates:
 *   if (i>0 && num[i] == num[i-1]) continue;  // avoid duplicates  
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        
        for(int i=0; i<num.length; i++) {
            if (i>0 && num[i] == num[i-1]) continue;  // avoid duplicates
            for(int j=i+1; j<num.length; j++) {
                if(j>i+1 && num[j] == num[j-1]) continue;  // avoid duplicates
                int l = j+1, r = num.length-1;
                while(l<r) {
                    int sum = num[i]+num[j]+num[l]+num[r];
                    if (sum == target) {
                        res.add(Arrays.asList(num[i], num[j], num[l], num[r]));
                        l++; r--;
                        while(l<r && num[l] == num[l-1]) l++;   // avoid duplicates
                        while(l<r && num[r] == num[r+1]) r--;
                    }else if (sum < target) l++;
                    else r--;
                }
            }
        }
        return res;
    }
}

/**
 * 2. O(n^2) + HashMap 
 * - sort the array & use a hashmap to store pair value
 * - originally, I was trying to build the hashmap & match with the hashmap at the same time
 *   However, it is very hard to avoid duplicates
 * - Build up the hashmap pair first, and then only match the first pair 
 *   duplicate value pair to
 *   the hashmap would be much eaiser.
 * 
 * - There are two sets of duplicates
 * - 1). avoid duplicated combination
 * - (1, 2, 3, 4) as a quadruplets
 *      (1, 2)  (1, 3)  (1, 4)
 *      (2, 3)------------|
 *      (2, 4)----|
 *         |----(3, 4)
 * - match the pair when sum=target & j < p.x
 * - XXXX 2). the input array have duplicate inputs
 *   [0, 1, 1, 1, 1, 2], target = 4
 *      [1, 1, 1, 1, 2]
 *  
 *   (0, 1) (0, 2)
 *   (1, 1) (1, 2)
 * - Only use the first pair of value to match the list in the hashmap
 *   then duplicated quadruplets will sit together!
 * 
 */

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Pair>> map = new HashMap<>();
        
        Arrays.sort(num);
        
        // pair(i, j) --- i<j
        for(int i=0; i<num.length; i++)
            for(int j=i+1; j<num.length; j++) {
                int sum = num[i]+num[j];
                if (!map.containsKey(sum))  map.put(sum, new ArrayList<Pair>());
                map.get(sum).add(new Pair(i, j));
            }
        
        for(int i=0; i<num.length; i++) {
            if(i>0 && num[i] == num[i-1])   continue;       // avoid duplicates
            for(int j=i+1; j<num.length; j++) {
                if(j>i+1 && num[j] == num[j-1]) continue;   // avoid duplicates
                
                int remain = target-num[i]-num[j];
                if (map.containsKey(remain)) 
                    for(Pair p : map.get(remain)) 
			// p(i,j) before pair p
                        if (j < p.x && !equalsPrev(res, num, i, j, p))   
                            res.add(Arrays.asList(num[i], num[j], 
						  num[p.x], num[p.y]));
            }
        }
        return res;
    }
    
    private boolean equalsPrev(List<List<Integer>> res, 
			       int[] num, int i, int j, Pair p) {
        if (res.size() == 0)    return false;
        
        List<Integer> list = res.get(res.size()-1);
        return list.get(0) == num[i] && list.get(1) == num[j]
	    && list.get(2) == num[p.x] && list.get(3) == num[p.y];
    }
    
    private class Pair {
        int x, y;    // index
        Pair(int x, int y) { this.x = x; this.y = y; }
    }
}
