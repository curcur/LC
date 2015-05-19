/**
 * 1. DP: P(k, i) 
 * - the maximum profit with at most k trans sell before/on ith day
 *   == MAX { - 1. do nothing : P(k, i-1),
 *            - 2. sell       : max{P(k-1, j) + price[i] - price[j]; j=0...i-1}
 *           }
 */

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0)   return 0;

        // XXXX when k is very very large
        if (k >= prices.length/2)   return maxNProfit(prices);  
        
        int[][] Profit = new int[k+1][prices.length+1];
        
        for(int kk=1; kk<=k; kk++) {
	    // max{P(k-1, j) - P(j)}
            int sellMax = Profit[kk-1][1] - prices[0];
  
            for(int i=1; i<=prices.length; i++) {
                Profit[kk][i] = Profit[kk][i-1];
                // XXXX Do not need a loop here to find maxProfit[kk-1][j] 
		//                                    + prices[i] - prices[j]
                sellMax = Math.max(sellMax, Profit[kk-1][i] - prices[i-1]);
                Profit[kk][i] = Math.max(Profit[kk][i], prices[i-1]+sellMax);
            }
        }
        return Profit[k][prices.length];
    }
    
    public int maxNProfit(int[] prices) {
        int maxprofit = 0;
        for (int i=1; i<prices.length; i++) {
            maxprofit += Math.max(0, prices[i] - prices[i-1]);
        }
        return maxprofit;
    }
}

//------------------------------------------------------------------------------

/**
 * 2. maxsell[k], maxbuy[k]: the maximum money you get till transaction k 
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k==0 || prices.length == 0) return 0;
        if (k >= prices.length/2)   return maxNProfit(prices);  // XXXXXXXX when k is very very large
        
        int[] maxbuy = new int[k+1], maxsell = new int[k+1];
        for (int i=0; i<k+1; i++)
            maxbuy[i] = Integer.MIN_VALUE;          // XXXXXXXXX this is very important! very maxbuy[i] is minimal at first;
        
        for (int i=0; i<prices.length; i++) {
            for (int kk=1; kk<=k; kk++) {
                maxbuy[kk] = Math.max(maxbuy[kk], maxsell[kk-1] - prices[i]);
                maxsell[kk] = Math.max(maxsell[kk], prices[i] + maxbuy[kk]);
            }
        }
        return maxsell[k];
    }
    
    public int maxNProfit(int[] prices) {
        int maxprofit = 0;
        for (int i=1; i<prices.length; i++) {
            maxprofit += Math.max(0, prices[i] - prices[i-1]);
        }
        return maxprofit;
    }
}
