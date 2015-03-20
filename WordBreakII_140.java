/**
 * DFS
 * - Return all solutions normally we use DFS
 * - the pure DFS is Time Limit Exceeded
 * - possible pruning: P[i] = possible solution beginning from s[i]? to avoid repeat useless branches
 * - compare whether the result size is enlarged to decide P[i] true of false
 */

public class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s.length() == 0)    return res;
        
        boolean[] P = new boolean[s.length()+1];
        Arrays.fill(P, true);
        
        // P's information can be learned during the DFS, so we do not need to calculate it first
        /*for(int i=s.length()-1; i>=0; i--) {
            for(int j=s.length()-1; j>=i; j--)
                if (dict.contains(s.substring(i, j+1)) && P[j+1])  { 
                    P[i] = true;
                    break;
                }
        }*/
        
        List<Integer> path = new LinkedList<>();
        path.add(0);
        wordBreak(s, 0, path, dict, P);
        return res;
    }
    
    private void wordBreak(String s, int start, List<Integer> path, Set<String> dict, boolean[] P) {
        
        if (start == s.length()) {
            if (path.size() >1) res.add(path2String(s, path));
            return;
        }
        
        for(int i=start; i<s.length(); i++)
            if (dict.contains(s.substring(start, i+1)) && P[i+1]) {   // pruning
                path.add(i+1);
                int beforesize = res.size();
                wordBreak(s, i+1, path, dict, P);
                int aftersize = res.size();
                path.remove(path.size()-1);
                if (aftersize == beforesize)    P[i+1] = false;
            }
    }
    
    private String path2String(String s, List<Integer> path) {
        StringBuilder sb = new StringBuilder(s.substring(path.get(0), path.get(1)));
        for(int i=2; i<path.size(); i++) {
            sb.append(' ');
            sb.append(s.substring(path.get(i-1), path.get(i)));
        }
        return sb.toString();
    }
}
