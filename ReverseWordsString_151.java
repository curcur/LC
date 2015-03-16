
/**
 * Of course, we can use String.split to easily do this, but I guess this will not be allowed.
 * 
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * String is immutable, use StringBuilder vs StringBuffer (Synchronized)!!! 
 */
 

public class Solution {
    public String reverseWords(String s) {
	        StringBuilder reverse = new StringBuilder();
	        StringBuilder word = new StringBuilder();
	        
	        for(int i=0; i<s.length(); i++) {
	            if (s.charAt(i) != ' ') { word.append(s.charAt(i)); }
	            else if (word.length() != 0) {
	                if (reverse.length() == 0)  { reverse.append(word); }
	                else { reverse.insert(0, ' '); reverse.insert(0, word); }
	                word.setLength(0);
	            }
	        }
	        
	        if (word.length() != 0) {                                           // XXXX  Last word does not have a space after
	        	if (reverse.length() == 0)  { reverse.append(word); }           // XXXX  First word
                else { reverse.insert(0, ' '); reverse.insert(0, word); }       
	        }
	        
	        return reverse.toString();
	    }
}
