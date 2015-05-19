/**
 * 1. DFS 
 */
 
public class Solution {
    
    String[] LETTERS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", 
			"tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    String digits;
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        this.digits = digits;
        StringBuilder path = new StringBuilder();
        letterCombinations(0, path);
        
        return res;
    }
    
    private void letterCombinations(int level, StringBuilder path) {
	if (level == digits.length()) {
	    res.add(path.toString());
            return;
	}
        
	String temp = LETTERS[digits.charAt(level) - '2'];
	int length = temp.length();
	for(int i=0; i<length; i++) {
            path.append(temp.charAt(i));            // add it
            letterCombinations(level+1, path);	    
            path.deleteCharAt(path.length()-1);     // and pop it
        }
    }
}

/**
 * 2. Iterative, this method needs to store many more intermediate results
 * - Kind of like a BFS
 */

public class Solution {
    String[] LETTERS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", 
			"tuv", "wxyz"};
   
    public List<String> letterCombinations(String digits) {
	/// res.add("");    XXXXXXX
        LinkedList<String> res = new LinkedList<>();   
        if (digits == null || digits.length() == 0)   return res;
        
        res.add("");
        
        /// $$$$, we can have a new list also, here we keep it in just one list
        for(int i=0; i<digits.length(); i++) {
            String letters = LETTERS[digits.charAt(i) - '2'];
            int length = res.size();
            while(length-- != 0) {
		String leftsub = res.poll();
                for(int j=0; j<letters.length(); j++) {
                    res.add(leftsub + letters.charAt(j));
                }
            }
        }
        return res;
    }
}
