/**
 * 1. ASCII code? (256) character? digit? uppercase, lowercase? unicode?
 * 2. In fact, we do not need to remove the footprint, the valid footprint would always bigger than p
 **/
public class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        
        int[] hashchar = new int[256];  // the position of last char
        Arrays.fill(hashchar, -1);
        
        int maxlength = 0, p = 0, i = 0;
        
        for (; i<s.length(); i++) {
            // if (hashchar[s.charAt(i)] < 0) { hashchar[s.charAt(i)] = i; }   // first time 
            if (hashchar[s.charAt(i)] < p) { hashchar[s.charAt(i)] = i; }       // no need to remove the foot printer
            else {
                // the same char visited before
                if (i - p > maxlength) maxlength = i-p;
                
                // remove the footprint, no need
                // for(int j=p; j<hashchar[s.charAt(i)]; j++)  hashchar[s.charAt(j)] = -1;
                
                p = hashchar[s.charAt(i)] + 1;
                hashchar[s.charAt(i)] = i;
            }
        }
        
        // the last one
        if (i-p > maxlength)    maxlength = i-p;
        
        return maxlength;
    }
}