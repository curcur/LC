/**
 *  1. Now you need a count to record how many times the  
 */

/*public class Solution {
    
    // XXX Java does not have const
    public static final int TIME = 2;       
    
    public int removeDuplicates(int[] A) {
        
        int times = 1;      // how many times the item appears  XXX initialize to 1 instead of 0
        int newindex = 0;
        
        if (A.length == 0)  return 0;
        
        for(int i=1; i<A.length; i++) {
            
            if (A[i] != A[newindex]) {  // new one
                A[++newindex] = A[i];  
                times = 1;
                continue;
            }
            
            // the same
            if (times < TIME)   {
                A[++newindex] = A[i];  
                times++;
                continue;
            }
        }
        return newindex+1;
    }
}*/

/**
 * Smarter Way: sliding two
 */
public class Solution {
    
    public static final int TIME = 2;
    
    public int removeDuplicates(int[] A) {
        
        if(A.length <= TIME)    return A.length;
        
        int newindex = TIME;
        for (int i=TIME; i<A.length; i++) {
            if (A[i] != A[newindex-TIME])           // XXX   newindex-TIME!!!
                A[newindex++] = A[i];
        }
        
        return newindex;
    }
}
