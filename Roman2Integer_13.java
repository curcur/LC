/**
 * Roman Numbers:
 * I, II, III, IV, V, VI, VII, VIII, IX, X.
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1,000
 */
 
/**
 * add each s(i) to result
 * if s(i) > s(i-1), substract 2*s(i-1);
 */
public class Solution {
    public int romanToInt(String s) {
        @SuppressWarnings("serial")
        final Map<Character, Integer> map = 
	    new HashMap<Character, Integer>() {{   
		// XXXX <should explicit the mathcing types>
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);
        }};
        
        int prev = 0, result = 0;
        for(int i=0; i<s.length(); i++) {
            int curr = map.get(s.charAt(i));
            result += curr;
            result -= (curr > prev) ? 2*prev : 0;
            prev = curr;
        }
        return result;
    }
}
