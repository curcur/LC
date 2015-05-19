/**
 * ----------------------------------------------------------------------------
   Best Time to Buy and Sell Stock
    - Say you have an array for which the ith element is the price of a given 
      stock on day i.
     
    - If you were only permitted to complete at most one transaction 
    - (ie, buy one and sell one share of the stock), design an algorithm to 
      find the maximum profit.
 * ----------------------------------------------------------------------------
 */

/**
 * XXXXX the min should happen smaller than max
 * 
 * - P[i]: the max profit we can get if selling on day_i
 *       sell[i] - minprice till day_i
 */ 
 
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int maxP = 0, minBuy = prices[0];
        for(int i=1; i<prices.length; i++) {
	    minBuy = Math.min(minBuy, prices[i]);
            maxP = Math.max(maxP, prices[i]-minBuy);
        }
        return maxP;
    }
}
