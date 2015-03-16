/**
 * Use Binary Search.
 * Hard Part: locate which part the value is in
 * if mid > right, pivot is on the right half (mid, right]
 * if mid <= right, pivot is on the left half [left, mid]
 **/
public class Solution {
    public int search(int[] A, int target) {
        
        if (A.length == 0)  return -1;  // empty input array
        
        int leftidx = 0, rightidx = A.length-1, mididx = A.length/2;
        
        while (leftidx <= rightidx) {
            
            mididx = (leftidx + rightidx) / 2;
            if (target == A[mididx])    return mididx;
            if (target == A[rightidx])  return rightidx;
            if (target == A[leftidx])   return leftidx;
            
            if (A[mididx] > A[rightidx]) { // pivot on the right (mid...]
                if (target > A[mididx] || target < A[rightidx]) {
                    leftidx = mididx + 1; rightidx--; continue;
                } else if (target > A[leftidx] && target < A[mididx])  {
                    rightidx = mididx - 1; leftidx++; continue;
                } else {
                    return -1;
                }
            }else if (A[mididx] < A[rightidx]) {    // pivot on the left [0...mid]
                if (target > A[mididx] && target < A[rightidx]) {   // this must be first, special case when pivot on the first
                    leftidx = mididx + 1;  rightidx--; continue;
                } else if (target < A[mididx] || target > A[leftidx]) {
                    rightidx = mididx - 1; leftidx++; continue;
                } else {
                    return -1;
                }
            }else { return -1; }
            
        }
        
        return -1;
        
    }
}
