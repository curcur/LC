/** 
 * numerator --  fenzi
 * denominator --  fenmu
 * 
 * - Fraction can not be endless
 * - Ineteger and Fraction are rational number
 * - XXXX what if it is a negative XXXX
 * - XXXX numerator & denominator both can be negative XXXX
 * - XXXX the samllest negative has one number bigger than biggest positive 
 * - $$$For the extreme case, use long instead of int!$$$
 */
 
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String sign = "";
        if ((numerator>0 && denominator<0) || (numerator<0 && denominator>0))
            sign = "-";
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long integer = num / den;
        long fraction = num % den * 10;
        
        StringBuilder sb = new StringBuilder();
        // the number -> the index in the frac, to decide the repeated part
        Map<Long, Integer> hm = new HashMap<>();
        int index = 0;
        
        while(fraction != 0) {
            if(hm.containsKey(fraction)) {
                sb.insert(hm.get(fraction), "(");
                sb.append(')');
                break;
            }
            hm.put(fraction, index++);
            sb.append(fraction/den);
            fraction = fraction % den * 10;
        }
        
        // the Integer
        if (sb.length() == 0)
            return sign + integer;
        else 
            return sign + integer + "." + sb.toString();
    }
}
