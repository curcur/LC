Longest Common Prefix
    - Write a function to find the longest common prefix string 
      amongst an array of strings.

/**
 * - Use str[0] as a base string
 * - From the start, compare with all other strings
 * - return when finding the first unmatch character
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)   return "";
        int index = 0;
        for(; index<strs[0].length(); index++) 
            for(int j=1; j<strs.length; j++) 
                if (index >= strs[j].length() || 
                    strs[j].charAt(index) != strs[0].charAt(index))
                    return strs[0].substring(0, index);
        return strs[0];
    }
}
