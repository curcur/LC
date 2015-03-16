/**
 * Permutations Vs Subsets ?
 * 
 * -- Use a DFS, every position can choose 1, 2, 3
 */
/*public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] num) {
        if (num.length == 0)    return res;
        LinkedHashSet<Integer> path = new LinkedHashSet<>();
        permute(num, path, num.length-1);
        return res;
    }
    
    private void permute(int[] num, LinkedHashSet<Integer> path, int level) {
        for(int i=0; i<num.length; i++) {
            if (!path.contains(num[i]))   {  
                path.add(num[i]);
                
                if (level == 0) {
                    List<Integer> list = new LinkedList<>(path);
                    res.add(list);
                } else {
                    permute(num, path, level-1);
                }
                
                path.remove(num[i]);
            }
        }
        
    }
}*/

/**
 * Another way of thinking permutation [1,2,3]: swap positions 
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] num) {
        permute(num, 0);
        return res;
    }
    
    private void permute(int[] num, int begin) {
        if (begin == num.length-1)  {
            List<Integer> list = new ArrayList<>(num.length);
            for(int i: num) list.add(i);
            res.add(list);
            return;
        }
        
        for(int i=begin; i<num.length; i++) {
            swap(num, begin, i);
            permute(num, begin+1);
            swap(num, begin, i);
        }
    }
    
    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
