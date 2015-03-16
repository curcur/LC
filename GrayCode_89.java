/**
 *      0           n = 1
 *      1
 * ------------------------
 *    1 1           n = 2
 *    1 0
 * ------------------------
 *  1 1 0           n = 3
 *  1 1 1
 *  1 0 1
 *  1 0 0
 *   ...
 */

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0));
        if (n == 0) return list;
        
        list.add(1);
        for(int i=2; i<=n; i++) {
            int length = list.size();
            for(int j=length-1; j>=0; j--) 
                list.add(list.get(j) | (1 << (i-1)));       // XXXXXXX should be |
        }
        return list;
    }
}
