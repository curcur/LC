/**
 * This problem is very good to testing the concept of:
 * Binary Search: -- the biggest smaller/equal to target
 *                -- the smallest bigger/equal to target
 * 
 * Solution: 1). You can find the target, than linear search the begin/end
 *               But this is O(n) in worse cases
 *           2). Biggest smaller than/ Smallest bigger than 
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        int left = leftEdge(A, target), right = rightEdge(A, target);
        if (left == -1 || A[left] != target)    { 
            Arrays.fill(res, -1);
        }else {
            res[0] = left; res[1] = right;
        }
        return res;
    }
    
    // ......78888]9...  the max <=8 
    private int rightEdge(int[] A, int target) {
        int ans = -1, l = 0, r = A.length-1;
        while(l <= r) {
            int mid = (l+r)/2;
            if (A[mid] <= target) {
                ans = mid;
                l = mid+1;
            }else r = mid-1;
        }
        return ans;
    }
    
    // ......7[88889...  the min >=8
    private int leftEdge(int[] A, int target) {
        int ans = -1, l = 0, r = A.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(A[mid] >= target) {
                ans = mid;
                r = mid - 1;
            }else l = mid + 1;
        }
        return ans;
    }
}
