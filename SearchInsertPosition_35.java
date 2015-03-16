public class Solution {
    public int searchInsert(int[] A, int target) {
        int pos = A.length, l = 0, r = A.length-1;
        
        while(l<=r) {
            int mid = (l+r) / 2;
            // the smallest bigger than, that's where to be inserted
            if (A[mid] == target) return mid;
            else if (A[mid] > target) {
                pos = mid;  r = mid - 1;
            } else l = mid + 1;
        }
        
        return pos;
    }
}
