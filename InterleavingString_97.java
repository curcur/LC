/**
 * My Thought:  DFS
 * Time Limit Exceeded
 */
/*public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }
    
    public boolean isInterleave(String s1, int b1, String s2, int b2, String s3, int b3) {
        if (s3.length()-b3 != s1.length()-b1 + s2.length()-b2)  return false;
        while(b1 < s1.length() && b2 < s2.length()) {
            if (s1.charAt(b1) == s3.charAt(b3) && s2.charAt(b2) == s3.charAt(b3))
                return isInterleave(s1, b1+1, s2, b2, s3, b3+1) ||
                        isInterleave(s1, b1, s2, b2+1, s3, b3+1);
            else if (s1.charAt(b1) == s3.charAt(b3)) { b1++; b3++; }
            else if (s2.charAt(b2) == s3.charAt(b3)) { b2++; b3++; }
            else return false;
        }
        if (b1 < s1.length())   return s1.substring(b1).equals(s3.substring(b3));
        else return s2.substring(b2).equals(s3.substring(b3));
    }
}*/

/**
 * But from the previous work, we can figure out
 * isInterleave(s1, b1, s2, b2, s3, b3) =
 *      isInterleave(s1, b1+1, s2, b2, s3, b3+1) ||
                        isInterleave(s1, b1, s2, b2+1, s3, b3+1);
 *
 * =>       
 * F[i,j] ending with s1[i], s2[j], for s3[i+j] // (ending with/starting with is the same)
 * F[i,j] = (s1[i] == s3[i+j] && F[i-1,j]) || (s2[j] == s3[i+j] && F[i,j-1])
 * 
 * and we can optimize it by using just O(n) space
 * Let's start with two dimensional matrix
 * 
 * XXXXXXXXXX
 * The key point is S1(i-1) + S2(j-1) = S3(i+j-1), i & j length
 */
/*public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())   return false;
        
        // XXXXXX F[i][j] length = i,j
        // I use it first time as index, it is wrong
        boolean[][] F = new boolean[s1.length()+1][s2.length()+1];     
                                                                        
        F[0][0] = true; // s1, s2, s3, empty
        for(int i=1; i<=s1.length(); i++)
            F[i][0] = F[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        for(int j=1; j<=s2.length(); j++)
            F[0][j] = F[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        
        for (int i=1; i<=s1.length(); i++) {
            for(int j=1;j<=s2.length(); j++) {
                F[i][j] = (F[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                                (F[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return F[s1.length()][s2.length()];
    }
}*/

/**
 * Optimize it to O(n) space usage
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())   return false;
        
        // XXXXXX F[i][j] length = i,j
        // I use it first time as index, it is wrong
        boolean[] F = new boolean[s2.length()+1];   // F[i,j]
        F[0] = true;
        
        //XXXXXXXXXXXX F[0,j]
        for(int j=1; j<=s2.length(); j++)
            F[j] = F[j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        
        for (int i=1; i<=s1.length(); i++) {
            F[0] = F[0] && s1.charAt(i-1) == s3.charAt(i-1);  // F[i,0]
            for(int j=1;j<=s2.length(); j++) {
                F[j] = (F[j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                        (F[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return F[s2.length()];
    }
}
