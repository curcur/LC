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
