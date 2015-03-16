/**
 * We do not need to know the value of the key, so HashSet is enough
 * 
 * 1. Find the beginning O(2n)
 */

/* 
public class Solution {
    
    public int longestConsecutive(int[] num) {
        
        // construct the hashSetv
        HashSet<Integer> hset = new HashSet<Integer>(); 
        for (int i : num) { hset.add(Integer.valueOf(i)); } // do not matter what is put in as a value
        
        // find the longest consecutive elements
        int count = 1, maxcount = 1;
        for (int i: num) {
            count = 1;
            if (hset.contains(Integer.valueOf(i+1)) && !hset.contains(Integer.valueOf(i-1))) {  
                
                // start of a consecutive sequence longer than 1
                // start counting
                while(hset.contains(Integer.valueOf(i+count))) { count++; }
                if (count > maxcount)   maxcount = count;
            }
        }
        return maxcount;
    }
}
*/

/**
 * 2. Start from any one, before & after, remove others from the set O(n)
 * But in fact, it is still O(2n)
 */

public class Solution{
    
    public int longestConsecutive(int[] num) {
        HashSet<Integer> hset = new HashSet<Integer>();
        for (int i:num) { hset.add(Integer.valueOf(i)); }
        
        int countb = 1, counta = 1, maxcount = 1;
        
        for (int i:num) {
            countb = 1; counta = 1;
            if (!hset.remove(Integer.valueOf(i)))   continue;
            
            // before i
            while(hset.contains(Integer.valueOf(i-countb))) {
                hset.remove(Integer.valueOf(i-countb));
                countb++;
            }
            
            // after i
            while(hset.contains(Integer.valueOf(i+counta))) {
                hset.remove(Integer.valueOf(i+counta));
                counta++;
            }
            
            maxcount = Math.max(maxcount, counta+countb-1);
        }
        
        return maxcount;
        
    }
}
