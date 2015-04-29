public class Solution {
    public int titleToNumber(String s) {
        int length = s.length();
        int num = 0;
        
        final int BASE = 26;
        
        for(int i=0; i<length; i++) {
            int c = s.charAt(i) - 'A' + 1;
            num = num*BASE + c;
        }
        return num;
    }
}
