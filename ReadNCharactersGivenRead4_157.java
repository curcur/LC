/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] tbuf = new char[4];
    
    public int read(char[] buf, int n) {
        int index = 0;
        while(index < n) {
            int bytes = read4(tbuf);
            for(int i=0; i<bytes && index<n ;)
                buf[index++] = tbuf[i++];
            if (bytes < 4)  break;          // XXXXXX  this must have
        }
        //return index+1;                   // XXXXXX
        return index;
    }
}
