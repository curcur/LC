/**
 * - The straightforward thinking is 
 *   - Sorting & compare one by one (O(nlogn))
 * - The simplest case: two elements
 *   - The maximum gap between two elements (max - min) / (2-1)
 *   - So if we have n elements, we have n-1 gaps
 *   - The minimum maximum gap is ceiling of (max-min)/(n-1)
 */

public class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        
        // min & max value of nums[]
        Pair border = new Pair(nums[0]);
        for(int i=1; i<n; i++) {
            if (border.min > nums[i])
                border.min = nums[i];
            else if(border.max < nums[i])
                border.max = nums[i];
        }
        
        Pair[] buckets = new Pair[n-1];
        int gap = (int)Math.ceil((border.max - border.min) / (double)(n-1));
        for(int i : nums) {
            if (i == border.min || i == border.max)
                continue;
                
            int buckIndex = (i-border.min)/gap;
            if (buckets[buckIndex] == null)
                buckets[buckIndex] = new Pair(i);
            else if (buckets[buckIndex].min > i) 
                buckets[buckIndex].min = i;
            else if (buckets[buckIndex].max < i) 
                buckets[buckIndex].max = i;
        }
        
        int maxgap = gap, prev = border.min;
        for(int i=0; i<n-1; i++) {
            if (buckets[i] != null) {
                maxgap = Math.max(maxgap, buckets[i].min-prev);
                prev = buckets[i].max;
            }
        }
        maxgap = Math.max(maxgap, border.max-prev);
        return maxgap;
    }
    
    private class Pair {
        Integer min;
        Integer max;
        
        Pair(int val) { min = val; max = val; }
    }
}
