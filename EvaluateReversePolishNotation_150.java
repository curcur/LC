public class Solution {
    
    private static class OP {
        //XXXXXXXXXXX Arrays.asList(,,,)
        static final HashSet<String> op = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        static boolean contains(String token) { return op.contains(token); }
        static int calculate(String operator, int r, int l) {
            switch(operator) {
                case "+": return l+r;
                case "-": return l-r;
                case "*": return l*r;
                case "/": return l/r;
                default : System.err.println("Wrong Operator!"); return 0;
            }
        }
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            if (OP.contains(token)) stack.push(OP.calculate(token, stack.pop(), stack.pop()));
            else stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }
}
