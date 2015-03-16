/**
 * 1. HashMap value -> index
 * 
 * need more space at least O(n) space
 * 
 * O(n) time
 */

// XXX 1. HashMap can hold only one value! What if they have duplicates!!!
// XXX 2. What if have only one [3], but the target is [6].

public class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        
        int[] res = new int[2];
        
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++) {
            
            Integer previndex = hmap.get(Integer.valueOf(numbers[i]));
            if (previndex != null) {
                // duplicates
                if (numbers[i] * 2 == target) {
                    res[0] = previndex.intValue()+1;
                    res[1] = i+1;
                } 
            }
            hmap.put(Integer.valueOf(numbers[i]), Integer.valueOf(i));
            
        }
        
        for (int i=0; i<numbers.length; i++) {
            int remain = target - numbers[i];
            Integer index = hmap.get(Integer.valueOf(remain));
            if (remain != numbers[i] && index != null) {
                res[0] = i+1;
                res[1] = index.intValue()+1;
                break;
            }
        }
        return res;
        
    }
}

/**
 * 2. no extra space needed. sorting O(nlog(n)), then binary search n * log(n)
 * so total O(nlog(n)) time.
 * However, the additional space may still be O(n) if needing the O(nlog(n)) sorting.
 * See Two Sum II
 */
