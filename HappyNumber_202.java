/**
 * - Use a HashSet to record whether a number has already exists 
 *   If yes, then it forms a cycle, return false
 * - Input is a positive number
 * - O(n) extra space, were n is the size of the cycle
 */

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while(true) {
            if (n == 1) 
                return true;
    
            int sum = 0;
            while(n>0) {
                sum += (n%10) * (n%10);
                n = n / 10;
            }
            if(set.contains(sum))
                return false;
            else {
                set.add(sum);
                n = sum;
            }
        }
    }
}

/**
 * How to solve this without using extra spaces
 * - Remeber how we test whether a linked list has a cycle : Fast & Slow Pointers
 * - If there is a cycle, fast will catch the slow pointer finally
 * - Floyd Cycle-Finding Algorithm
 * - k + t = n*c => k = nc-t
 */

public class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = ssum(n);
        while(true) {
            if (fast == 1)
                return true;
            else if (slow == fast)
                return false;
            fast = ssum(ssum(fast));
            slow = ssum(slow);
        }
    }
    
    private int ssum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }
}
