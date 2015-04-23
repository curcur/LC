/**
 * 1. Recursion
 * - Since needs to retuan all possible combinations, so DFS might be good
 * - for each s(0...i) is palindrome, 
 *   combine with all possible partitions(s(i+1...length-1))
 * - DFS does not waste spaces, however, waste computation
 */

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int length = s.length();
        if (length == 0)
            return res;
               
        for(int i=1; i<=length; i++) {
            String subleft = s.substring(0, i);
            if(isPalindrome(subleft)) {
                if (i == length) {  // the rightsub is empty
                    List<String> list = new ArrayList<>();
                    list.add(subleft);
                    res.add(list);
                } else {
                    String subright = s.substring(i, length);
                    List<List<String>> rightpartition = partition(subright);
                    for(List l : rightpartition) {
                        l.add(0, subleft);
                        res.add(l);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String s) {
        int length = s.length();
        int i=0, j=length-1;
        while(i<j) 
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
}

/**
 * - P[i]: all possible partition lists till s(i)
 *      Hence, P[i] = P[j] + if s(j,i) is palin     for each j == i-1, ..., 0
 * 
 * - How to check whether s(j,i) is palin? O(n)
 *      - we can use s(j+1, i-1) is palin && s(j) == s(i) ?
 *      - this suggests another DP (two dimensional)
 */
/*public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int length = s.lengt();
        if (length == 0)    return res;
        
        // P[i]: the list of js where s(j...i) is palindrome
        List<Integer>[] P = new List[length];
        boolean[][] palindrome = new boolean[length][length];
        
        for(int i=0; i<length; i++) {
            
        }
        
        
    }
}*/
