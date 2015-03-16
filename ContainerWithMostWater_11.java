/**
 * 1. The most naive way is O(n^2), check each pair (a_i, a_j) and figure out the minimal
 * 2. Tried DP, but does not work.
 * 3. Then we can try left-right --> mid
 *  -- maxarea = min(height(left), height(right)) * (right - left) 
 *  -- move from the smaller one, this will increase the opportunity to enlarge the area
 *      (if having bigger area, one of the edges can not be the smaller edge)
 */ 
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, maxarea = 0;
        
        while(l<r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])  l++;
            else r--;
        }
        return maxarea;
    }
}
