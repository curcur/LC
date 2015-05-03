/**
 * The most simple way is counting bit by bit
 */
/*public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0, tmp = n;
        while(tmp!=0) {
            count += tmp & 1;
            tmp >>>= 1;
        }
        return count;
    }
}*/

/**
 * There are some other ways, like using a hashmap as in the reverse bit question
 * One from other people: n & n-1 will delete the right 1 from n
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0, tmp = n;
        while(tmp!=0) {
            tmp &= tmp-1;
            count++;
        }
        return count;
    }
}
