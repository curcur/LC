/**
 * - Compared to 127 Word Ladder: only needs to find the length of shortest path
 * - Need to remember the transformation path
 * - How to remember a transformation path?
 *   - 1). Do not remove from the queue, use index to link all paths
 *         This will complicate the logic, if a word can be transformed in
 *         different ways, we do not wanna input a word multiple times into
 *         the queue
 *   - 2). Use a hashmap to map the connection paths
 * - Remove a word from the dictionary only if all possible paths 
 *   transformed to it are remembered  
 */
public class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String start, String end, 
					  Set<String> dict) {
        if (start.length() != end.length() || 
	                !dict.contains(start) || !dict.contains(end))
            return res;
        
        int length = start.length();
	boolean found = false;
        Map<String, List<String>> pmap = new HashMap<>();
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        dict.remove(start);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                String s = q.poll();
                
                StringBuilder sb = new StringBuilder(s);
                for(int j=0; j<length; j++) {
                    char oc = sb.charAt(j);
                    for(char c='a'; c<='z'; c++) {
                        sb.setCharAt(j, c);
                        String trans = sb.toString();
		
                        if (dict.contains(trans)) { 
                            if (!pmap.containsKey(trans)) {
                                pmap.put(trans, new ArrayList<String>());
                                q.offer(trans);
                            }
			    pmap.get(trans).add(s);
                        }
                        
                        if (trans.equals(end)) 
			    found = true;
                    }
                    sb.setCharAt(j, oc);        // XXXX set it back
                }
            }
            // remove from dictionary
            // can not be removed the first time because there might be
            // mulitple paths transformed to the word.
            for(String s: q) 
                dict.remove(s);
            
            if(found) {
                LinkedList<String> path = new LinkedList<>();
                path.push(end);
                findAllPaths(pmap, start, path);
                break;
            }
        }
        return res;
    }
    
    private void findAllPaths(Map<String, List<String>> pmap, 
                                String start, LinkedList<String> p) {
        String s = p.peek();
        if (s.equals(start)) {
            res.add((List)(p.clone()));
            return;
        }
        
        for(String prev : pmap.get(s)) {
            p.push(prev);
            findAllPaths(pmap, start, p);
            p.pop();
        }
    }
}
