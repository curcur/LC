/**
 * Jump Forward? Can we jump backwards?
 * lastp : the first position you can jump to the last index
 */
public class Solution {
    public boolean canJump(int[] A) {
        int lastp = A.length-1;
        for(int i=lastp-1; i>=0; i--) {
            if (lastp - i <= A[i])  lastp = i;
        }
        return lastp == 0;
    }
}
