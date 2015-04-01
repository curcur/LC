public class Solution {
    public String addBinary(String a, String b) {
        int alength = a.length(), blength = b.length();
        // a is the longer string
        if (alength < blength) 
            return addBinary(b, a);
        
        int carry = 0, ai = alength-1, bi = blength-1;
        StringBuilder sb = new StringBuilder();
        final int MOD = 2;
        
        while(ai>=0) {
            int sum = a.charAt(ai--) - '0' + carry;
            // have error if putting together with the previous statement
            sum += bi>=0 ? b.charAt(bi--) - '0' : 0;  
            carry = sum / MOD;
            sb.insert(0, (char)(sum%MOD + '0'));
        }
        
        // the carry
        if (carry > 0)
            sb.insert(0, '1');
        
        return sb.toString();
    }
}
