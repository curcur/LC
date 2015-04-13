/**
 * - read in length L words each time
 * - justify it
 */
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        int start = 0, end = 0, length = words.length, clength = 0;
        List<String> strs = new ArrayList<>();
        if (length == 0)    return strs;        // empty input
        
        while(end < length) {
            int wl = words[end].length();
            // new word can not be added into the line
            if (clength + wl > L) {
                strs.add(pad(words, L, start, end-1, clength));
                clength = wl+1;  // word length + space
                start = end; 
            } else {
                clength += wl+1;
            }
            end++;
        }
        
        // last line
        StringBuilder sb = new StringBuilder();
        clength--;
        sb.append(words[start]);
        for(int i=start+1; i<end; i++) {
            sb.append(' ');
            sb.append(words[i]);
        }
        
        // padding spaces
        for(int i=clength; i<L; i++)
            sb.append(' ');
        strs.add(sb.toString());
        
        return strs;
    }
    
    private String pad(String[] words, int L, int start, int end, int clength) {
        int padding = 1, slots = end - start;
        clength--;  // the trailing space is cut
        StringBuilder sb = new StringBuilder();
        
        // single word
        if (slots == 0) {
            sb.append(words[end]);
            for(int i=clength; i<L; i++) 
                sb.append(' ');
        }
        else {
            padding += (L-clength) / slots;
            int leftPcount = (L-clength) % slots;
            for(int i=start; i<end; i++) {
                sb.append(words[i]);
                // padding space
                for(int p=1; p<=padding; p++) {
                    sb.append(' ');
                    if (leftPcount-- > 0)
                        sb.append(' ');
                }
            }
            sb.append(words[end]);
        }
        return sb.toString();
    }
}
