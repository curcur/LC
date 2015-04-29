/**
 * Charset is A C G T
 * => 4^10 different sequences => 2^20 different sequences
 * An integer has 32 bits, we can use 20 bits of an integer, 
 * 2 bits for each position
 * 
 * - Rolling hash (Rabin-Karp algorithm)
 * 
 */
public class Solution {
    private static final Map<Character, Integer> dict = new HashMap<>();
    static { dict.put('A', 0); dict.put('C', 1); 
	dict.put('G', 2); dict.put('T', 3); }
    // first 12 bits are 0s & last 20 bits are 1s
    private static final int F = 0xFFFFF; 
    
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int length = s.length();
        
        if (length <= 10)   return res;
        
        // initiate
        int fnum = 0;
        for(int i=0; i<10; i++)
            // XXXX bit operation has lower priority than arithmetic computation
            fnum = (fnum << 2) + dict.get(s.charAt(i));
            
        // integer representing 10-letter-long substring -> number of counts
        Map<Integer, Integer> ctmap = new HashMap<>();
        ctmap.put(fnum, 1);
        
        for(int i=10; i<length; i++) {
            fnum = (fnum << 2 & F) + dict.get(s.charAt(i));
            int cnt = 0;
            if (ctmap.containsKey(fnum)) 
                cnt = ctmap.get(fnum);
            if (cnt == 1)
                res.add(s.substring(i-9, i+1));
            ctmap.put(fnum, cnt+1);
        }
        
        return res;
    }
}
