public class Solution {
    private static final Map<Character, Character> match = new HashMap<Character, Character>() {{ 
        put('(', ')'); put('{', '}'); put('[', ']'); 
    }};
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (match.containsKey(c)) stack.push(c); 
            else if (stack.isEmpty() || match.get(stack.pop()) != c)  return false;   
        }
       
        //if (!stack.isEmpty())   return false;
        //return true;
        return stack.isEmpty();
    }
}
