/**
 * Question to ask: -- how to represent the string? 
 *                     least significant from beginning or last significant from beginning?
 * normal string -> number
 * Or you can reverse it yourself.
 */ 
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))   return "0";
        StringBuilder res = new StringBuilder();
        
        for(int i=0; i<=num1.length()+num2.length()-2; i++)
            res.append('0');
        
        for(int i=num1.length()-1; i>=0; i--) {
            int m1 = char2int(num1.charAt(i));
            int carry = 0;
            int j = num2.length()-1;
            for(; j>=0; j--) {
                int m2 = char2int(num2.charAt(j));
                int temp = m1 * m2 + carry + char2int(res.charAt(i+j));
                res.setCharAt(i+j, int2char(temp % 10));
                carry = temp/10;   // carry can not >= 10
            }
            if (carry > 0) {
                if (i+j >=0)  // j = -1 XXXXXXXXXXX originally I put i+j-1 here
                    res.setCharAt(i+j, int2char(carry));
                else
                    res.insert(0, int2char(carry));
            }
        }
        
        return res.toString();
    }
    
    private int char2int(char c) { return c-'0'; }
    private char int2char(int i) { return (char)(i+'0'); }
}
