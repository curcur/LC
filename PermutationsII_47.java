/**
 * Numbers in the collection may duplicate
 * 
 * -- so the previous LinkedHashSet does not work any more
 * -- We can use a HashMap<Integer, count> instead, but how to avoid duplicates?
 * -- Only consider elements in HashMap.keySet
 */
/*public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num.length == 0)        return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : num) {
            if (!map.containsKey(i))
                map.put(i, 1);
            else 
                map.put(i, map.get(i) + 1);
        }
        Stack<Integer> path = new Stack<>();
        permutation(map, path, 0, num.length);
        return res;
    }
    
    private void permutation(HashMap<Integer, Integer> map, Stack<Integer> path, 
                                int level, int length) {
        for(int i : map.keySet()) {
            int count = map.get(i);
            if (count != 0) {
                path.push(i);
                map.put(i, count - 1);
            
                if (level == length-1) {
                    List<Integer> list = new ArrayList<>(path);
                    res.add(list);
                } else {
                    permutation(map, path, level+1, length);
                }
                path.pop();
                map.put(i, map.get(i) +1);
            }
        }
    }
}*/

/**
 * The second way is swap, as in PermutationsI
 * The idea is that : 
 *          do not swap the same element in different positions
 *          because they will ended up with the same permutation
 * 
 * XXXXXXXXXXXXXX
 *          It is not enough
 *          2 2 1 1
 *          swap 2 with first 1   ->  1 (2 2 1)
 *               2 with second 1  ->  1 (2 1 2)  the permutations in the parenthesis are the same 
 */
/*public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num.length == 0)    return res;
        
        permutation(num, 0);
        return res;
    }
    
    private void permutation(int[] num, int begin) {
        if (begin == num.length-1) {
            List<Integer> list = new ArrayList<>(num.length);
            for(int i : num) list.add(i);
            res.add(list);
        }
        
        // XXXXXXXXXXXX
        ///for(int i=begin; i<num.length; i++) {
        //    if (num[begin] != num[i] || begin == i) {
        //        swap(num, begin, i);
        //       permutation(num, begin+1);
        //        swap(num, begin, i);
        //   }
        //}
        HashSet<Integer> set = new HashSet<>();
        for(int i=begin; i<num.length; i++) {
            if (!set.contains(num[i])) {
                set.add(num[i]);
                swap(num, begin, i);
                permutation(num, begin+1);
                swap(num, begin, i);
            }
        }
    }
    
    private void swap(int[] num, int i, int j) {
        int temp = num[i]; num[i] = num[j]; num[j] = temp;
    }
}*/

/**
 * Next Permutation: Similar to Problem31
 *  -- Find the next permutation from the smallest
 *  -- This will use no extra space, but more time consuming
 */
