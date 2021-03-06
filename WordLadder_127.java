/**
 * shortest transformation path: BFS
 */

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (!dict.contains(start) || !dict.contains(end))   return 0;
        if (start.equals(end))  return 1;
        
        Queue<String> q = new LinkedList<String>();
        q.offer(start); dict.remove(start);
        int length = 0;
        
        while(!q.isEmpty()) {
            length++;
            int size = q.size();
            for(int j=0; j<size; j++) {
                String s = q.poll();
                
                StringBuilder sb = new StringBuilder(s);
                for(int i=0; i<sb.length(); i++) {
                    char oc = sb.charAt(i);
                    for(char c='a'; c<='z'; c++) {
                        sb.setCharAt(i, c);
                        String ts = sb.toString();
                        if (dict.contains(ts)) {
                            // XXX length+1, not length
			    if (ts.equals(end)) return length+1;  
			    
                            dict.remove(ts); 
                            q.offer(ts);
                        }
                    }
                    sb.setCharAt(i, oc);
                }
            }
        }
        return 0;
    }
}
