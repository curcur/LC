/**
 * - if we want to drive from station_i to station_j, 
 *   we should satisfy sum(gas[i]) > sum(cost[i]) for each intermediate station
 * - if we can not drive from station_i to station_j
 *   any station between i & j can not reach station_j
 * - O(n) time & O(1) space
 * - Other Comments
 *   If the total number of gas is bigger than the total number of cost. There must be a solution
 */
 
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        //if (length == 0)    return -1;
        //if (length == 1)    return 0;    // when length == 1 should return 0
        int station = 0;
        
        while(station < length) {
            int sumg = 0, sumc = 0;
            int i=station;
            for(; i<station+length; i++) {
                sumg += gas[i%length];
                sumc += cost[i%length];
                if (sumg < sumc) {
                    station = i+1;
                    break;
                }
            }
            // length = 1 also satisfy
            if (i == station+length)
                return station;
        }
        return -1;
        
    }
}
