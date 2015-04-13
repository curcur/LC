/**
 * IP address has 4 parts, 0-255 in each part
 * 255.255.011.23?
 * 
 * DFS, can do it iteratively too
 * valid IP, 0-255
 * no heading 0s
 */
 
public class Solution {
    List<String> ips = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        if (length < 4 || length > 12)
            return ips;
        
        // split index
        Stack<Integer> stack = new Stack<>();
        restore(s, length, stack, 0);
        return ips;
    } 
    
    private void restore(String s, int length, 
			 Stack<Integer> stack, int level) {
        if(level == 3) {
            if(valid(s.substring(stack.peek()+1, length)))
                ips.add(pack(s, stack, length));
            return;
        }
        
        int start = level == 0 ? 0 : stack.peek()+1;
        for(int i=start; i<start+3 && i<length; i++) {
            if (valid(s.substring(start, i+1))) {
                stack.push(i);
                restore(s, length, stack, level+1);
                stack.pop();
            }
        }
    }
    
    // test whether the ip partitioned ip is valid
    private boolean valid(String s) {
        int length = s.length();
        if (length > 3 || length == 0)  return false;
        // can not start with zero
	if (length > 1 && s.charAt(0) == '0')   return false;  
	
	int ip = Integer.valueOf(s);        
        return ip>=0 && ip<=255;
    }
    
    // pack the ip to ip format string
    private String pack(String s, Stack<Integer> stack, int length) {
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for(Integer i : stack) {
            sb.append(s.substring(prev, i+1));
            sb.append('.');
            prev = i+1;
        }
        sb.append(s.substring(prev, length));
        return sb.toString();
    }
}
