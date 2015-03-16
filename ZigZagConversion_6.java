public class Solution {
    public String convert(String s, int nRows) {
        
        String convertString = new String();
        int slide = nRows + nRows - 2;          // sliding length
        
        if (nRows == 1) slide = 1;
        
        for (int i=0; i<nRows; i++) {           // row loop
            int index = i;
            
            while(index < s.length()) {         // column loop
                
                convertString += s.charAt(index);
                
                if((i!=0) && (i!=nRows-1)) {     // not the first or last row
                    int zigindex = index + slide - i * 2;
                    
                    if (zigindex >= s.length())   break;
                    
                    convertString += s.charAt(zigindex);
                    
                }
                index += slide;
            }
        }
        
        return convertString;
        
    }
}
