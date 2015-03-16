/**
 * XXXX empty string is valid?
 */
public class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();     // $$$$$$$$$ toCharArray()
        int l = 0, r = s.length()-1;
        
        while(l < r) {
            while (l < r && !Character.isLetterOrDigit(chars[l]))   l++;        // $$$$$$$$$$$$
            while (l < r && !Character.isLetterOrDigit(chars[r]))   r--;
            if(l < r) {
                if (!match(chars[l], chars[r])) return false;
                l++; r--;               // XXXXX Forget this first time write!
            }
        }
        
        return true;
    }
    
    /*private boolean valid(char c) {
        return  (c >= '0' && c <= '9') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z')
    }*/
    
    private boolean match(char c1, char c2) {
        if (c1 >= '0' && c1 <= '9')     return c1 == c2;
        if (c1 >= 'A' && c1 <= 'Z')     return c1 == c2 || c1 == c2 + 'A' - 'a';
        else                            return c1 == c2 || c1 == c2 + 'a' - 'A';
    }
}
