/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/*public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     *
    char[] tbuf = new char[4];
    char[] prevbuf = new char[4];
    int prevlength = 0, previndex = 0;
    
    public int read(char[] buf, int n) {
        int index = 0;
        
        // from previous read
        while(index < n && previndex < prevlength)
            buf[index++] = prevbuf[previndex++];
        
        if(previndex == prevlength)    { previndex = 0; prevlength = 0; }
        
        int i = 0, bytes = 0;
        while(index < n) {
            bytes = read4(tbuf);
            
            i = 0;
            while(i<bytes && index<n) 
                buf[index++] = tbuf[i++];
            
            if (bytes < 4) break;
        }
        
        // write into prevbuf the remaining in tbuf
        while(i<bytes)  prevbuf[prevlength++] = tbuf[i++];
        
        return index;
    }
}*/

/**
 * Do not need prevbuf at all
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] tbuf = new char[4];
    int i = 0, bytes = 0;
    
    public int read(char[] buf, int n) {
        int index = 0;
        
        // from previous read
        while(index < n && i < bytes)
            buf[index++] = tbuf[i++];
        
        while(index < n) {
            bytes = read4(tbuf);
            
            i = 0;
            while(i<bytes && index<n) 
                buf[index++] = tbuf[i++];
            
            if (bytes < 4) break;
        }
        
        return index;
    }
}
