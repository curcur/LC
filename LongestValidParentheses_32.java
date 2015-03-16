/**
 * 1. Sliding Window --- Best
 * if ) > (, then definitly invalid, then sliding window restart from i = j;
 * the hard part is when ( < ), and s reaches the end
 * 
 * This solution is O(n) without using any extra space!
 * 
 */
/*public class Solution {
    public int longestValidParentheses(String s) {
        // i,j index of sliding window
        // l,r number of left/right parenthesis in the sliding window
        // maxlen: max length of valid parenthesis
        int maxlen = 0, l = 0, r = 0, i = 0, j = 0;
        while(j<s.length()) {
            if(s.charAt(j++) == '(') l++;
            else r++;
            if (r > l) {
                maxlen = Math.max(maxlen, 2*l);
                l = 0; r = 0;
                i = j;
            }
        }
        
        // XXXXXXXXXXXXXXXXXXXXXXXXXXXX, the following is wrong
        // maxlen = Math.max(maxlen, 2 * Math.min(l, r));  // the last one, in case r is smaller than l
        
        // in this case, r <= l
        j = s.length()-1; l = 0; r = 0;
        while(j>=i) {
            if(s.charAt(j--) == '(')  l++;
            else r++;
            if (l > r) { 
                maxlen = Math.max(maxlen, 2*r); 
                l = 0; r = 0;
            }
        }
        
        maxlen = Math.max(maxlen, 2*r);
        return maxlen;
    }
}*/

/**
 * 2. Stack
 * pop all paired parenthesis, and leave un-paired parenthesis in the stack!
 * -- It is actually similar to 1 (1 is calualting max length at the same time)
 * -- can also cal maxlen in the procudure push stack, similar to 1)'s condition r > l
 */
/*public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || stack.isEmpty() || s.charAt(stack.peek()) != '(')
                stack.push(i);
            else stack.pop();
        }
        
        if (stack.isEmpty())    return s.length();
        int maxlen = 0, top = s.length();
        while(!stack.isEmpty()) {
            int i = stack.pop();
            maxlen = Math.max(maxlen, top-i-1);
            top = i;
        }
        maxlen = Math.max(maxlen, top);     /// XXXXXXXXXX the first one might!!!!
        return maxlen;
    }
}*/

/**
 * 3. DP 
 * -- longest/shortest length: 1 DP with F[i] starting with/ending with
 * -- F[i] -- longest length of valid parenthesis substring starting from i
 *            if s[i] == ')' F[i] = 0
 *            else if s[i+1] == ')' F[i] = F[i+2] + 2
 *            else if s[i+1] == '(' if s[F[i+1] + i+1] == '('   F[i] = 0
 *                                  else F[i] = F[i+1] + 2 + F[i+1+F[i+1]+1]
 * 
 * OR
 * -- D[i] -- longest length of valid parenthesis ending with i also works, similar to F[i]
 *            if s[i] == '(' D[i] = 0
 *            else if s[i-1] == '(' D[i] = D[i-2] + 2   
 *            else if s[i-1] == ')' if s[i-1-D[i-1]] == ')'     D[i] = 0
 *                                  else D[i] = D[i-1] + 2 + D[i-1-D[i-1]-1]
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0)  return 0;
        int length = s.length(), maxlen = 0;
        int[] F = new int[length];
        F[length-1] = 0;
        
        for(int i=length-2; i>=0; i--) {
            if (s.charAt(i) == ')' || i+1 >=length) { F[i] = 0; }
            else if (s.charAt(i+1) == ')') { 
                F[i] = 2;
                if (i+2 < length) F[i] += F[i+2];
            }else { // s.char(i+1) == '('
                if (F[i+1] + i+1 >= length || s.charAt(F[i+1] + i+1) == '(')    F[i] = 0;
                else { 
                    F[i] = F[i+1] + 2;
                    if (F[i+1] + i+1 +1 < length) F[i] += F[F[i+1] + i+1 +1];
                }
            }
            maxlen = Math.max(maxlen, F[i]);
        }
        
        return maxlen;
    }
    
}
