/**
 * Isomorphic (tong gou),
 * - use a hashmap
 * - check every character in s & t
 * - if not exist the mapping, construct the mapping
 * - if exist the mapping, check whether t has the same char mapped
 * 
 * - XXXX no two chars may map to the same character
 * - XXXX this kind of one-to-one map must DOUBLE CHECK
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        if (length != t.length())   return false;
        Map<Character, Character> map = new HashMap<>();
        
        for(int i=0; i<length; i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if(!map.containsKey(cs)) {
                if (!map.containsValue(ct)) // XXXX
                    map.put(cs, ct);
                else
                    return false;
            }
            else if (map.get(cs) != ct)
                return false;
        }
        return true;
    }
}
