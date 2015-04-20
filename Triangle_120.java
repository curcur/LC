/**
 * DP
 * - Of course, we can find every path from root to bottom, and output the minimum one
 * - But there are a lot of redundant computation here
 * - We can use DP instead to record the F[i][j]
 *      - the minimal path sum till ith row jth element    
 */

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 0)  
            return 0;
        
        int[] F = new int[rows];
        F[0] = triangle.get(0).get(0);
        int minsum = F[0];
        
        for(int i=1; i<rows; i++) {  // for each row
            F[i] = F[i-1] + triangle.get(i).get(i); // the first
            minsum = F[i];
            for(int j=i-1; j>0; j--) {
                F[j] = Math.min(F[j], F[j-1]) + triangle.get(i).get(j);
                minsum = Math.min(minsum, F[j]);
            }
            F[0] = F[0] + triangle.get(i).get(0);
            minsum = Math.min(minsum, F[0]);
        }
        return minsum;
    }
}

/**
 * We can also think about this problem bottom up
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 0)  
            return 0;
            
        int[] F = new int[rows];
        int i = 0;
        for(Integer integer : triangle.get(rows-1)) 
            F[i++] = integer;
        
        for(i=rows-2; i>=0; i--) 
            for(int j=0; j<=i; j++) 
                F[j] = Math.min(F[j], F[j+1]) + triangle.get(i).get(j);
            
        return F[0]; 
        
    }
}
