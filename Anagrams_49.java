Anagrams
    - Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

/**
 * Related: CC150 1.3 & 11.2
 */

/**
 * Anagrams: a word or phrase formed by rearranging the letters of another, 
 *           such as cinema, formed from iceman.
 * 
 * This problem looks very simple, however, it is very tricky here
 * There are two problems here:
 * - 1. How to decide two strings are anagrams &
 * - 2. How to group the anagrams
 * 
 * 1. How to decide two strings are anagrams? 
 * - 1). sorting two strings, and compare whether they are exactly the same 
 *       - O(mlogm) time, where m is the average number of characters
 * - 2). HashMap for each string, <char, count>
 *       - O(m) time & O(set) extra space, where set is the size of charset!
 * 
 * - when length of each string is not large, using sorting is good enough
 * - when size of the charset is not large, using hashmap is good enough
 * 
 * 2. How to group the anagrams?
 * - 1). two two compare O(n^2), where n is the number of input strings
 * - 2). Sorting O(nlongn), anagrams are equal to each other
 *       - sorting sorted strings
 * - 3). Maping: same anagrams are mapped to same group 
 *       - grouping sorted strings
 *
 * - When using a hashmap in the first step, how to do grouping?
 */

/**
 * 1. sorting + 2. HashMap Grouping
 */ 

public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for(String s : strs) {
            
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            
	    //XXXX  this will return key as cs's mem address!!!!
	    //String key = cs.toString();     
	    
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
