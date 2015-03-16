/**
 * My First Thought:
 * -- Every decreasing & increasing sequences can hold a container
 * -- So first calculate this sequence, then sum (min(lefthight, righthight) - height_i)
 * 
 * Second Thought:
 * -- In the Container question 11, we use a left, right pointer, and one pass, can we do it here?
 * -- left, right -- the current highest
 */ 
/*public class Solution {
    public int trap(int[] A) {
        if (A.length == 0)  return 0;
        int l = 0, r = A.length-1, container = 0;
        int lheight = A[l], rheight = A[r]; 
        
        while(l < r) {
            if (lheight <= rheight) {
                l++;
                if (l < r) {
                    lheight = Math.max(lheight, A[l]);
                    container += Math.max(0, Math.min(lheight, rheight) - A[l]);
                }
                
            } else {
                r--;
                if (l < r) {
                    rheight = Math.max(rheight, A[r]);
                    container += Math.max(0, Math.min(lheight, rheight) - A[r]);
                }
                
            }
        }
        return container;
    }
}*/

/**
 * More concise
 */
public class Solution {
    public int trap(int[] A) {
        if (A.length == 0)  return 0;
        int l = 0, r = A.length-1, container = 0;
        int lheight = A[l], rheight = A[r]; 
        
        while(l <= r) {
            if (lheight <= rheight) {
                lheight = Math.max(lheight, A[l]);
                container += Math.max(0, Math.min(lheight, rheight) - A[l]);
                l++;
                
            } else {
                rheight = Math.max(rheight, A[r]);
                container += Math.max(0, Math.min(lheight, rheight) - A[r]);
                r--;
                
            }
        }
        return container;
    }
}
