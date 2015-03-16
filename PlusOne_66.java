/**
 * This is too bad they have int[] as input, should be a vector or list
 * If it is the in-place list, we can break as soon as carry = 0
 **/
public class Solution {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        int carry = 1;
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i] == 9 && carry == 1)    list.addFirst(0);
            else { 
                list.addFirst(digits[i]+carry);
                carry = 0;
            }
        }
        
        if (carry > 0) list.addFirst(carry); carry = 0;        // XXXXXX The first number is from carry
        
        int[] number = new int[list.size()];
        int index = 0;
        for(int i: list) number[index++] = i;
        return number;
        
    }
}
