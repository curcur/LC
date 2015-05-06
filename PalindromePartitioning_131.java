/**
 * ----------------------------------------------------------------------------
   Palindrome Partitioning
    - Given a string s, partition s such that every substring of the partition 
      is a palindrome.
    - Return all possible palindrome partitioning of s.

   For example, given s = "aab",
    - Return
    [
      ["aa","b"],
      ["a","a","b"]
    ]
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 132 Palindrome Partitioning II
 *          5   Longest Palindromic Substring
 * Tags: Palindrome, Substring, Recursion, Dynamic Programming, Partition
 */

/**
 * Keywords: Partition, All lists
 * - This problem needs to return all possible results, hence the dynamic 
 *   programming (BFS) needs to store many intermediate results.
 * - 132 only needs to optimize the mincut, so is much more suitable for
 *   dynamic programming.
 * - Recursion may be more suitable for this problem.
 *
 * - DFS does not waste spaces, however, waste computation
 * - BFS does not waste computation, however, waste spaces
 *   
 * 1. Recursion
 * - Since we need to retuan all possible combinations, so DFS might be good
 * - for each substring s(0...i) which is a palindrome, 
 *   combine with all possible partitions(s(i+1...length-1))
 * - Time Complexity is exponential because
 *   - T(n) = n^2 + T(n-1) + T(n-2) + ...T(1)
 *   - Roughly O(n^2*2^n)
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


//------------------------------------------------------------------------------

/**
 * 2. DP without Recursion, Similar to 131. Palindrome Partitioning II
 * - res[i]: all possible partition lists till s(i)
 *   - Hence, res[i] = res[j] + if s(j,i) is palin     
 *     for each j == i-1, ..., 0
 * - How to check whether s(j,i) is palin? O(n)
 *   - we can use s(j+1, i-1) is palin && s(j) == s(i) ?
 *   - this suggests another DP (two dimensional)
 * - O(n^2) time, space is exponential
 */

public class Solution {
    public List<List<String>> partition(String s) {
        int length = s.length();
        if (length == 0)    
            return new ArrayList<>();
        
        // res[i+1]: the partition substrings till s[i]
	// res[0] is an empty list
        List<List<String>>[] res = new ArrayList[length+1];
	res[0] = new ArrayList<>(); res[0].add(new ArrayList<>());
	
	boolean[][] palindrome = new boolean[length][length];

        for(int i=0; i<length; i++) {
            res[i+1] = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    palindrome[j][i] = true;
                    if (j+1 <= i-1)
                        palindrome[j][i] = palindrome[j+1][i-1];
                }
                if (palindrome[j][i]) {
		    for(List<String> list : res[j]) {
			// XXXX Do not need clone() method, 
			// XXXX Use construction directly
			List<String> copylist = new ArrayList<>(list);
			copylist.add(s.substring(j, i+1));
			res[i+1].add(copylist);
		    }
		}
            }
        }
        return res[length];
    }
}
