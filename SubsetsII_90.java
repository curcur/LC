/**
 * Use the same way as in Subset
 * S[0] = {}
 * S[1] = {1}
 * 
 * S[2] = {2}, {1,2}
 * S[2] = {2,2}, {1,2,2}
 * S[2] = {2,2,2}, {1,2,2,2}
 * 
 * if having mulitple i, only need to add muiltiple i at the end of the previous ith subset
 */
 
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);           // XXXXXXXX this is the second time I forget to sort
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();  lists.add(list);
        
        if (num.length == 0)    return lists;
        
        list = new ArrayList<>(Arrays.asList(num[0])); lists.add(list); 
        int prevstart = 1;
        
        for(int i=1; i<num.length; i++) {
            int length = lists.size();
            for(int j = (num[i] == num[i-1]) ? prevstart : 0; j<length; j++) {
                list = new ArrayList<>(lists.get(j));
                list.add(num[i]);
                lists.add(list);
            }
            prevstart = length;
        }
        
        return lists;
    }
}
