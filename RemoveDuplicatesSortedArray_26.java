/**
 * The previous array will always be longer than the new one
 * so we only need to remember the new current index
 */
 
public class Solution {
    public int removeDuplicates(int[] A) {
        
        //XXX should check whether the array is empty
        if (A.length == 0)  return 0;
        
        int prev = A[0];    // xxx we do not need prev actually, prev can be calculated by A[newlength-1]
        int newlength = 1;  // the new length
        
        for(int i=1; i<A.length; i++) {
            
            if (A[i] == prev)   continue;
            
            A[newlength++] = A[i];
            prev = A[i];
        }
        return newlength;
    }

}
