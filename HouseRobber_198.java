/**
 * F[i] = max{F[i-1], F[i-2]+sum[i]}
 * - Follow up: what if all the houses form a circle
 * - Follow up: the difference is that house_n is adjacent to house_1
		houses: F[1…n-1] and F’[2…n]
		return max {F(n-1), F’(n)}
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
