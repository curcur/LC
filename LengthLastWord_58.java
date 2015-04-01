/**
 * - start from the end of the string
 * - skip the tailing spaces
 * - break when meeting with the first space after starting counting
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for(int i=s.length()-1; i>=0; i--) {
	    // skip the tailing spaces
            if (length == 0 && s.charAt(i) == ' ') continue; 

	    // stop when meeting with first space after counting
            if (s.charAt(i) == ' ') break;  

            length++;
        }
        return length;
    }
}
