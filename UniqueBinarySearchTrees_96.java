/**
 * ----------------------------------------------------------------------------
   Unique Binary Search Trees
    - Given n, how many structurally unique BST's (binary search trees) 
      that store values 1...n?
    - For example,
    - Given n = 3, there are a total of 5 unique BST's.
 * ----------------------------------------------------------------------------
 */

/**
 * 1. DP -- 
 * - F(4) = F(3) + F(3) * F(4-3-1) + F(2) * F(4-2-1) + F(1) * F(4-1-1)
 * - The first F(3) is using Node4 as the root
 * - F(3) * F(4-3-1) is adding Node4 to F(3), rooted from Node4
 * - F(2) * F(4-2-1) is adding Node4, Node3 to F(2), rooted from Node4
 * - F(1) * F(4-1-1) is adding Node4, Node3, Node2 to F(1), rooted from Node4
 * - See related attachment
 */

public class Solution {
    public int numTrees(int n) {
	// number of different trees
        int[] F = new int[n+1];       
        F[0] = 1;
        
        for(int i=1; i<=n; i++) {
            F[i] = F[i-1];
            
            for(int j=i-1; j>0; j--) {
                F[i] += F[j]*F[i-j-1];
            }
        }
        return F[n];
    }
}


//------------------------------------------------------------------------------

/**
 * 2. DP -- More Clear
 * Construction Unique
 * 1...j...n
 * (1...j-1) --> left
 * (j+1...n) --> right
 */

public class Solution {
    public int numTrees(int n) {
        int[] F = new int[n+1];
        F[0] = 1;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                F[i] += F[j-1] * F[i-j];
            }
        }
        return F[n];
    }
}
