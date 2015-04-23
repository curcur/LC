/**
 * XXXX
 * 1. O(n) time, O(1) space, just one pass
 * This problem is kind of ticky, looks very simple, 
 * but needs to consider a lot of details
 * 
 * - Exsiting solutions from the web all needs O(n) spaces
 * - But I only use O(1) space
 * - Two varibles: 
 *   - totalCandy: record the total number of Candies needed
 *   - decrLength: the length of the decreasing sequences     
 * 
 * - Increment sequences c[i] = c[i-1] + 1
 * - Decrement sequences c[i] = c[i-1] - 1
 *      - Needs two adjustments
 *        1). If the decreasing floor < 1 (shift to 1)
 *        2). If the decreasing floor > 1 (shift to 1)
 * - c[i] = 1 if ratings[i] == ratings[i-1]
 * 
 * Example Ranking:  3 4 3 2  5 6 4  
 * Candy Assignment: 1 2 1 0
 *                   1(3 2 1)|2 3 2
 * XXXX
 *                   2 3 2 1 |2 3(1)
 * XXXX
 * 
 * - A big mistake costs me long time to debug:
 *   - the decreasing floor reached when ratings[i] == ratings[i-1] 
 */

public class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length == 0)    return 0;
                
        int totalCandy = 1, prevCandy = 1;
        // to identify the decreasing length
        int decrLength = 0;   
        
        for(int i=1; i<ratings.length; i++) {
            // if same value as before, can restart
            if (ratings[i] == ratings[i-1]) {
		// XXXX shift the decrease phase
                totalCandy -= (prevCandy-1) * decrLength;   
                prevCandy = 1;
                decrLength = 0;
            } else if (ratings[i] < ratings[i-1]) { // decreasing phase
                decrLength++;
                if (prevCandy == 1)  // increase the decreasing sequence by 1
                    totalCandy += decrLength;
                else
                    prevCandy--;
            } else {
                if (decrLength > 0) { // reset the phase
		    // shift the decrease phase
                    totalCandy -= (prevCandy-1) * decrLength;   
                    decrLength = 0;
                    prevCandy = 2;
                } else 
                    prevCandy++;
            }
            totalCandy += prevCandy;
        }
        
        // XXXX the last decreasing phase shift
        totalCandy -= (prevCandy-1) * decrLength;
        return totalCandy;
    }
}

/**
 * Easier Solution, using O(n) space
 * - First Pass:    from left to right
 * - Second Pass:   from right to left
 * in both passes, only consider rising phases
 */
public class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length == 0)    return 0;
        
        int[] Candy = new int[length];
        Arrays.fill(Candy, 1);

        // first pass, incremental sequences
        for(int i=1; i<length; i++) 
            if (ratings[i] > ratings[i-1])
                Candy[i] = Candy[i-1] + 1;

        // second pass, decremental sequences
        int totalCandy = Candy[length-1];        
        for(int i=length-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1])
                Candy[i] = Math.max(Candy[i], Candy[i+1]+1);
            totalCandy += Candy[i];
        }
        return totalCandy;
    }
}
