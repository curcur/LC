public class Solution {
    public int findMin(int[] num) {
        int l = 0, r = num.length-1;  // [...)
        while(l < r) {
            if (num[l] < num[r])    return num[l];
            
            int mid = (l+r)/2;
            if (num[mid] < num[l])   { l++; r = mid; }   // min in (left, mid]
            else { l = mid+1; } // min in (mid, right]
        }
        
        return num[l];
        
    }
}
