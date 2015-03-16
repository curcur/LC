/**
 * 1. move right one by one
 * 2. initialize another array, copy the ori[length-k, length-1] to dest[0, k-1]; ori[0, length-k-1] to dest[k, length-1]
 * 3. rotate twice
 */

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null)   return;
        
        k %= nums.length;           // XXXXXXX what if k>n?
        
        int left = 0, right = nums.length-1;
        pRotate(nums, left, right);
        
        left = 0; right = k-1;      // XXXXXX k-1
        pRotate(nums, left, right);
        
        left = k; right = nums.length-1;
        pRotate(nums, left, right);
    }
    
    private void pRotate(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left]; nums[left] = nums[right]; nums[right] = temp;
            left++; right--;
        }
        
    }
}
