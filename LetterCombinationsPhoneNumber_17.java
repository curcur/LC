/**
 * 1. DFS 
 */
 
/*public class Solution {
    
    String[] LETTERS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
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
        String temp = LETTERS[digits.charAt(level) - '2'];
        if (level == digits.length()-1) {
            for(int i=0; i<temp.length(); i++)
                res.add(new String(path.toString() + temp.charAt(i)));
            return;
        }
        
        for(int i=0; i<temp.length(); i++) {
            path.append(temp.charAt(i));            // add it
            letterCombinations(level+1, path);
            path.deleteCharAt(path.length()-1);     // and pop it after finishing
        }
    }
}*/

/**
 * 2. BFS (Iterative), this method needs to store many more intermediate results
 */

public class Solution {
    String[] LETTERS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
   
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();   /// res.add("");    XXXXXXX
        if (digits == null || digits.length() == 0)   return res;
        
        res.add("");
        int start = 0;                          
        /// $$$$$$$$, we can have a new list also, here we keep it in just one list
        for(int i=0; i<digits.length(); i++) {
            String letters = LETTERS[digits.charAt(i) - '2'];
            int length = res.size();
            for(;start<length; start++) {
                for(int j=0; j<letters.length(); j++) {
                    res.add(res.get(start) + letters.charAt(j));
                }
            }
        }
        
        return res.subList(start, res.size());
        
    }
}
