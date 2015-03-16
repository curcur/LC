/**
 * 1.   Similar to the previous one, but do not need to store everything this time.
 *      Most straightforward implementation
 */
/*public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list0 = new ArrayList<>(Arrays.asList(1));
        
        for(int i=1; i<=rowIndex; i++) {
            List<Integer> list1 = new ArrayList<>(Arrays.asList(1));
            for(int j=1; j<list0.size(); j++)
                list1.add(list0.get(j-1) + list0.get(j));
            list1.add(1);
            list0 = list1;
        }
        
        return list0;
        
    }
}*/

/**
 * 2.   O(k) extra space
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1));
        
        for(int i=1; i<=rowIndex; i++) {
            for(int j=1; j<list.size(); j++) 
                list.set(j-1, list.get(j-1) + list.get(j));
            list.add(0, 1);
        }
        return list;
        
    }
}

/**
 * more effient code can start from the end 
 * or use a real linkedlist
 */
