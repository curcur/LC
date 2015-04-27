/**
 * - It is very straightforward to do in O(n) time
 * - But the problem requires O(logn) time
 * - So we consider to use binary search
 * 
 * Steps:
 * - Find the mid, if mid is peak, return mid
 * - else there must exsit one number greater than mid
 * - Take the half containing the > mid number
 * - Since num[-1] & num[n] is smaller than any element
 *   The half containing > mid number must have a peak
 */
 
public class Solution {
    public int findPeakElement(int[] nums) {
        // XXXX the original input is List<Integer>
        //Integer[] arrays = nums.toArray(new Integer[0]);
        int length = nums.length;
        
        int l = 0, r = length-1;
        // at least two elements & mid+1 is always available
        while(l<r) { 
            int mid = (l+r)/2;
            if(mid-1 < l || nums[mid] > nums[mid-1]) {
                if (nums[mid] > nums[mid+1]) // mid+1 is always available
                    return mid;
                else 
                    l = mid+1;
            } else 
                r = mid-1;
        }
        return l;
    }
}


/**
 * Recursive
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }
    
    private int findPeakElement(int[] nums, int l, int r) {
        if (l == r)     return l;
        
        // at least two elements
        int mid = (l+r)/2;
        if(mid-1 < l || nums[mid] > nums[mid-1]) {
            if (nums[mid] > nums[mid+1]) // mid+1 is always available
                    return mid;
            else return findPeakElement(nums, mid+1, r);
        }else
            return findPeakElement(nums,l, mid-1);
    }
}

/**
 * 3. More Clean Solution
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        // XXXX the original input is List<Integer>
        //Integer[] arrays = nums.toArray(new Integer[0]);
        int length = nums.length;
        
        int l = 0, r = length-1;
        // at least two elements & mid+1 is always available
        while(l<r) { 
            int mid = (l+r)/2;
            if (nums[mid] > nums[mid+1]) 
                r = mid;
            else 
                l = mid+1;
        }
        return l;
    }
}
