public class Solution {
    public int singleNumber(int[] A) {
        int number = 0, offset = 0x80000000, num1 = 0;
        for(int i=0; i<32; i++) {
            num1 = 0;
            for(int j=0; j<A.length; j++) {
                if ((offset & A[j]) != 0) num1++;
            }
            number = (number << 1) + (num1 % 3);
            offset = offset >>> 1;
        }
        return number;
    }
}
