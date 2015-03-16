/**
 * This is much simpler than Edit Distance, one parse is enough
 * Insert/Delete we can only consider 1
 * The other is modify
 */

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length())    return isOneEditDistance(t, s);
        if (t.length() - s.length() > 1) return false;
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (isSame(s, i+1, t, i+1)) return true;    // 1. modify
                if (isSame(s, i, t, i+1))   return true;    // 2. delete the long
                return false;
            }
        }
        
        if (s.length() == t.length())   return false;       // exactly the same
        else return true;
    }
    
    // from idx to the end
    public boolean isSame(String x, int xidx, String t, int tidx) {
        if (x.length() - xidx != t.length() - tidx) return false;
        for (int i=xidx, j=tidx; i<x.length() && j<t.length(); i++, j++) 
            if (x.charAt(i) != t.charAt(j)) return false;
        return true;
    }
}
