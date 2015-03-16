/**
 * This is the question I screen interviewed by FB
 * 
 * 1. First, this is a sequential window, so using a sliding window probably will be better
 *      l, r pointer
 *      -- move r pointer right till find the substring contains all T
 *      -- move l pointer right till not a substring contains all T (l, r is the current min)
 *      -- move r again
 * 2. How to check whether a substring(window) in S that contains all chars in T
 *      Of course you can check for each substring in S whether contains T, but this is very slow
 *      We can use a hashmap to represent T, target map
 *                 a hashmap tp represent substring, map
 * 3. If the target map does not have duplicates, we can use HashSet instead of HashMap
 *      Remove the char from the hashset if S[l] == char, 
 *      Add char back if S[r] == char && map.char.count == 0
 *      the substring (l, r) contains all char in T if the hashset is emtpy
 */

/** the cover method is O(m), which makes the entire implementation is O(n*m)
 *  quote from the best answer!
 */
/*public class Solution {
    public String minWindow(String S, String T) {
        if (T.length() == 0 || S.length() == 0) return "";
        
        int l = 0, r = 0, minr = S.length(), minl = -1; // XXXXXXXXXXXXX  minl = S.length(), minr = -1;
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        
        for(int i=0; i<T.length(); i++)
            add2Map(tmap, T.charAt(i));
        
        for(; r<S.length(); r++) {
            char rc = S.charAt(r);
            if (!tmap.containsKey(rc))   continue; 
            add2Map(smap, rc);
            if (!cover(smap, tmap))     continue;
            
            // find the substring, move the left pointer forward
            for(;l<=r; l++) {
                char lc = S.charAt(l);
                delMap(smap, lc);
                if (!cover(smap, tmap)) break;
            }
            
           // if (r-l+1 < minl - minr)
           //    minr = r; minl = l-1;
           
            if (r-l < minr - minl) {
                minr = r; minl = l;
            }
            l++;
        }
      
        return minl < 0 ? "" : S.substring(minl, minr+1);
    }
    
    private void add2Map(HashMap<Character, Integer> map, char c) {
        if (map.containsKey(c))
            map.put(c, map.get(c) + 1);
        else
            map.put(c, 1);
    }
    
    private void delMap(HashMap<Character, Integer> map, char c) {
        if (map.containsKey(c))    map.put(c, map.get(c)-1);
    }
    
    private boolean cover(HashMap<Character, Integer> smap, HashMap<Character, Integer> tmap) {
        for (Character c : tmap.keySet()) {
            if (!smap.containsKey(c) || smap.get(c) < tmap.get(c))  return false;
        }
        return true;
    }
}*/

/**
 * use a count to record whether T is satisfied
 */
public class Solution {
    public String minWindow(String S, String T) {
        if (T.length() == 0 || S.length() == 0) return "";
        int l = 0, r = 0, minr = S.length(), minl = -1; // XXXXXXXXXXXXX  minl = S.length(), minr = -1;
        
        HashMap<Character, Integer> tmap = new HashMap<>();
        int count = T.length();
        
        for(int i=0; i<count; i++)
            add2Map(tmap, T.charAt(i));
        
        for(;r<S.length(); r++) {
            char rc = S.charAt(r);
            if (tmap.containsKey(rc)) {
                int cc = tmap.get(rc);
                if (cc > 0) count--;
                tmap.put(rc, cc-1);
            }
            if (count > 0)  continue;
            
            // find the substring, move l forward
            for(; l<=r; l++) {
                char lc = S.charAt(l);
                if (tmap.containsKey(lc)) {
                    int cc = tmap.get(lc);
                    if (cc >= 0) count++;
                    tmap.put(lc, cc+1);
                }
                if (count > 0)  break;
            }
            
            if (r-l < minr - minl) {
                //r = minr; l = minl;    XXXXXXX
                minr = r; minl = l;
            }
            l++;
        }
        
        return minl < 0 ? "" : S.substring(minl, minr+1);
    }
    
    private void add2Map(HashMap<Character, Integer> map, char c) {
        if (map.containsKey(c))
            map.put(c, map.get(c) + 1);
        else
            map.put(c, 1);
    }
}

/**
 * If there is no duplicates in T, we can use the similar count way
 */
