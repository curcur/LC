/**
 * Use the algorithm 84. Largest Rectangle in Histogram
 * - Use each row as a base
 * - height[j] = 0 if matrix[i][j] == 0
 * - height[j]++ otherwise
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;      if (m == 0) return 0;
        int n = matrix[0].length;   if (n == 0) return 0;
        
        int[] height = new int[n];
        int max = 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
		// XXXX the input is char
                if (matrix[i][j] == '0')  height[j] = 0;    
                else    height[j]++;
                
                // pop until all higher bars are poped
                while (stack.peek() >= 0 && height[j] < height[stack.peek()]) {
                    int h = height[stack.pop()];
                    max = Math.max(max, (j-1-stack.peek()) * h);
                }
                
                stack.push(j);
            }
            // reach the end of the column
            while(stack.peek() >= 0) {
                int h = height[stack.pop()];
                max = Math.max(max, (n-1-stack.peek()) * h);
            }
            
            // -1 left in the stack
        }
        return max;
    }
}
