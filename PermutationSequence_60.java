/**
 * - I first use a DFS, but it TLE, hence should do more prune
 * - k / (n-1)! + 1 is 0th position's number from the left
 * - k % (n-1)! is the remaining ...
 * - In general, k / (n-1-i)! 's unused number is the ith position's number
 * - After noticing this formulation, we can solve the kth permutation directly
 * - The discuss has a solution not to use any memory 
 */
public class Solution {
    public String getPermutation(int n, int k) {
        k--;            // XXXX, the input k is 1based
        
        int factorial = 1;
        for(int i=1; i<=n; i++) factorial *= i;
        boolean[] taken = new boolean[n];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            factorial /= n-i;   // XXXX
            int num = k/factorial;
            int index = 0;
            while(num>=0) 
                if (!taken[index++]) num--;
            
            //sb.append(index+'0');   XXXX this will add a string 
            sb.append((char)(index+'0'));
            taken[index-1] = true;
            k %= factorial;
        }
        return sb.toString();
    }
}

/** 
 * DFS
 * - How to stop after kth sequence is reached
 * - Only needs to return kth sequence
 * - Time Limit Exceeded when k is very large
 */

public class Solution {
    int kth = 0;
    String kthstr = "";
    
    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        HashSet<Integer> hs = new HashSet<>();
        int length = 0;
        getPermutation(n, k, str, hs, length);
        
        return kthstr;
    }
    
    // false(stop) if bigger than k
    public boolean getPermutation(int n, int k, 
        StringBuilder str, HashSet<Integer> hs, int length) {
            
        if (length == n && kth == k) {
            kthstr = str.toString(); kth++; return false;
        }
        
        if (length == n) { kth++; return true; }
        
        
        for(int i=0; i<n; i++) {
            if (!hs.contains(i)) { 
                str.append(i+'0');  hs.add(i);  length++;
                if(!getPermutation(n, k, str, hs, length))  return false;
                length--; hs.remove(i); str.deleteCharAt(length);
            }
        }
        
        return true;
    }
}
