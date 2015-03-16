/**
 * 1. The most naive way is to 1). get all combinations of L m!
 *                             2). find all substring in S that equals to any of the combinations in 1)
 * 
 * It says same length, how can we make use of this?
 * 2. L -> HashTable, hash to find whether s's substring in L
 * 
 * Further: 4. Sliding window, similar to the facebook screen interview
 *  Three Situation:
 *      -- Does not contain word
 *      -- reach the number of times contained
 *      -- does not reach the number of times contained
 */ 
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> lists = new ArrayList<>();
        if (L.length == 0) return lists;
        
        int wlen = L[0].length(), slen = S.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : L) 
            if(map.containsKey(s)) map.put(s, map.get(s)+1); else map.put(s, 1);
        
        for(int i=0; i<wlen; i++) {
            HashMap<String, Integer> cmap = (HashMap)(map.clone());
            int l = i, r = i;
            while(r+wlen <= slen) {
                String s0 = S.substring(r, r+wlen);
                int dec = decrease(cmap, s0);
                if (dec == -1) {    // L does not contain that word at all
                    while(l<r) {    // restore the map
                        String s1 = S.substring(l, l+wlen);
                        cmap.put(s1, cmap.get(s1)+1);    
                        l += wlen;
                    }
                    r += wlen; l = r; continue;
                } else if (dec == 0) {   // the key count has already reached
                    while(l<r) {
                        String s1 = S.substring(l, l+wlen);
                        l += wlen;
                        if (s1.equals(s0))   break;
                        else cmap.put(s1, cmap.get(s1)+1);
                    }
                    r += wlen; continue;
                } else {                // decrease by 1
                    if (satisfy(cmap)) {
                        lists.add(l);
                        String s1 = S.substring(l, l+wlen);
                        cmap.put(s1, cmap.get(s1)+1);     //  XXXXX+1 not -1
                        l += wlen;
                    }
                    r += wlen;
                }
            }
        }
        return lists;
    }
    
    private int decrease(HashMap<String, Integer> map, String s) {
        if (!map.containsKey(s))   return -1;  // does not contain the key
        if (map.get(s) == 0)    return 0;   // the key count is reached
        else {  map.put(s, map.get(s)-1);   // decrease the requirement by 1;
                return 1; }
    }
    
    private boolean satisfy(HashMap<String, Integer> map) {
        for (Integer i: map.values()) {
            if (i > 0)  return false;
        }
        return true;
    }
}
