/** 
 * 1. the brute force is very straightforward
 * - O(mn)
 * - for(int i=0, j; i<haystack.length(); i++) will cause the length function to be called again & again
 *   will casue Time Limit Exceeded
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int haystacklength = haystack.length();   
        int needlelength = needle.length();
        
        if (needlelength == 0)    return 0;     // XXXX
        
        for(int i=0, j; i<haystacklength; i++) {
            for(j=0; j<needlelength && i+j < haystacklength
                && needle.charAt(j) == haystack.charAt(i+j); j++);
            if (j==needle.length()) return i;
        }
        return -1;
    }
}
