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
 * 9 ---- map(i) map(i-1)
 * 5-8 -- map(5i) map(i)...map(i)
 * 4 ---- map(i) map(5i)
 * 1-3 -- map(i)...map(i)
 */
public class Solution {
    public String intToRoman(int num) {
        @SuppressWarnings("serial")
	final Map<Integer, String> map = new HashMap<Integer, String>() {{
	    put(1000, "M"); 
            put(500,  "D"); 
	    put(100,  "C"); 
	    put(50,   "L"); 
	    put(10,   "X");
	    put(5,    "V");
	    put(1,    "I");
	}};
        
        StringBuilder sb = new StringBuilder();
        int divisor = 1000;
        while(num>0) {
            int quot = num / divisor;
            if (quot == 9)  { 
                sb.append(map.get(divisor) + map.get(divisor*10)); 
                quot = 0; 
            } else if (quot >= 5) {  // XXXX not >5
                sb.append(map.get(divisor*5)); 
                quot -= 5;
            } else if (quot == 4) {
                sb.append(map.get(divisor) + map.get(divisor*5));
                quot = 0;
            }
            
            for(;quot>0; quot--)    sb.append(map.get(divisor));
            num %= divisor; divisor /= 10;
        }
        return sb.toString();
    }
    
}
