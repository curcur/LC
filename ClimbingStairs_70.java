/**
F[i]: number of ways to climb i steps
2 ways to get to F[i]:
1 step F[i-1]
2 step F[i-2]

=> F[i] = F[i-1] + F[i-2]
F[1] = 1
F[2] = 2
*/

public class Solution {
    public int climbStairs(int n) {
        //int[] F = new int[n+1];
        //F[1] = 1; F[2] = 1;
        
        //  XXXXXXX Most DP does not need to store the entire status, 
        //  XXXXXXX Only needs to maintain the useful two status
        
         
        int p1 = 1, p2 = 2, steps = -1;
        
        if (n==1)   return p1;
        if (n==2)   return p2;
        
        for(int i=3; i<=n; i++) {
            steps = p1+p2;
            p1 = p2; p2 = steps;
        }
        return steps;
    }
}
