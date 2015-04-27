/**
 * F[i] = max{F[i-1], F[i-2]+sum[i]}
 */

public class Solution {
    public int rob(int[] nums) {
        int prev1 = 0, prev2 = 0;
        int length = nums.length;
        
        for(int i=0; i<length; i++) {
            int tmp = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = tmp;
        }
        return prev1;
    }
}
