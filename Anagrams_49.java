/**
 * Anagrams: a word or phrase formed by rearranging the letters of another, such as cinema , formed from iceman.
 * 
 * This problem looks very simple, however, it is very tricky here
 * There are two problems here:
 * 1). How to decide two strings are anagrams &
 * 2). How to pick up the groups in the string arrays
 * 
 * CC150 1.3 & 11.2
 * 
 * 1). How to decide two strings are anagrams? (order does not matter, no sequential)
 *      1. -- sorting two strings, and compare whether they are exactly the same O(mlogm) time 
 *         -- where m is the average number of characters
 *      2. -- HashMap for each string, <char, count>
 *            O(m) time O(set) extra space, where set is the size of charset!
 * 
 * -- when length of string is not large, using sorting is good enough
 * -- when size of the charset is nog large, using hashset is good enough
 * 
 * 2). How to pick up the groups in the string arrays?
 *      1. -- two two compare (n^2), n is the number of input strings
 *      2. -- sorting       (nlongn), anagrams are equal to each other
 *              sorting the string, sorting strings?
 *      3. -- Maping        same anagrams are mapped to same group (HashMap?)
 *              sorting the string, mapping strings?
 *      4. When using a hashmap in the first step, how to do sorting and mapping (grouping)
 */

/**
 * 1). sorting + 2). HashMap Grouping
 */ 
public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for(String s : strs) {
            
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            //String key = cs.toString();     XXXXXXXX  this will return key as cs's mem address!!!!
            String key = new String(cs);
            
            if (map.containsKey(key))
                map.get(key).add(s);
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        
        
        for(List<String> list : map.values()) {
            if (list.size() > 1) {
                for (String s : list)
                    res.add(s);
            }
        }
        
        return res;
    }
}
