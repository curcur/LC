/**
 * XXXXXXXXX The following are wrong when I first do it!
 * 1. dot is a regular expression => use \\. to split
 * 2. what if no dot?
 * 3. support multiple dot?
 * 4. 1.0 > 1 ? no
 */
 
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");    // XXXXXXXXX . is regular expression, use \\ instead
        String[] v2 = version2.split("\\.");
        
        int length = Math.min(v1.length, v2.length);
        int i = 0;
        for (; i<length; i++) {
            if (compare(v1[i], v2[i]) != 0)     return compare(v1[i], v2[i]);
        }
        
       for (; i<v1.length; i++) {
            if (compare(v1[i], "0") != 0)       return compare(v1[i], "0");
       }
        
        for(; i<v2.length; i++) {
            if (compare("0", v2[i]) != 0)       return compare("0", v2[i]);
        }
        
        return 0;
    }
    
    int compare(String v1, String v2) {
        return Integer.valueOf(v1).compareTo(Integer.valueOf(v2));    // XXXXXXXX Integer compareTo
    }
}
