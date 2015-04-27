/**
 * - Can the array have the same element?
 * - Maintain Two Viarables, start & end
 * - If nums[i] == start, start++
 * - Else if nums[i] > start, end = nums[i-1]; 
 * 
 * - The input array is empty
 * - Input array has out of range elments
 * - Input array has every element
 */

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int start = lower, end = upper;
        
        int length = nums.length;
        for(int i=0; i<length; i++) {
            if (nums[i] == start) {
                start++;
            } else if (nums[i] > start) {
                end = nums[i]-1;
                pad(res, start, end);
                start = nums[i]+1;
            }
            // else nums[i] < start (same lement, so start keep the same)
        }
        
        // tailing
        end = upper;
        pad(res, start, end);
        return res;
    }
    
    private void pad(List<String> res, int start, int end) {
        if (start == end)
            res.add(String.valueOf(start));
        else if (start < end)
            res.add(String.valueOf(start)+"->"+String.valueOf(end));
    }
}
