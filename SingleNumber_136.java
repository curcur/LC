/**
 * Using HashMap, but it does not allow extra space
 * 
 * So we use $$$$$$$$   XOR
 */ 
public class Solution {
    public int singleNumber(int[] A) {
        int number = 0;
        for (int i : A) { number ^= i; }
        
        return number;
    }
}
