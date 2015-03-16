/**
 * 1. Of course, this is DP again
 * 
 * P[i]: the maximal profit the first trans sell before or at i, the second trans buy after or at i
 * f[i]: the maximal profit of one trans [0,i] -- the same as Best Time to Buy and Sell Stock I
 * g[i]: the maximal profit of one trans [i,n] -- set i = n, oppoiste calculation of f[i]
 * 
 * P[i] = f[i] + g[i];
 */
/*public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        
        int[] g = new int[n];   g[n-1] = 0;
        int maxSell = prices[n-1];
        for (int i=n-2; i>=0; i--) {
            g[i] = Math.max(g[i+1], maxSell - prices[i]); 
            maxSell = Math.max(maxSell, prices[i]);
        }
        
        int fProfit = 0, maxProfit = 0, minBuy = prices[0];    // fProfit is f[i], maxProfit is P[i]
        for(int i=0; i<n; i++) {
            fProfit = Math.max(fProfit, prices[i]-minBuy);
            minBuy = Math.min(minBuy, prices[i]);
            maxProfit = Math.max(maxProfit, fProfit + g[i]);
        }
        
        return maxProfit;
    }
}*/


/**
 * 2. This is also the excellent solutions copied from the disccussion
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}

/**
 * 3. There are more generalized DP with P(k, i): the maximum profit with k transactions before i 
 */
