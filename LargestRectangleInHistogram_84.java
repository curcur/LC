/**
 * 1. O(n^2) + prune height[i+1] > height[i]
 * 2. O(nlogn) divide find min [left - min), min (min, right], why?
 * 
 * 3. Stack ---  This is sooooo briliant, I can not come up with this method myself
 * The idea: - for each bar 'b', we find find the largest rectangle including bar 'b' 
 *           - this means bar 'b' is the minimal height bar in the local largest rectangle 
 *           - use a stack
 *           - push each bar to the stack util the new bar's height is smaller than those in the stack
 *              (the bars in the stack with increasing height).
 *           - the right index is the current bar, the left index is top-1 bar in the stack
 *                                                  XXXXXXXXXXXXXXXXXXXXXXXXXX
 */

public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();   // this is the index of bar
        stack.push(-1);
        int area = 0;
        
        for(int i=0; i<height.length; i++) {
            
            while(stack.peek() >= 0  && height[i] < height[stack.peek()]) {
                int baridx = stack.pop();
                area = Math.max(area, (i-stack.peek()-1)*height[baridx]);
            }
            stack.push(i);
        }
        while(stack.peek() >= 0) {
            int baridx = stack.pop();
            area = Math.max(area, (height.length-stack.peek()-1)*height[baridx]);
        }
        return area;
    }
}
