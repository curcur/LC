/**
 * ----------------------------------------------------------------------------
   Best Time to Buy and Sell Stock III 
    - Say you have an array for which the ith element is the price of a given 
      stock on day i.
    - Design an algorithm to find the maximum profit. 
    - You may complete at most two transactions.

   Note:
    - You may not engage in multiple transactions at the same time 
      (ie, you must sell the stock before you buy again).
 * ----------------------------------------------------------------------------
 */

/**
 * 1. DP
 * 
 * - f[i]: the maximal profit of one trans during day [0,i]  
 *   -- the same as Best Time to Buy and Sell Stock I
 * - g[i]: the maximal profit of one trans during day [i,n] 
 *   -- set i = n, oppoiste calculation of f[i]
 * 
 * - Find the max f[i] + g[i];
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        
        int[] g = new int[n];   g[n-1] = 0;
        int maxSell = prices[n-1];
        for (int i=n-2; i>=0; i--) {
	    maxSell = Math.max(maxSell, prices[i]);
            g[i] = Math.max(g[i+1], maxSell - prices[i]); 
        }
        
	// fProfit is f[i], maxProfit is P[i]
        int fProfit = 0, maxProfit = 0, minBuy = prices[0];   
        for(int i=0; i<n; i++) {
	    minBuy = Math.min(minBuy, prices[i]);
            fProfit = Math.max(fProfit, prices[i]-minBuy);
           
            maxProfit = Math.max(maxProfit, fProfit + g[i]);
        }
        
        return maxProfit;
    }
}


//------------------------------------------------------------------------------

/**
 * 2. This is also the excellent solutions copied from the disccussion
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;

	// Assume we only have 0 money at first
        for(int i:prices){                              
	    // The maximum if we've just sold 2nd stock so far.
            release2 = Math.max(release2, hold2+i);     

	    // The maximum if we've just buy  2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  

	    // The maximum if we've just sold 1nd stock so far.
            release1 = Math.max(release1, hold1+i);     

	    // The maximum if we've just buy  1st stock so far. 
            hold1    = Math.max(hold1,    -i);          
        }
	// Since release1 is initiated as 0,
	// so release2 will always higher than release1.
        return release2; 
    }
}


//------------------------------------------------------------------------------

/**
 * 3. There are more generalized DP with P(k, i): 
 *    the maximum profit with k transactions before i 
 *    See: 188 Best Time to Buy and Sell Stock IV 
 */
