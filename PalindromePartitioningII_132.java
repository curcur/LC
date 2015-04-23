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
 * 2. Without Recursion, Similar to 131. Palindrome Partitioning II
 * - res[i]: all possible partition lists till s(i)
 *      Hence, res[i] = res[j] + if s(j,i) is palin     
 *      for each j == i-1, ..., 0
 * 
 * - How to check whether s(j,i) is palin? O(n)
 *      - we can use s(j+1, i-1) is palin && s(j) == s(i) ?
 *      - this suggests another DP (two dimensional)
 */

public class Solution {
    public List<List<String>> partition(String s) {
        int length = s.length();
        if (length == 0)    
            return new ArrayList<>();
        
        // res[i]: the partition substrings till s[i]
        List<List<String>>[] res = new ArrayList[length];
        boolean[][] palindrome = new boolean[length][length];
        
        for(int i=0; i<length; i++) {
            res[i] = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    palindrome[j][i] = true;
                    if (j+1 <= i-1)
                        palindrome[j][i] = palindrome[j+1][i-1];
                }
                if (palindrome[j][i]) {
                    if (j == 0) {   // the res[-1] is empty
                        List<String> list = new ArrayList<>();
                        list.add(s.substring(j, i+1));
                        res[i].add(list);
                    }else {
                        for(List<String> list : res[j-1]) {
                            // XXXX Do not need clone() method, 
			    // XXXX Use construction directly
                            List<String> copylist = new ArrayList<>(list);
                            copylist.add(s.substring(j, i+1));
                            res[i].add(copylist);
                        }
                    }
                }
            }
        }
        return res[length-1];
    }
}
