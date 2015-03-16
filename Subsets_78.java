
/**
 * Notice Distinct Integers!
 * S[0] = {}
 * S[1] = {1}
 * S[2] = {2}{1,2}
 * S[3] = {3},{1,3},{2,3},{1,2,3}
 * ....
 * S[k] = all subset ending with k
 */
 
/**
 * My original thinking is very complicated, with S[k] = all subsets with length k
 */
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);         // XXXXX It does not say S is in sorted order!!
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list);
    
        for(int i=0; i<S.length; i++) {    // level
            int length = lists.size();
            // for(List<Integer> l : lists) {   XXXXXX This will have modify exception
            for(int j=0; j<length; j++) {
                list = new ArrayList<>(lists.get(j));
                list.add(S[i]);
                lists.add(list);
            }
        }
        return lists;
    }
}


/**
 * The other way for this is bit manipulation, but complexity is the same as this!
 */
