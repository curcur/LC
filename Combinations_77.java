/**
 * DFS
 * - LinkedList vs Stack
 *  LinkedList is pushed and poped in the front
 *  Stack is pushed and poped in the end
 * 
 * - Another Way:
 *  C(n,k) = C(n-1, k-1) U n + C(n-1,k)
 * However, this will require a lot of copy.
 * So I do not think this is a good method, but good try
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k > n || n == 0 || k == 0)  return res;
        Stack<Integer> stack = new Stack<>();

        // XXXX the initial state is empty stack
        combine(n, k, stack, 0, 1);
        return res;
    }
    
    private void combine(int n, int k, Stack<Integer> stack, 
			 int level, int start) {
        if (level == k) {
            res.add((List)(stack.clone()));
            return;
        }
        
        for(int i=start; i<=n; i++) {
            stack.push(i);
            combine(n, k, stack, level+1, i+1);
            stack.pop();
        }
    }
}
