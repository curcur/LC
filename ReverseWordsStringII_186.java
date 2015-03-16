public class Solution {
    public void reverseWords(char[] s) {
        
        // 1. reverse the whole thing
        subReverse(s, 0, s.length);
        
        // 2. reverse each word
        int p = 0, q = 0;      // start /end of a word        
        for (;q<s.length; q++) {
            if (s[q] == ' ') {  // end of a word
                subReverse(s, p, q);
                p = q+1;
            }
        }
        
        // for the last word
        subReverse(s, p, q);
    }
    
    
    // follow usual way [...)
    public void subReverse(char[] s, int start, int end) {
        char temp;
        int i = start, j = end - 1;
        while(i < j) {
            temp = s[i]; s[i] = s[j]; s[j] = temp;
            i++; j--;
        }
    }
}
