public class Solution {
    public boolean search(int[] A, int target) {
        int leftidx = 0, rightidx = A.length-1, mididx = A.length/2;
        
        while (leftidx <= rightidx) {
            
            mididx = (leftidx + rightidx)/2;    // XXX I forget this;
            
            if (target == A[leftidx])   return true;
            if (target == A[rightidx])  return true;
            if (target == A[mididx])    return true;
            
            if (A[mididx] > A[rightidx]) {  //  pivot on the right & mid >= left >= right
                if(target > A[mididx] || target < A[rightidx]) {
                    leftidx = mididx + 1; rightidx--; continue;
                }else if(target > A[leftidx] && target < A[mididx]) {
                    rightidx = mididx - 1; leftidx++; continue;
                }else { return false; }
            }else if(A[mididx] < A[rightidx]) { // pivot on the left (]
                if(target > A[mididx] && target < A[rightidx]) {
                    leftidx = mididx + 1; rightidx--; continue;
                }else if (target > A[leftidx] || target < A[mididx]) {
                    rightidx = mididx - 1; leftidx++; continue;
                }else { return false; }
            }else { // A[mididx] == A[rightidx], the difference of the previous one is this situation
                leftidx++; rightidx--;
            }
        }
        return false;
    }
}
