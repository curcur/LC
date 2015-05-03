/**
 * - pi(x) ~ x/log x
 * - Approximate pi(x) with x/(log x - 1)
 * - Sieve of Eratosthenes: a list of primes
 * 
 * - XXXX Less than n (not include n)
 * - During the interview, this would be enough
 */

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2)     return 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int count = 0;
        
        for(int i=2; i<n; i++) {
            if(primes[i]) {
                count++;
                // XXXX j*i may overflow
                // for(int j=i; j*i<n; j++) {
                // $$$$ only needs to start from i
                for(int j=i; j<n/(double)i; j++) {
                    primes[j*i] = false;
                }
            }
        }
        return count;
    }
}

/**
 * - Use BitSet
 */
public class Solution {
    public int countPrimes(int n) {
        if(n <= 2)      return 0;
        BitSet bs = new BitSet(n);
        bs.clear(); bs.flip(2, n);
        int count = 0;
        for(int i=2; i<n; i++) {
            if(bs.get(i)) {
                count++;
                for(int j=i; j<n/(double)i; j++) {
                    bs.set(j*i, false);
                }
            }
            
        }
        return count;
    }
}

/**
 * - for each prime p, we calculate all numbers (<n) that is divisible by p
 * - we can further optimize it by only consider odd numbers > 2
 */
public class Solution {
    public int countPrimes(int n) {
        if (n <= 2)     return 0;
        
        // only consider odd bigger than 2 smaller than n
        int length = n/2;
        BitSet primes = new BitSet(length);
        primes.clear(); primes.flip(1, length);
        int count = 1;
        
        for(int i=1; i<length; i++) {
            if (primes.get(i)) {
                count++;
                int p = 2*i+1;
                for(int j=p; j<n/(double)p; j+=2) {
                    primes.set((j*p-1)/2, false);
                }
            }
        }
        return count;
    }
}
