/**
 * DP
 * F[i] = s[0...i] can be segmented
 */

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0)    return false;
        
        boolean[] F = new boolean[s.length()];
        for(int i=0; i<s.length(); i++) {
            if (dict.contains(s.substring(0, i+1))) {
                F[i] = true; continue;
            }
            
            for(int j=0; j<i; j++)
                if (F[j] && dict.contains(s.substring(j+1, i+1))) {
                    F[i] = true;
                    break;
                }
        }
        return F[s.length()-1];
    }
}
