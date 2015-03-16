/**
 * F[i]: minimal number of jumps from 0 to poistion i
 * F[i]: = Min(F[j] + 1)  (for each j : j < i && A[j] >= i-j)
 * We do not need another loop for this, since F[j] can be updated in the same round of i->j
 * 
 * Time Limit Exceeded
 */
/*public class Solution {
    public int jump(int[] A) {
        if (A.length == 0)  return 0;
        int[] F = new int[A.length];
        Arrays.fill(F, Integer.MAX_VALUE);
        F[0] = 0;
        
        for(int i=0; i<A.length; i++) 
            for(int j=1; j<=A[i] && i+j < A.length; j++) {
                F[i+j] = Math.min(F[i+j], F[i] + 1);
            }
        
        return F[A.length-1];
    }
}*/

/**
 * How to optimize this:
 * F[0] = 0;        A[0] = t
 * F[1...t] = 1;    There is no other way to make this smaller
 * so we only needs to start from [t+1] next time
 */
/*public class Solution {
    public int jump(int[] A) {
        if (A.length == 0)  return 0;
        int[] F = new int[A.length];
        
        Arrays.fill(F, Integer.MAX_VALUE);
        F[0] = 0;
        
        int index = 1;
        for(int i=0; i<A.length; i++) {
            if (index <= i)     return Integer.MAX_VALUE;  // not able to reach i from the beginning
            for(; index<=i+A[i] && index<A.length; index++) {
                if (index == A.length-1)    return F[i]+1;
                else F[index] = F[i] + 1;
            }
        }
        
        return F[A.length-1];
    }
}*/

/**
 * More efficient w/o F?
 * jump: the number of jumps till now
 * currjumpindex: the furthest index jump-1 can achieve  -- (this circle end)
 * nextjumpindex: the furthest index jump can achieve  -- (next circle end)
 */
public class Solution {
    public int jump(int[] A) {
        if (A.length == 0 || A.length == 1)  return 0;  // XXXXX corner case length = 1
        int jump = 1, currJumpIndex = 0, nextJumpIndex = 0;
        
        for(int i=0; i<A.length; i++) {
            nextJumpIndex = Math.max(nextJumpIndex, A[i] + i);
            if (nextJumpIndex >= A.length-1) return jump;
            
            if (i == currJumpIndex) {
                jump++;
                if (nextJumpIndex == currJumpIndex)    return Integer.MAX_VALUE; // can not increase
                currJumpIndex = nextJumpIndex;
            }
        }
        return Integer.MAX_VALUE; // this will not achieve
        
    }
}
