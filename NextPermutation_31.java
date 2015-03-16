/**
 * [..., 4, 6, 5, 3, 2]
 * -- Find the first decrease number (end -> start), [4] in this case
 * -- before the decrease number all increasing (end -> start)
 * -- find the minimal number bigger than the decrese number [5] in this case
 * -- switch [4] & [5]
 * -- reverse [6....2]
 * 
 */
public class Solution {
    public void nextPermutation(int[] num) {
        int di = num.length-1;
        for(; di>0; di--) 
            if (num[di] > num[di-1]) break;
        
        if (di>0)
            findAndSwap(num[di-1], num, di, num.length-1);
        
        reverse(num, di, num.length-1);
    }
    
    // binary search
    private void findAndSwap(int target, int[] num, int left, int right) {
        int l = left, r = right;
        int index = -1;
        while(l<=r) {
            int mid = (l+r)/2;
            //if (num[mid] >= target) {  // XXXXXXXX the equal means no change, no effect at all!
            if (num[mid] > target) {
                l = mid+1; index = mid; }
            else { r = mid - 1; }
        }
        int temp = num[left-1]; num[left-1] = num[index]; num[index] = temp;
    }

    private void reverse(int[] num, int l, int r) {
        while(l < r) {
            int temp = num[l];
            num[l] = num[r];
            num[r] = temp;
            l++; r--;
        }
    }
}
