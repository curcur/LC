/**
 * 1. Element Counting
 */
/*public class Solution {
    public int majorityElement(int[] num) {
        int element = num[0], count = 0;
        
        for (int e : num) {
            
            if (element == e) { count++; continue; }
            
            // element != e
            if (count == 0) { element = e; count++; }
            else count--;
        }
        
        return element;
    }
}*/

/**
 * 2. Bit Caculation
 */
 
 public class Solution{
     public int majorityElement(int[] num) {
         
         int majority = 0;
         int offset = 0x80000000;   // XXX 1 number 4 bit, 2 number 8 bit; java integer 4 bytes (8 number).
         
         for (int i=0; i<32; i++) {
             int count = 0;         // count of 1s
         
             for (int j=0; j<num.length; j++) {
                 // num[j]'s i_th bit
                 if ((num[j] & offset) != 0)   count++;
             }
             
             majority = majority << 1;
             if (count >= num.length/2 + 1)
                majority += 1; 
             
             offset = offset >>> 1; // XXX must use unsigned right shift, otherwise will keep the sign.
         }
         return majority;
     }
 }
