/**
 * - Stack
 * - Corner Cases
 *   - invalid case, like /../ => return /
 *   - double //
 */
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/+");
        for(int i=0; i<strs.length; i++) {
            if(strs[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!strs[i].equals(".") && !strs[i].isEmpty()) {
                // XXXX the split string can be empty
                stack.push(strs[i]);
            }
            // else do nothing
        }
        
        if (stack.isEmpty())    return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            String str = stack.pop();
            sb.insert(0, "/" + str);
        }
        
        return sb.toString();
    }
}
