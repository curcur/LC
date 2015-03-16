/**
 * XXXXX This is not that simple, the min should happen smaller than max
 * 
 * DP -- O(n)
 * P(i): the maximal profit on ith day if buy and sell before or on day i; buy before sell 
 * P(i) == max { P(i-1), p - min }, update min if p < min
 */ 
 
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int maxP = 0, minBuy = prices[0];
        for(int i=1; i<prices.length; i++) {
            maxP = Math.max(maxP, prices[i]-minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }
        return maxP;
    }
}
