public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0)   return lists;
        
        List<Integer> list0 = new ArrayList<>(Arrays.asList(1));
        lists.add(list0);
        
        for(int i=1; i<numRows; i++) {
            list0 = lists.get(i-1);
            List<Integer> list = new ArrayList<>(Arrays.asList(1));
            lists.add(list);
            
            for(int j=1; j<list0.size(); j++) {
                list.add(list0.get(j-1) + list0.get(j));
            }
            
            list.add(1);
        }
        
        return lists;
        
        
    }
}
